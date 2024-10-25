package uno;

public class automovil {

	private String marca = "";
	private int modelo = 0;
	private double motor = 0;
	public enum tipoCombustible{
		DIESEL,
		GASOLINA, 
		BIODIESEL,
		BIOETANOL,
		GASNATURAL
	}
	private tipoCombustible tipocomb;
	public enum tipoAutomovil{
		CIUDAD,
		SUBCOMPACTO,
		COMPACTO,
		FAMILIAR,
		SUV,
		EJECUTIVO
	}
	private tipoAutomovil tipoauto;
	private int puertas = 0;
	private int asientos = 0;
	private int velocidadmax = 0;
	public enum color{
		BLANCO,
		NEGRO,
		ROJO,
		NARANJA,
		AMARILLO,
		VERDE,
		AZUL,
		VIOLETA
	}
	private color color;
	private double velocidadact = 0;	
	
	public automovil() {
		}

	
	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public int getModelo() {
		return modelo;
	}


	public void setModelo(int modelo) {
		this.modelo = modelo;
	}


	public double getMotor() {
		return motor;
	}


	public void setMotor(double motor) {
		this.motor = motor;
	}


	public int getPuertas() {
		return puertas;
	}


	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}


	public int getAsientos() {
		return asientos;
	}


	public void setAsientos(int asientos) {
		this.asientos = asientos;
	}


	public int getVelocidadmax() {
		return velocidadmax;
	}


	public void setVelocidadmax(int velocidadmax) {
		this.velocidadmax = velocidadmax;
	}


	public double getVelocidadact() {
		return velocidadact;
	}


	public void setVelocidadact(double velocidadact) {
		this.velocidadact = velocidadact;
	}
	
	public String getDistancia() {
		return marca;
	}
	
	public tipoCombustible getTipocomb() {
		return tipocomb;
	}


	public void setTipocomb(tipoCombustible tipocomb) {
		this.tipocomb = tipocomb;
	}


	public tipoAutomovil getTipoauto() {
		return tipoauto;
	}


	public void setTipoauto(tipoAutomovil tipoauto) {
		this.tipoauto = tipoauto;
	}


	public color getColor() {
		return color;
	}


	public void setColor(color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "automovil [marca=" + marca + ", modelo=" + modelo + ", motor=" + motor + ", tipocomb=" + tipocomb
				+ ", tipoauto=" + tipoauto + ", puertas=" + puertas + ", asientos=" + asientos + ", velocidadmax="
				+ velocidadmax + ", color=" + color + ", velocidadact=" + velocidadact + "]";
	}


	public void acelera(int acelerasao) {
		//velocidad = velocidad + acelerasao;
		if(velocidadact + acelerasao > velocidadmax) {
			velocidadact = velocidadmax;
			System.out.println("el coche no da pa tanto neno");
		}else {
			velocidadact += acelerasao;
		}
	}
	
	public void frena(int decelerasao) {
		//velocidad = velocidad - decelerasao;
		if(velocidadact - decelerasao < 0) {
			velocidadact = 0;
			System.out.println("tate quieto neno");
		}else {
			velocidadact -= decelerasao ;
		}
	}
	
	public double tiempoLlegada(double distancia){
		 return distancia/velocidadact;
	}
	
	public automovil(String marca, int modelo, double motor, tipoCombustible tipocomb, tipoAutomovil tipoauto,
			int puertas, int asientos, int velocidadmax, uno.automovil.color color, double velocidadact) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.motor = motor;
		this.tipocomb = tipocomb;
		this.tipoauto = tipoauto;
		this.puertas = puertas;
		this.asientos = asientos;
		this.velocidadmax = velocidadmax;
		this.color = color;
		this.velocidadact = velocidadact;
	}
	
}
