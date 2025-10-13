// Contadores iniciales
let contadorSillones = 0;
let contadorGenteCosiendo = 0;
let contadorFabricas = 0;
let contadorIkeas = 0;

// Precios iniciales
let precioGente = 10;
let precioFabrica = 50;
let precioIkea = 200;

// botones basicos
const contadorEnPantalla = document.getElementById("Contador");
const sillonesSegundo = document.getElementById("sillonesSegundo");
const reset = document.getElementById("reset");
const imagen = document.getElementById("imagen-click");

// Contadores de los edificios
const botonComprarGente = document.getElementById("comprar-gente");
const botonComprarFabrica = document.getElementById("comprar-fabrica");
const contadorIkeasCompradas = document.getElementById("contadorIkeas");

// Compras de los edificios
const contadorGenteComprada = document.getElementById("contadorGente");
const contadorFabricasCompradas = document.getElementById("contadorFabricas");
const botonComprarIkea = document.getElementById("comprar-ikea");

// Precios de los edificios
const precioGenteBoton = document.getElementById("precioGente");
const precioFabricaBoton = document.getElementById("precioFabrica");
const precioIkeaBoton = document.getElementById("precioIkea");

// Aumentar el contador
imagen.addEventListener("click", () => {
  contadorSillones++;
  contadorEnPantalla.textContent = contadorSillones;
});

// Aumentar sillones automáticamente
function aumentarSillonesAutomaticamente() {
  const genteCosiendo = 1;
  const fabricas = 5;
  const ikeas = 20;

  contadorSillones += contadorGenteCosiendo * genteCosiendo;
  contadorSillones += contadorFabricas * fabricas;
  contadorSillones += contadorIkeas * ikeas;

  contadorEnPantalla.textContent = contadorSillones;
  sillonesSegundo.textContent =
    contadorGenteCosiendo * genteCosiendo +
    contadorFabricas * fabricas +
    contadorIkeas * ikeas +
    " sillones/seg";
}

// Para guardar
function guardarProgreso() {
  const datos = {
    sillones: contadorSillones,
    gente: contadorGenteCosiendo,
    fabricas: contadorFabricas,
    ikeas: contadorIkeas,
    precioGente: precioGente,
    precioFabrica: precioFabrica,
    precioIkea: precioIkea,
  };
  localStorage.setItem("clickerSillones", JSON.stringify(datos));
}

// para cargar
function cargarProgreso() {
  const datosGuardados = localStorage.getItem("clickerSillones");
  if (datosGuardados) {
    const datos = JSON.parse(datosGuardados);
    contadorSillones = datos.sillones || 0;
    contadorGenteCosiendo = datos.gente || 0;
    contadorFabricas = datos.fabricas || 0;
    contadorIkeas = datos.ikeas || 0;
    precioGente = datos.precioGente || 10;
    precioFabrica = datos.precioFabrica || 50;
    precioIkea = datos.precioIkea || 200;

    // Actualizar pantalla
    contadorEnPantalla.textContent = contadorSillones;
    contadorGenteComprada.textContent = contadorGenteCosiendo;
    contadorFabricasCompradas.textContent = contadorFabricas;
    contadorIkeasCompradas.textContent = contadorIkeas;
    precioGenteBoton.textContent = precioGente;
    precioFabricaBoton.textContent = precioFabrica;
    precioIkeaBoton.textContent = precioIkea;
  }
}

// Resetear todo
reset.addEventListener("click", () => {
  if (confirm("¿Seguro que quieres reiniciar el progreso?")) {
    localStorage.removeItem("clickerSillones");
    location.reload();
  }
});

// Para ejecutar cada segundo los aumentos de sillones
setInterval(aumentarSillonesAutomaticamente, 1000);

// Para guardar cada 5 segundos
setInterval(guardarProgreso, 5000);

// Cargar al iniciar
cargarProgreso();

// Gente cosiendo
botonComprarGente.addEventListener("click", () => {
  if (contadorSillones < precioGente) {
    alert("No tienes suficientes sillones para contratar a alguien.");
    return;
  }
  contadorSillones -= precioGente;
  contadorEnPantalla.textContent = contadorSillones;
  contadorGenteCosiendo++;
  contadorGenteComprada.textContent = contadorGenteCosiendo;
  precioGente = Math.round(precioGente * 1.2);
  precioGenteBoton.textContent = precioGente;
});

// Fabricas
botonComprarFabrica.addEventListener("click", () => {
  if (contadorSillones < precioFabrica) {
    alert("No tienes suficientes sillones para comprar una fábrica.");
    return;
  }
  contadorSillones -= precioFabrica;
  contadorEnPantalla.textContent = contadorSillones;
  contadorFabricas++;
  contadorFabricasCompradas.textContent = contadorFabricas;
  precioFabrica = Math.round(precioFabrica * 1.2);
  precioFabricaBoton.textContent = precioFabrica;
});

// Ikeas
botonComprarIkea.addEventListener("click", () => {
  if (contadorSillones < precioIkea) {
    alert("No tienes suficientes sillones para comprar un Ikea, pringao.");
    return;
  }
  contadorSillones -= precioIkea;
  contadorEnPantalla.textContent = contadorSillones;
  contadorIkeas++;
  contadorIkeasCompradas.textContent = contadorIkeas;
  precioIkea = Math.round(precioIkea * 1.2);
  precioIkeaBoton.textContent = precioIkea;
});
