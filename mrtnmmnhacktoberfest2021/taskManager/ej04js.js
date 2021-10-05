let arrTareas = []
let arrFinal = []
let cont = 0

function save() {
    arrTareas.push(document.getElementById("name").value)
    arrFinal.push(arrTareas[cont] + '  <label>&nbsp;&nbsp;</label><button onclick=completeItem(' + cont + ')>Click para tachar</button><br/>')
    document.getElementById("list").innerHTML = arrString()
    cont+=1
}

function arrString() {
    let str = ""
    for (let i = 0; i < arrFinal.length; i++) {
        str += arrFinal[i]
    }
    return str
}

function completeItem(i) { 
    arrFinal[i] = '<s>' + arrTareas[i] + '</s><label>&nbsp;&nbsp;</label><button onclick=unCompleteItem(' + i + ')>Click para destachar</button></br>'
    document.getElementById("list").innerHTML = arrString()
}

function unCompleteItem(i) { 
    arrFinal[i] = arrTareas[i] + '  <label>&nbsp;&nbsp;<label/><button onclick=completeItem(' + i + ')>Click para tachar</button></br>'
    document.getElementById("list").innerHTML = arrString() 
}