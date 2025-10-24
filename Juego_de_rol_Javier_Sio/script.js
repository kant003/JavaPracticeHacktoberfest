let xp = 0;
let health = 100;
let gold = 50;
let currentWeaponIndex = 0;
let fighting;
let monsterHealth;
let inventory = ["palo"];

const button1 = document.querySelector("#button1");
const button2 = document.querySelector("#button2");
const button3 = document.querySelector("#button3");

const text = document.querySelector("#text");
const xpText = document.querySelector("#xpText");
const healthText = document.querySelector("#healthText");
const goldText = document.querySelector("#goldText");
const monsterStats = document.querySelector("#monsterStats");
const monsterName = document.querySelector("#monsterName");
const monsterHealthText = document.querySelector("#monsterHealth");

const weapons = [
  { name: "Palo", damage: 5, price: 0 },
  { name: "Daga", damage: 30, price: 220 },
  { name: "Martillo de Garra", damage: 50, price: 240 },
  { name: "Espada de fuego", damage: 100, price: 890 }
];

const monsters = [
  { name: "Bestia con colmillos", health: 60, level: 4 },
  { name: "Caminante blanco", health: 100, level: 8 },
  { name: "Dragón", health: 500, level: 20 }
];

const locations = [
  {
    name: "town square",
    "button text": ["Ir a la tienda", "Ir a la cueva", "Luchar contra el dragón"],
    "button functions": [goStore, goCave, fightDragon],
    text: "Estás en la plaza del pueblo. Ves un cartel que dice \"Tienda\"."
  },
  {
    name: "store",
    "button text": ["Comprar 10 de salud (10 de oro)", "Comprar un arma (30 de oro)", "Ir a la plaza del pueblo"],
    "button functions": [buyHealth, buyWeapon, goTown],
    text: "Entras en la tienda."
  },
  {
    name: "cave",
    "button text": ["Luchar contra la bestia con colmillos", "Luchar contra el caminante blanco", "Ir a la plaza del pueblo"],
    "button functions": [fightBeast, fightCaminante, goTown],
    text: "Entras en la cueva. Ves algunos monstruos."
  }
];

button1.onclick = goStore;
button2.onclick = goCave;
button3.onclick = fightDragon;

function update(location) {
  button1.innerText = location["button text"][0];
  button2.innerText = location["button text"][1];
  button3.innerText = location["button text"][2];

  button1.onclick = location["button functions"][0];
  button2.onclick = location["button functions"][1];
  button3.onclick = location["button functions"][2];

  text.innerText = location.text;
  monsterStats.style.display = "none";
}

function goTown() {
  update(locations[0]);
}

function goStore() {
  update(locations[1]);
}

function goCave() {
  update(locations[2]);
}

function buyHealth() {
  if (gold >= 10) {
    gold -= 10;
    health += 10;
    goldText.innerText = gold;
    healthText.innerText = health;
  } else {
    alert("No tienes suficiente oro para comprar salud.");
  }
}

function buyWeapon() {
  if (currentWeaponIndex < weapons.length - 1) {
    if (gold >= 30) {
      gold -= 30;
      currentWeaponIndex++;
      const newWeapon = weapons[currentWeaponIndex];
      text.innerText = "Ahora tienes un " + newWeapon.name + ".";
      inventory.push(newWeapon.name);
      text.innerText += " En tu inventario tienes: " + inventory.join(", ");
      goldText.innerText = gold;
    } else {
      text.innerText = "No tienes suficiente oro para comprar un arma.";
    }
  } else {
    text.innerText = "Ya tienes el arma más poderosa!";
  }
}

function fightBeast() {
  fightMonster(0);
}

function fightCaminante() {
  fightMonster(1);
}

function fightDragon() {
  fightMonster(2);
}

function fightMonster(index) {
  fighting = index;
  monsterHealth = monsters[index].health;
  monsterStats.style.display = "block";
  monsterName.innerText = monsters[index].name;
  monsterHealthText.innerText = monsterHealth;
  text.innerText = `¡Te enfrentas a ${monsters[index].name}!`;

  button1.innerText = "Atacar";
  button2.innerText = "Esquivar";
  button3.innerText = "Huir";

  button1.onclick = attack;
  button2.onclick = dodge;
  button3.onclick = goTown;
}

function attack() {
  const weapon = weapons[currentWeaponIndex];
  const monster = monsters[fighting];
  const damage = weapon.damage + Math.floor(Math.random() * xp);
  monsterHealth -= damage;
  monsterHealthText.innerText = monsterHealth;
  text.innerText = `Usaste tu ${weapon.name} e hiciste ${damage} de daño a ${monster.name}.`;

  if (monsterHealth > 0) {
    health -= monster.level * 10;
    healthText.innerText = health;
    text.innerText += `\n${monster.name} te golpeó. Pierdes ${monster.level * 10} de salud.`;

    if (health <= 0) {
      lose();
    }
  } else {
    defeatMonster();
  }
}

function dodge() {
  const chance = Math.random();
  if (chance < 0.5) {
    text.innerText = "Lograste esquivar el ataque del monstruo.";
  } else {
    health -= monsters[fighting].level * 10;
    healthText.innerText = health;
    text.innerText = "Fallaste el esquive y recibiste daño.";
    if (health <= 0) {
      lose();
    }
  }
}

function defeatMonster() {
  const monster = monsters[fighting];
  xp += monster.level * 10;
  gold += monster.level * 20;
  xpText.innerText = xp;
  goldText.innerText = gold;

  if (monster.name === "Dragón") {
    text.innerText = `¡Has derrotado al Dragón! ¡El pueblo está a salvo! ¡Felicidades, héroe! 🎉`;
    button1.innerText = "Jugar de nuevo";
    button2.style.display = "none";
    button3.style.display = "none";
    button1.onclick = () => location.reload();
  } else {
    text.innerText = `Derrotaste a ${monster.name}. Ganaste ${monster.level * 10} XP y ${monster.level * 20} de oro.`;
    monsterStats.style.display = "none";
    update(locations[0]);
  }
}

function lose() {
  text.innerText = "¡Has muerto! El dragón sigue reinando. GAME OVER.";
  button1.innerText = "Reiniciar";
  button2.style.display = "none";
  button3.style.display = "none";
  button1.onclick = () => location.reload();
}
