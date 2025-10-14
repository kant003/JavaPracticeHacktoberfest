import './style.css'
// Para usar toner tenemos que importarlo.
import * as Tone from "tone";

const synth = new Tone.Synth().toDestination();

// en vez de int como en java usamos el let.
// Este es un array con todas las teclas.
// Habia que aplicar el ALL sino, no pilla todos los key, al poner el ALL coger todo..
let keys = document.querySelectorAll('.key')

for (let key of keys) {
    let noteToPlay = key.getAttribute('data-note')
    key.addEventListener('mousedown', () => playNote(noteToPlay)) //mousedown se cambió por el click
    key.addEventListener('mouseup', () => stopNote())
    key.addEventListener('mouseleave', () => stopNote())
}


function playNote(note) {
    synth.triggerAttackRelease(note);
}

function stopNote() {
    synth.triggerRelease();
}