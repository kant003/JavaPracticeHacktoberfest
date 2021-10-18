let numeros = [1, 3, 5, 3, 6, 10, 2, 14, 2, 21]

if (numeros.includes(5)) {
    console.log("Hay 5")
} else {
    console.log("No hay 5")
}

if (numeros.length % 2 == 0) {
    console.log(numeros[(numeros.length/2)-1] + ", " + numeros[numeros.length/2])
} else {
    console.log(numeros[(numeros.length/2)-1])
}