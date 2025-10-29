
function formatTime(date) {
  return date.toLocaleTimeString();
}

function startClock() {
  const $time = document.getElementById('time');
  if (!$time) return console.error('No se encontró el elemento #time');

  function updateTime() {
    const now = new Date();
    $time.textContent = formatTime(now);
  }

  updateTime();
  setInterval(updateTime, 1000);
}

window.addEventListener('DOMContentLoaded', startClock);
