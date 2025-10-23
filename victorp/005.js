//Dada esta clase que modela una cuenta bancaria

function CuentaBancaria(titular, saldoInicial) {
    this.titular = titular;
    this.saldoInicial = saldoInicial;
}

//Añade en tiempo de ejecucion las siguiente funcionalidades
//metodo para ingresar(cantidad) que sume la cantidad al saldo
//metodo para extraer(cantidad) que reste la cantidad al saldo
//metodo para informar() que devuelva una cadena con titular y saldo

CuentaBancaria.prototype.ingresar = function (cantidad) {
    this.saldoInicial += cantidad;
}

CuentaBancaria.prototype.extraer = function (cantidad) {
    if(this.saldoInicial >= cantidad) {
        this.saldoInicial -= cantidad
    }
}

CuentaBancaria.prototype.informar = function () {
    return `Titular: ${this.titular} - Saldo: ${this.saldoInicial}`
}

let cuenta1 = new CuentaBancaria('Manuel', 4000);
console.log(cuenta1.informar());
cuenta1.ingresar(2000);
cuenta1.extraer(1000);
console.log(cuenta1.informar());