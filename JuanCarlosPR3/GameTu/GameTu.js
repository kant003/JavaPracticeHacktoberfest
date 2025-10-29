const button = document.getElementById('button1');
const skipButton = document.getElementById('skipButton');
const input = document.getElementById('text1');
const img = document.querySelector('img');
const scoreEl = document.getElementById('score');
const suggestionsEl = document.getElementById('suggestions');

let score = 0;
let currentGameName = '';
let apiKey = 'fa7b514dee3d46a794169d50b787ae1e';

async function getRandomGame() {
    try {
        const res = await fetch(`https://api.rawg.io/api/games?key=${apiKey}&page_size=20`);
        const data = await res.json();
        const game = data.results[Math.floor(Math.random() * data.results.length)];
        currentGameName = game.name.toLowerCase();

        img.src = game.background_image || '';
        input.value = '';
        suggestionsEl.innerHTML = '';
    } catch (err) {
        console.error('Error al obtener el juego:', err);
    }
}

function checkAnswer() {
    const userAnswer = input.value.trim().toLowerCase();
    if (userAnswer === currentGameName) {
        score++;
        alert('Correct!');
        scoreEl.textContent = `Score: ${score}`;
        getRandomGame();
    } else {
        alert('Wrong! Try again');
    }
}


function skipGame() {
    score = 0;                   
    scoreEl.textContent = `Score: ${score}`;
    getRandomGame();             
    input.value = '';
    suggestionsEl.innerHTML = '';
}

// Eventos
button.addEventListener('click', checkAnswer);
skipButton.addEventListener('click', skipGame);

input.addEventListener('input', async () => {
    const query = input.value.trim();
    if (!query) {
        suggestionsEl.innerHTML = '';
        return;
    }

    try {
        const res = await fetch(`https://api.rawg.io/api/games?key=${apiKey}&search=${encodeURIComponent(query)}&page_size=5`);
        const data = await res.json();
        suggestionsEl.innerHTML = '';

        data.results.forEach(game => {
            const li = document.createElement('li');
            li.textContent = game.name;
            li.addEventListener('click', () => {
                input.value = game.name;
                suggestionsEl.innerHTML = '';
            });
            suggestionsEl.appendChild(li);
        });
    } catch (err) {
        console.error('Error al buscar sugerencias:', err);
    }
});

getRandomGame();
