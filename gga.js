
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
