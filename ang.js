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
