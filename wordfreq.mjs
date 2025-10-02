#!/usr/bin/env node
import fs from "fs";
import readline from "readline";
import path from "path";
import url from "url";

// --- Utilidad CLI ---
const toArgs = (arr) =>
  Object.fromEntries(
    arr.map((a) => {
      const m = a.match(/^--([^=]+)=(.*)$/);
      return m ? [m[1], m[2]] : [a.replace(/^--/, ""), true];
    })
  );

// Stopwords mínimas ES/EN (puedes ampliarlas)
const STOPWORDS = new Set([
  // ES
  "el","la","los","las","un","una","unos","unas","y","o","u","de","del","al","a","en",
  "que","con","por","para","se","su","sus","es","ser","esta","este","esto","son","como",
  "no","si","sí","ya","muy","más","menos","pero","también","porque","cuando","donde",
  // EN
  "the","a","an","and","or","of","to","in","on","for","is","are","was","were","be","as",
  "it","its","this","that","with","by","not","at","from","your","you","we"
]);

/**
 * Algoritmo: K palabras más frecuentes con procesamiento en streaming.
 * Complejidad ~ O(n) en número de tokens; memoria O(u) en nº de palabras únicas.
 */
export async function topKWords(filePath, { k = 10, ignoreStopwords = true } = {}) {
  if (!fs.existsSync(filePath)) {
    throw new Error(`No existe el archivo: ${filePath}`);
  }

  const freq = new Map();

  const rl = readline.createInterface({
    input: fs.createReadStream(filePath, { encoding: "utf8" }),
    crlfDelay: Infinity
  });

  // Normalización: minúsculas, quitar tildes, separar por no alfanumérico (incluye ñ)
  for await (const line of rl) {
    const norm = line
      .toLowerCase()
      .normalize("NFD")                // separa tildes
      .replace(/[\u0300-\u036f]/g, ""); // elimina marcas diacríticas

    const tokens = norm.split(/[^a-z0-9áéíóúüñ]+/i).filter(Boolean);

    for (const t of tokens) {
      if (ignoreStopwords && STOPWORDS.has(t)) continue;
      freq.set(t, (freq.get(t) ?? 0) + 1);
    }
  }

  // Obtener top K (método simple: ordenar pares)
  const top = [...freq.entries()]
    .sort((a, b) => b[1] - a[1])
    .slice(0, k)
    .map(([word, count]) => ({ word, count }));

  return { totalUnique: freq.size, top };
}

// --- Ejecutable CLI ---
if (process.argv[1] === url.fileURLToPath(import.meta.url)) {
  const args = toArgs(process.argv.slice(2));
  const file = args._ || Object.keys(args).find((k) => !k.includes("=") && k !== "k" && k !== "noStop");
  const fileArg = typeof args._ === "string" ? args._ : file;

  const filePath =
    args.file || fileArg || (() => { throw new Error("Uso: wordfreq <archivo> [--k=20] [--noStop=true]"); })();

  const k = Number(args.k ?? 10);
  const ignoreStopwords = !(String(args.noStop ?? "false") === "true");

  topKWords(path.resolve(filePath), { k, ignoreStopwords })
    .then((res) => {
      console.log(`Palabras únicas: ${res.totalUnique}`);
      console.log(`Top ${k}:`);
      for (const { word, count } of res.top) {
        console.log(`${word}\t${count}`);
      }
    })
    .catch((e) => {
      console.error("Error:", e.message);
      process.exit(1);
    });
}

