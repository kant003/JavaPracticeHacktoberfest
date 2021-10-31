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
