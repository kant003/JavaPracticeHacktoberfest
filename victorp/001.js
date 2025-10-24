//REST
//Spread
//Destructuring

/*let favoriteFilm = {
    title: 'Alien',
    director: 'Ridley Scott',
    year: 1979
}*/

//Guardar en dos varibles el titulo y el año y pintarlas por pantalla

//NO SE HACE ASI
/*let title = favoriteFilm.title
let year = favoriteFilm.year

console.log(`${title} - ${year}`)*/

//SE HACE ASI ''DESTRUCTURING''
/*let {title, year} = favoriteFilm
console.log(`${title} - ${year}`)

//Ejemplo con un array
let films = ['Alien', 'Matrix', 'Star Wars', 'Terminator', 'Gladiator']
//Destructuring y REST
let [a,b,...resto] = films
console.log(`${a} - ${b} - ${resto}`)*/

//Ejemplo practico directores favoritos
/*function directorFavorite(){
    return ['Scott','Cameron','Spielberg','Nolan']
}

let[director1,, director3] = directorFavorite()
console.log(`${director1} - ${director3}`)*/

//Ejemplo con actores
/*function favoriteActor(){
    return {
        name: 'DiCaprio',
        age: '50',
        isSingle: true,
        money: 300000000,
    }
}
//Ponemos alias y anadimos mas valores
let {name:theName, money, height= 1.83} = favoriteActor()
console.log(`${theName} - ${money} - ${height}`)*/

//Ejemplo con profesores
/*const angelTeacher = {
    id: 40,
    name: 'Angel',
    school: {
        name: 'CEBEM',
        address: 'Hispanidad 33'
    }

}

const {name, school:{name:nameSchool, address}} = angelTeacher;
console.log(`${name} - ${nameSchool} - ${address}`)*/

//Ejemplo de operador REST
let numbers = [4,5,6,7,8]
let newNumbers = [99,22,55]
let total = [...newNumbers, ...numbers]
console.log(total)