const palos = ['♠️', '♥️', '♦️', '♣️'];
const valores = ['A', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K'];

let mazo = [];
let manoJugador = [];
let manoDealer = [];
let turnoTerminado = false;

const jugadorManoEl = document.getElementById('jugador-mano');
const dealerManoEl = document.getElementById('dealer-mano');
const jugadorPuntosEl = document.getElementById('jugador-puntos');
const dealerPuntosEl = document.getElementById('dealer-puntos');
const resultadoEl = document.getElementById('resultado');

const hitBtn = document.getElementById('hit');
const standBtn = document.getElementById('stand');
const nuevoBtn = document.getElementById('nuevo');


function crearMazo() {
  mazo = [];
  for (let palo of palos) {
    for (let valor of valores) {
      mazo.push({ valor, palo });
    }
  }
  mazo.sort(() => Math.random() - 0.5);
}

function valorCarta(carta) {
  if (['J', 'Q', 'K'].includes(carta.valor)) return 10;
  if (carta.valor === 'A') return 11;
  return parseInt(carta.valor);
}

function calcularPuntos(mano) {
  let total = mano.reduce((suma, carta) => suma + valorCarta(carta), 0);
  let ases = mano.filter(c => c.valor === 'A').length;
  while (total > 21 && ases > 0) {
    total -= 10;
    ases--;
  }
  return total;
}

function mostrarManos() {
  jugadorManoEl.textContent = manoJugador.map(c => c.valor + c.palo).join(' ');
  jugadorPuntosEl.textContent = calcularPuntos(manoJugador);

  if (turnoTerminado) {
    dealerManoEl.textContent = manoDealer.map(c => c.valor + c.palo).join(' ');
    dealerPuntosEl.textContent = calcularPuntos(manoDealer);
  } else {
    dealerManoEl.textContent = manoDealer.length > 0 ? manoDealer[0].valor + manoDealer[0].palo + ' 🂠' : '';
    dealerPuntosEl.textContent = '?';
  }
}

function determinarGanador() {
  const puntosJugador = calcularPuntos(manoJugador);
  const puntosDealer = calcularPuntos(manoDealer);

  if (puntosJugador > 21) return '¡Te pasaste! Pierdes :(';
  if (puntosDealer > 21) return '¡El dealer se pasó! ¡Ganaste oleeee!';
  if (puntosJugador === puntosDealer) return 'Empate Gana dealer :(';
  if (puntosJugador > puntosDealer) return '¡Ganaste oleeee!';
  return 'Pierdes :(';
}

function turnoDealer() {
  turnoTerminado = true;
  while (calcularPuntos(manoDealer) < 17) {
    manoDealer.push(mazo.pop());
  }
  mostrarManos();
  resultadoEl.textContent = determinarGanador();
}

function nuevoJuego() {
  crearMazo();
  turnoTerminado = false;
  manoJugador = [mazo.pop(), mazo.pop()];
  manoDealer = [mazo.pop(), mazo.pop()];
  resultadoEl.textContent = '';
  mostrarManos();
}

function pedirCarta() {
  if (turnoTerminado) return;
  manoJugador.push(mazo.pop());
  mostrarManos();

  if (calcularPuntos(manoJugador) > 21) {
    turnoTerminado = true;
    mostrarManos();
    resultadoEl.textContent = '¡Te pasaste! Pierdes :(';
  }
}

function plantarse() {
  if (turnoTerminado) return;
  turnoDealer();
}

hitBtn.addEventListener('click', pedirCarta);
standBtn.addEventListener('click', plantarse);
nuevoBtn.addEventListener('click', nuevoJuego);

nuevoJuego();
