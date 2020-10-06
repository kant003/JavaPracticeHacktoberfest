function Saludo(){
    var nombre = document.getElementById("nombre");
    var saludo = "Hola " + nombre.value;
    document.getElementById("saludo").innerHTML = saludo;
}