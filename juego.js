var miTablero;


class tablero {
	constructor( cv ){
		this.canvas = cv;
		this.ctx = cv.getContext( "2d" );
		this.pelota = new pelota(this.canvas.height/2, this.canvas.width/2, cv);
		this.jug1 = new jugador(0,0, cv);
		this.jug2 = new jugador(this.canvas.width-5, 0, cv);
		this.estado = 'stop';
		this.refresco=1000/30;
		this.timer = null;
	}
	startStop(){
		switch (this.estado)
		{
			case 'gameover':
			case 'stop':
			case 'pause':
				this.start();
				break;
			case 'start':
				this.stop();
		}
	}
	pause( ){
		this.estado = 'pause';
		console.log( "STOP tablero");
		window.clearInterval( this.timer );
		miTablero.canvas.dispatchEvent( new Event('pause') );
	}
	start( ){
		this.jug1.restart();
		this.jug2.restart();
		this.pelota.restart();

		this.estado = 'start';
		console.log( "Inicia tablero");
		this.timer = window.setInterval(this.dibujar,this.refresco);
		miTablero.canvas.dispatchEvent( new Event('start') );
	}

	stop(){
		this.estado = 'stop';
		console.log( "STOP tablero");
		window.clearInterval( this.timer );
		miTablero.canvas.dispatchEvent( new Event('stop') );
	}
	game_over()
	{
		this.ctx.fillStyle = "#000000";
		miTablero.ctx.fillText( "GAME OVER" , 70, 100);
		console.log( "GAME OVER");
		window.clearInterval( this.timer );
		this.timer = null;
		miTablero.canvas.dispatchEvent( new Event('gameover') );
	}
	getTeclas(ev) {
		switch (ev.code) {
			case 'ArrowUp':
				case 'ArrowDown':
				ev.preventDefault();
				miTablero.jug1.mover( ev )
				break;
		}
	}
	dibujar(){
		if (miTablero.comprobar_choques( miTablero.jug1 ))
			return;
		if (miTablero.comprobar_choques( miTablero.jug2 ))
			return;
		miTablero.ctx.clearRect( 0, 0, miTablero.canvas.width, miTablero.canvas.height );
		miTablero.jug1.dibujar();
		miTablero.jug2.posY = miTablero.pelota.posY-miTablero.jug2.height/2;
		miTablero.jug2.dibujar();
		miTablero.pelota.mover( miTablero );
		miTablero.pelota.dibujar();	
	}
	comprobar_choques( jugador ){
		//Comprueba si pelota toca con jugador
		if ((this.pelota.posX >= (jugador.posX)) && 
			(this.pelota.posX <= (jugador.posX+jugador.width)) &&
			(this.pelota.posY >= (jugador.posY)) && 
			(this.pelota.posY <= (jugador.posY+jugador.height)))
		{
			// Ha chocado!!
			this.pelota.dirX *= -1;
		}
		// Se sale del tablero?
		if ((this.pelota.posX <= 0) ||
			(this.pelota.posX >= miTablero.width))
		{
			this.game_over();
			return true;
		}
	}
}

class jugador {
	constructor(x, y, cv){
		this.posX = x;
		this.posY = y;
		this.restartX = x;
		this.restartY = y;
		this.velocidad = 12;
		this.aceleracion = 8;
		this.retardo = 150;
		this.height = 40;
		this.width = 5;
		this.dir = 0;
		this.timer = null;
		this.canvas = cv;
		this.ctx = cv.getContext( "2d" );
	}
	restart() {
		this.posX = this.restartX;
		this.posY = this.restartY;
	}
	dibujar() {
		var nVel = 0;
		if (this.timer != null) {
			var t = new Date();				// Momento actual
			var duracion = Math.ceil( t - this.timer );	// Cuanto ha pasado desde pulsar la tecla
			if (duracion > this.retardo)
				duracion = this.retardo;
			nVel = this.aceleracion*Math.pow(duracion/150, 2);
			if ( nVel > this.velocidad)
				nVel = this.velocidad;
		}

		if (this.dir <0)		// Avanza en direccion positiva
			this.posY -= nVel;

		if (this.dir >0)		// Avanza en direccion negativa
			this.posY += nVel;
		if (this.posY<=0)		// Comprueba si llega al final del canvas
			this.posY = 0;
		if ((this.posY+this.height)>this.canvas.height)
			this.posY = this.canvas.height-this.height;
		this.ctx.fillStyle = "#FF0000";
		this.ctx.fillRect(this.posX,this.posY, this.width, this.height);
	}
	mover( ev ){
		var t1 = document.getElementById('teclacode');
		t1.textContent = ev.code;
		var t2 = document.getElementById('teclaupdown');
		t2.textContent = ev.type;
		if (ev.type == 'keydown'){	// Presiona tecla
			if ( !ev.repeat)
				this.timer = new Date();	// Guardo momento en el q toca tecla
			if (ev.code == 'ArrowUp')
				this.dir = -1;
			else if (ev.code == 'ArrowDown')
				this.dir = 1;
		}
		if (ev.type == 'keyup'){	// Presiona tecla
			this.timer = null;
			this.dir = 0;
		}
	}

}

class  pelota {
	constructor(x, y, cv) {
		this.posX= x?x:0;
		this.posY = y?y:0;
		this.radio = 5;
		this.restartX = x;
		this.restartY = y;
		this.velocidad = 5;
		this.canvas = cv;
		this.invalidate = false;
		this.ctx = cv.getContext( "2d" );
		this.restart();
	}
	restart() {
		this.posX = this.restartX;
		this.posY = this.restartY;
		this.dirX=Math.random();
		this.dirY=Math.random();
		// Normalizar vector
		var base = Math.sqrt(
			Math.pow(this.dirX, 2) +
			Math.sqrt( this.dirY, 2));
		this.dirX /= base;
		this.dirY /= base;
	}
	dibujar() {

		this.ctx.fillStyle = "#153";
		this.ctx.strokeStyle = "#153";
		this.ctx.beginPath();
		this.ctx.arc(this.posX, this.posY, this.radio, 0, 2 * Math.PI);
		this.ctx.fill();
		this.ctx.stroke();
	}
	mover( tablero ) {
		// Mueve la pelota
		this.posX += this.dirX * this.velocidad;
		this.posY += this.dirY * this.velocidad;
		if (((this.posY+this.radio) >= tablero.canvas.height)||
			((this.posY-this.radio) <=0)){
			this.dirY *= -1;
		}
	}
}



