/*
Crea un programa en JavaScript que:
    - Crea un array con numeros que pueden estar repetidos
    - Usa un obejeto Set para eliminar los duplicados y mostrar solo los valores unicos
    - Comprueba si un numero concreto (ej. el 5) esta en el conjunto (set)
    - Elimina un numero del set (ej. numero 2)
    - Recorre el conjunto e imprima todos sus elementos en consola
    - Convierte el conjunto de nuevo e un array y lo muestre en consola, separados sus elementos con comas
 */

let arr = [1,2,3,4,5,5,6,7,8,8,9,10]
// Array -> Set
let set = new Set()
for (let i=0; i<arr.length; i++) {
    set.add(arr[i])
}
//Mejor forma de Array -> Set
setNumbers = new Set(arr)

console.log(set.has(5))
set.delete(2)

set.forEach(function (value) {
    console.log(value)
})

let arr2 = []
// Set -> Array
set.forEach(function (value) {
    arr2.push(value)
})
//Mejor forma de Set -> Array
arr3 = Array.from(setNumbers)