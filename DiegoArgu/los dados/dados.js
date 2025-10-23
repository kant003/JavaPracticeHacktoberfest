let dinero = 0;
const precioDado = 3;

const dineroSpan = document.getElementById("dinero");
const resultado = document.getElementById("resultado");
const comprarBtn = document.getElementById("ComprarDado");
const zonaDados = document.getElementById("zonaDados");

const dados = [];

crearDado();

function crearDado() {
    const index = dados.length + 1;

    const contenedor = document.createElement("div");
    contenedor.classList.add("dado-container");
    contenedor.innerHTML = `
        <h3> Dado ${index}</h3>
        <label>Elige un número del 1 al 6:</label><br>
        <div class="botones-numeros">
            ${[1, 2, 3, 4, 5, 6].map(num => `
                <button class="numero" data-numero="${num}">${num}</button>
            `).join('')}
        </div>
        <br>
        <button class="lanzar">Lanzar este dado</button>
        <p class="mensaje"></p>
    `;

    zonaDados.appendChild(contenedor);

    const numeroBtns = contenedor.querySelectorAll(".numero");
    const lanzarBtn = contenedor.querySelector(".lanzar");
    const mensaje = contenedor.querySelector(".mensaje");

    let numeroSeleccionado = null;

    numeroBtns.forEach(btn => {
        btn.addEventListener("click", () => {
            numeroBtns.forEach(b => b.classList.remove("seleccionado"));
            btn.classList.add("seleccionado");
            numeroSeleccionado = parseInt(btn.dataset.numero);
        });
    });

    lanzarBtn.addEventListener("click", () => {
        if (!numeroSeleccionado) {
            mensaje.textContent = "Debes elegir un numero.";
            return;
        }

        const dado = Math.floor(Math.random() * 6) + 1;

        if (dado === numeroSeleccionado) {
            dinero++;
            dineroSpan.textContent = dinero;
            mensaje.textContent = `Acertaste`;
        } else {
            mensaje.textContent = `Fallaste`;
        }
    });

    dados.push({ contenedor, numeroSeleccionado });
}

comprarBtn.addEventListener("click", () => {
    if (dinero >= precioDado) {
        dinero -= precioDado;
        dineroSpan.textContent = dinero;
        crearDado();
    } else {
        resultado.textContent = "Necesitas 3 monedas.";
    }
});
