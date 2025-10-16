const labels = document.querySelectorAll('.form-control label')
//h
labels.forEach(label => {
  label.innerHTML = label.innerText
  .split('')
  .map((letter, idx) => `<span style="transition-delay:${idx*30}ms">${letter}</span>`)
  .join('')
})