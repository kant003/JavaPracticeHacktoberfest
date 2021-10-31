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
