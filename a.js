function destrulleBaldosa() {
        let baldosaRandom
        do{
            baldosaRandom = generateRandomInt(0,20*20)
        }while(baldosasRotas.has(baldosaRandom))

        baldosasRotas.add(baldosaRandom)
        //console.log(baldosasRotas)
        io.emit('baldosaRota', baldosaRandom)
    }
