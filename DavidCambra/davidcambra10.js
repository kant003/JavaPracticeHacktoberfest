const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

const EUR_TO_USD = 1.16;

console.log("=== Conversor de Moneda ===");
console.log("1) Euros → Dólares");
console.log("2) Dólares → Euros");

rl.question("Elige opción (1 o 2): ", function(opcion) {
  opcion = opcion.trim();

  rl.question("Introduce la cantidad: ", function(cantidadInput) {
    const cantidad = parseFloat(cantidadInput);

    if (isNaN(cantidad)) {
      console.log("Debes introducir un número válido.");
      rl.close();
      return;
    }

    let resultado;
    if (opcion === "1") {
      resultado = cantidad * EUR_TO_USD;
      console.log(`${cantidad}€ = ${resultado.toFixed(2)}$`);
    } else if (opcion === "2") {
      resultado = cantidad / EUR_TO_USD;
      console.log(`${cantidad}$ = ${resultado.toFixed(2)}€`);
    } else {
      console.log("Opcion no valida.");
    }

    rl.close();
  });
});