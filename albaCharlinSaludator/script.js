document.getElementById('miboton').addEventListener('click', saludar)
function saludar() {
    document.getElementById('frase').innerHTML = 'Hola'
    confetti()
}