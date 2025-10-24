function meLlamo1(){
    return 'Angel'
}

let meLlamo2 = function (){
    return 'Angel'
}

function sumar1(a, b){

}
//Lamda

let meLlamo3 = () => {
    return 'Angel'
}

let meLlamo4 = () => 'Angel'

let sumar2 = (a,b) => a + b

//Ejemplo practico
const data = [3,4,6,-5,3]

function soloPositivos(num){
    return num >= 0
}

let soloPositivos2 = (num) => num >= 0

console.log(data.filter(soloPositivos))
console.log(data.filter(soloPositivos2))
console.log(data.filter((num) => num >= 0))