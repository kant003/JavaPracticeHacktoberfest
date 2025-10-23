from collections import deque, defaultdict
from typing import Iterable, List, Tuple, Dict, Any, Optional

class AhoCorasick:
    """
    Aho–Corasick para búsqueda de múltiples patrones.
    - add(pattern, tag): añade un patrón (tag opcional para identificarlo).
    - build(): construye enlaces de fallo y listas de salida.
    - find(text): devuelve lista de (end_index, tag, pattern_len).
    - find_stream(chunks): igual que find pero sobre un iterable de chunks (streaming).
    """
    __slots__ = ("next", "fail", "out", "built")

    def __init__(self):
        # next: lista de dicts (transiciones), fail: lista de enteros (sufijo-liga)
        # out: lista de listas [(tag, len_pat), ...]
        self.next: List[Dict[str, int]] = [defaultdict(int)]  # estado 0 (raíz)
        self.fail: List[int] = [0]
        self.out:  List[List[Tuple[Any, int]]] = [[]]
        self.built = False

    def add(self, pattern: str, tag: Optional[Any] = None):
        if self.built:
            raise RuntimeError("No se pueden añadir patrones tras build().")
        if not pattern:
            return
        u = 0
        for ch in pattern:
            if ch not in self.next[u]:
                self.next[u][ch] = len(self.next)
                self.next.append(defaultdict(int))
                self.fail.append(0)
                self.out.append([])
            u = self.next[u][ch]
        self.out[u].append((tag if tag is not None else pattern, len(pattern)))

    def build(self):
        """Construye la cola BFS para enlaces de fallo y completa transiciones faltantes."""
        q = deque()
        # Inicializa fallos de hijos directos de la raíz a 0
        for ch, v in list(self.next[0].items()):
            self.fail[v] = 0
            q.append(v)

        # Completa transiciones inexistentes en raíz como bucles a 0
        # (No estrictamente necesario si comprobamos dict, pero acelera en práctica)
        self.built = True

        while q:
            u = q.popleft()
            # mezcla salidas heredadas por enlace de fallo
            for (tag, ln) in self.out[self.fail[u]]:
                self.out[u].append((tag, ln))
            # propaga
            for ch, v in list(self.next[u].items()):
                q.append(v)
                # calcular fail[v]
                f = self.fail[u]
                while f and ch not in self.next[f]:
                    f = self.fail[f]
                self.fail[v] = self.next[f][ch] if ch in self.next[f] else 0

    def _advance(self, state: int, ch: str) -> int:
        """Transita desde `state` con `ch`, siguiendo fallos hasta encontrar transición o raíz."""
        while state and ch not in self.next[state]:
            state = self.fail[state]
        return self.next[state][ch] if ch in self.next[state] else 0

    def find(self, text: str) -> List[Tuple[int, Any, int]]:
        """Devuelve coincidencias como (end_index, tag, len_pattern)."""
        if not self.built:
            self.build()
        res: List[Tuple[int, Any, int]] = []
        s = 0
        for i, ch in enumerate(text):
            s = self._advance(s, ch)
            if self.out[s]:
                for tag, ln in self.out[s]:
                    res.append((i, tag, ln))  # match termina en i
        return res

    def find_stream(self, chunks: Iterable[str]) -> Iterable[Tuple[int, Any, int]]:
        """
        Versión streaming: itera sobre chunks (p.ej., líneas de un archivo grande).
        Emite (end_index_global, tag, len_pat).
        """
        if not self.built:
            self.build()
        s = 0
        pos = 0
        for chunk in chunks:
            for ch in chunk:
                s = self._advance(s, ch)
                if self.out[s]:
                    for tag, ln in self.out[s]:
                        yield (pos, tag, ln)
                pos += 1


# ===================== Ejemplo de uso =====================

if __name__ == "__main__":
    ac = AhoCorasick()
    patrones = [
        ("he", "HE"),
        ("she", "SHE"),
        ("his", "HIS"),
        ("hers", "HERS"),
        ("aba", "ABA"),
        ("bab", "BAB"),
    ]
    for p, t in patrones:
        ac.add(p, t)

    ac.build()

    texto = "ushers absorb shabby his hers he she ababa"
    hits = ac.find(texto)

    # Mostrar coincidencias como (inicio, fin, tag, match)
    resultados = []
    for end, tag, ln in hits:
        start = end - ln + 1
        resultados.append((start, end, tag, texto[start:end+1]))

    # Orden por posición
    resultados.sort(key=lambda x: (x[0], x[1]))

    for (s, e, tag, match) in resultados:
        print(f"[{s}:{e}] {match!r} -> {tag}")

    # Streaming (simula leer por trozos)
    stream = ["ushe", "rs absorb ", "shabby his hers he she ", "ab", "aba"]
    for end, tag, ln in ac.find_stream(stream):
        s = end - ln + 1
        # Nota: aquí no tenemos el texto completo para imprimir el s
