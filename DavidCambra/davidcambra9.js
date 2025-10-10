const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function lanzarDado() {
    return Math.floor(Math.random() * 6) + 1;
}

rl.question("¿Quieres lanzar el dado? (s/n): ", function (respuesta) {
    if (respuesta.toLowerCase() === "s") {
        const resultado = lanzarDado();
        console.log(`Has sacado un ${resultado}`);
    } else {
        console.log("Juego terminado.");
    }
    rl.close();
});