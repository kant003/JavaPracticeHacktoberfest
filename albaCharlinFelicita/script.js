document.getElementById('miboton').addEventListener('click', felicitar)
function felicitar() {
    document.getElementById('frase').innerHTML = '¡Feliz Cumpleaños!'
    confetti()
}