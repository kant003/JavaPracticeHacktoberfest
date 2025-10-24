console.log("🕒 Iniciando el reloj...\n");

let segundos = 0;
const intervalo = setInterval(() => {
  const ahora = new Date();
  const hora = ahora.toLocaleTimeString();
  console.log(`Hora actual: ${hora}`);
  segundos++;

  if (segundos >= 10) {
    clearInterval(intervalo);
    console.log("\n⏹️ Reloj finalizado!");
  }
}, 1000);