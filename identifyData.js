function returnStuff(parameter) {
    if (typeof parameter == 'number') {
        return parameter * 2
    } else if (typeof parameter == 'string') {
        return parameter[0]
    } else if (typeof parameter == 'boolean') {
        return parameter
    } else {
        return 'Invalid parameter'
    }
}

console.log(returnStuff(5))
console.log(returnStuff('Hola'))
console.log(returnStuff(false))
console.log(returnStuff())