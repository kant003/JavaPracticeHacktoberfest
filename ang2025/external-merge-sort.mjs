import fs from "fs";
import os from "os";
import path from "path";
import readline from "readline";
import { PriorityQueue } from "./priority-queue.mjs";

/**
 * Ordena un archivo de texto (línea a línea) externamente.
 * - inputPath: archivo de entrada
 * - outputPath: archivo ordenado de salida
 * - options:
 *    chunkLines: nº de líneas por bloque (p.ej. 200_000)
 *    tmpDir: directorio temporal
 *    compare: (a,b) => a.localeCompare(b) por defecto
 */
export async function externalMergeSort(inputPath, outputPath, {
  chunkLines = 200_000,
  tmpDir = os.tmpdir(),
  compare = (a, b) => a.localeCompare(b)
} = {}) {
  if (!fs.existsSync(inputPath)) throw new Error("Input no existe");

  // 1) Particionado en chunks
  const tmpFiles = await splitAndSortChunks(inputPath, { chunkLines, tmpDir, compare });

  // 2) Fusión k-vías con min-heap
  await kWayMerge(tmpFiles, outputPath, compare);

  // 3) Limpieza
  for (const f of tmpFiles) fs.unlinkSync(f);
}

async function splitAndSortChunks(inputPath, { chunkLines, tmpDir, compare }) {
  const rl = readline.createInterface({
    input: fs.createReadStream(inputPath, { encoding: "utf8" }),
    crlfDelay: Infinity
  });

  let buf = [];
  const tmpFiles = [];
  let idx = 0;

  for await (const line of rl) {
    buf.push(line);
    if (buf.length >= chunkLines) {
      tmpFiles.push(await flushChunk(buf, tmpDir, idx++, compare));
      buf = [];
    }
  }
  if (buf.length) tmpFiles.push(await flushChunk(buf, tmpDir, idx++, compare));
  return tmpFiles;
}

async function flushChunk(lines, tmpDir, idx, compare) {
  lines.sort(compare);
  const tmpPath = path.join(tmpDir, `ems_chunk_${Date.now()}_${idx}.txt`);
  await fs.promises.writeFile(tmpPath, lines.join("\n") + "\n", "utf8");
  return tmpPath;
}

async function kWayMerge(tmpFiles, outputPath, compare) {
  const readers = tmpFiles.map(f => readline.createInterface({
    input: fs.createReadStream(f, { encoding: "utf8" }),
    crlfDelay: Infinity
  }));

  // Inicializar heap con primera línea de cada reader
  const heap = new PriorityQueue((a, b) => compare(a.line, b.line));
  const current = await Promise.all(readers.map(r => r[Symbol.asyncIterator]().next()));
  const iters = readers.map(r => r[Symbol.asyncIterator]());

  for (let i = 0; i < current.length; i++) {
    if (!current[i].done) heap.push({ line: current[i].value, i });
  }

  const out = fs.createWriteStream(outputPath, { encoding: "utf8" });
  while (heap.size()) {
    const { line, i } = heap.pop();
    out.write(line + "\n");

    const nxt = await iters[i].next();
    if (!nxt.done) heap.push({ line: nxt.value, i });
  }
  await new Promise(r => out.end(r));
  for (const r of readers) r.close();
}

/* Ejemplo:
await externalMergeSort("./input.txt", "./sorted.txt", {
  chunkLines: 300000,
  compare: (a,b) => a.localeCompare(b, "es", { sensitivity: "base" })
});
*/
