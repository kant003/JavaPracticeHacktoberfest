
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
