
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

