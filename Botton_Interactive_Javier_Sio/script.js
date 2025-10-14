const rateButtons = document.querySelectorAll('.rate-btn');
const submitBtn = document.getElementById('submit-btn');
const ratingCard = document.getElementById('rating-card');
const thankYouCard = document.getElementById('thank-you-card');
const selectedRating = document.getElementById('selected-rating');

let selected = null;

rateButtons.forEach((btn) => {
  btn.addEventListener('click', () => {
    rateButtons.forEach((b) => b.classList.remove('active'));
    btn.classList.add('active');
    selected = btn.textContent;
  });
});

submitBtn.addEventListener('click', () => {
  if (selected) {
    selectedRating.textContent = selected;
    ratingCard.classList.add('hidden');
    thankYouCard.classList.remove('hidden');
  } else {
    alert('Por favor selecciona una calificación antes de enviar.');
  }
});