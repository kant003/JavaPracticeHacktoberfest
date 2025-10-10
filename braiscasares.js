const profes= [
    {name:'Pepe'},
    {name:'Angel'},
    {name:'Antonio'},
    {name:'Isabel'},
]

function toUpperName(lista){
    const vuelta =lista.map( (profe) => (
        lista.name = profe.name.toUpperCase()
    ))
    return vuelta
}
console.log(toUpperName(profes))