function showClock() {
    const now = new Date();

    const hours = now.getHours().toString().padStart(2, "0");
    const minutes = now.getMinutes().toString().padStart(2, "0");
    const seconds = now.getSeconds().toString().padStart(2, "0");

    console.clear();
    console.log(`${hours}:${minutes}:${seconds}`);
}

setInterval(showClock, 1000);
showClock();