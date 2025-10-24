const BASE = "https://api.batmanapi.com/v1";
const fallbackImage =
  "https://upload.wikimedia.org/wikipedia/commons/3/3d/Batman_logo.svg";

const resultsEl = document.getElementById("results");
const detailEl = document.getElementById("detail");
const qInput = document.getElementById("q");
const applyBtn = document.getElementById("applyBtn");

function buildQuery(params) {
  const esc = (s) => encodeURIComponent(s);
  const parts = [];
  for (const k in params) {
    if (params[k] == null || params[k] === "") continue;
    parts.push(`${esc(k)}=${esc(params[k])}`);
  }
  return parts.length ? "?" + parts.join("&") : "";
}

async function fetchCharacters({ q = "" } = {}) {
  const params = {};
  if (q) params["filters[name][$containsi]"] = q;
  const url = `${BASE}/characters${buildQuery(params)}`;
  const res = await fetch(url);
  if (!res.ok) throw new Error(`HTTP ${res.status}`);
  return await res.json();
}

function renderList(data) {
  resultsEl.innerHTML = "";
  if (!data || !data.data || data.data.length === 0) {
    resultsEl.innerHTML = "<div>No se encontraron resultados.</div>";
    return;
  }
  data.data.forEach((item) => {
    const id = item.id;
    const a = item.attributes || {};
    const card = document.createElement("div");
    card.className = "card";
    let imgUrl = a.image_url || "";
    if (imgUrl && !imgUrl.startsWith("http"))
      imgUrl = `https://api.batmanapi.com${imgUrl}`;
    const safeImgUrl =
      imgUrl && !imgUrl.includes("example.com")
        ? `https://api.allorigins.win/raw?url=${encodeURIComponent(imgUrl)}`
        : fallbackImage;
    card.innerHTML = `
      <img src="${safeImgUrl}" alt="${a.name}" loading="lazy"/>
      <h4>${a.name || a.alias || "Sin nombre"}</h4>
      <div><strong>Alias:</strong> ${a.alias || "-"}</div>
      <div><strong>Rol:</strong> ${a.role || "-"}</div>
      <button data-id="${id}">Ver detalle</button>
    `;
    resultsEl.appendChild(card);
    card
      .querySelector("button[data-id]")
      .addEventListener("click", () => showDetail(id));
  });
}

async function showDetail(id) {
  detailEl.textContent = "Cargando...";
  const res = await fetch(`${BASE}/characters/${id}`);
  if (!res.ok) {
    detailEl.textContent = "Error al cargar detalle";
    return;
  }
  const json = await res.json();
  detailEl.textContent = JSON.stringify(json, null, 2);
}

async function load() {
  applyBtn.disabled = true;
  const q = qInput.value.trim();
  try {
    const json = await fetchCharacters({ q });
    renderList(json);
  } catch (err) {
    resultsEl.innerHTML = `<div style="color:red">Error: ${err.message}</div>`;
  } finally {
    applyBtn.disabled = false;
  }
}

applyBtn.addEventListener("click", load);
load();
