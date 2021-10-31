var app = require('express')();
var http = require('http').createServer(app);
var io = require('socket.io')(http)

jugadores = new Map()
baldosasRotas = new Set()
const width = 20*20
const heigth = 20*20


Math.generateRandomInt = function (min,max) {
    return Math.floor((Math.random() * (max-min)) +min);
}

class Jugador{
    constructor(){
        this.name= 'sin nombre' 
        this.color= 'white'
        this.pos= new Vector(100,100) 
        this.r = 10
        this.vel = new Vector(3,0)
        this.alive = true
    }
    randomPos(){
        this.pos.x = Math.generateRandomInt(0,width)
        this.pos.y = Math.generateRandomInt(0,heigth)
    }
    estaFueraTablero(){
        return this.pos.x>20*20 || this.pos.x<0 || this.pos.y>20*20 || this.pos.y<0

    }
    estaEnAgujero(){

    }
    muere(){
        this.alive = false
    }

    mover(){
        this.pos.x +=this.vel.x
        this.pos.y +=this.vel.y
    }

    acelera(val){
       // if(val>10) val = 10

        this.vel.x *= val
        this.vel.y *= val
        this.limitVelocity()
    }
    desAcelera(val){
       // if(val<=1) val = 1
        this.vel.x /= val
        this.vel.y /= val
        //this.limitVelocity()
    }
    limitVelocity(){
        const max = 10
        const min = 2
        if (Math.abs(this.vel.x) > max){ this.vel.x = max; }
        if (Math.abs(this.vel.y) > max){ this.vel.y = max; }

     //   this.vel.x = Math.min(this.vel.x, maxVelocitiPermited)
     //   this.vel.y = Math.min(this.vel.y, maxVelocitiPermited)
     //   this.vel.x = Math.max(this.vel.x, minVelocitiPermited)
     //   this.vel.y = Math.max(this.vel.y, minVelocitiPermited)
    }

}
class Vector{
    constructor(x,y){
        this.x = x
        this.y = x
    }

    rota(grados){
        const radianes = grados * (Math.PI/180);
        this.x = (this.x * Math.cos(radianes)) - (this.y * Math.sin(radianes));
	    this.y = (this.x * Math.sin(radianes)) + (this.y * Math.cos(radianes));
    }

   /* longitud(){
        const catetosCuadrado = this.x * this.x + this.y * this.y;
        return logMath.sqrt(catetosCuadrado);
    }

    normaliza(){
        if (length === 0) {
            this.x = 1;
            this.y = 0;
        } else {
            this.x /= length
            this.y /= length
        }
    }*/

}

http.listen(4000, () => {
    console.log('Servidor arrancado correctamente y a la escucha en el puerto 3000')
})

io.on('connection', (socket) => {
    console.log('Nuevo cliente conectado:', socket.handshake.address, socket.id)
    //console.log(socket)
    const nuevoJugador = new Jugador()
    nuevoJugador.randomPos()
    jugadores.set(socket.id, nuevoJugador)


    io.on('disconnect', () => {
        console.log('El cliente se ha desconectado')
        jugadores.delete(socket.id)
    })

    socket.on('config', (datos) => {
        if (!datos.name) return
        jugadores.get(socket.id).name = datos.name
        jugadores.get(socket.id).color = datos.color
    })


    socket.on('rotaIzq', (direccion) => {
        const vel = -18
        const jugador = jugadores.get(socket.id)
        jugador.vel.rota(vel)
    })

    socket.on('rotaDer', (direccion) => {
        const vel = 18
        const jugador = jugadores.get(socket.id)
        jugador.vel.rota(vel)
    })

    socket.on('aumentaVel', (direccion) => {
        const jugador = jugadores.get(socket.id)
        jugador.acelera(1.5)
    })

    socket.on('disminuyeVel', (direccion) => {
        const jugador = jugadores.get(socket.id)
        jugador.desAcelera(1.5)
    })


    setInterval(render, 500);
    function render() {

        jugadores.forEach((v, k) => {
            const jugador = jugadores.get(k)
            if(jugador.estaFueraTablero()) jugador.muere()
            if(jugador.estaEnAgujero()) jugador.muere()
            
            if(jugador.alive===true){
                jugador.mover()
            }else{
                jugador.vel.x=0
                jugador.vel.y=0
                jugador.r-=1
                if(jugador.r <= 0) jugador.r = 0
            }
           // console.log(jugador)
        })
       // console.log('tarea')
        const datos = Array.from(jugadores).map(([key, value]) => (value))
        io.emit('jugadores', datos)

    }


    setInterval(destrulleBaldosa, 1000);

    function destrulleBaldosa() {
        let baldosaRandom
        do{
            baldosaRandom = generateRandomInt(0,20*20)
        }while(baldosasRotas.has(baldosaRandom))

        baldosasRotas.add(baldosaRandom)
        //console.log(baldosasRotas)
        io.emit('baldosaRota', baldosaRandom)
    }

    function generateRandomInt(min,max){
        return Math.floor((Math.random() * (max-min)) +min);
    }

   
    

})



