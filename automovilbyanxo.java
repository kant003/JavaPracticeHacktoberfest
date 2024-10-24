package Reisen;

public class automovil {
	String marca;
	String modelo;

	int motor;
	int puertas;
	int plazas;
	enum tipoCom {GASOLINA, BIOETANOL, DIESEL, BIODISESEL,
	GAS_NATURAL}
	tipoCom tipoCombustible;
	enum tipoA {CIUDAD, SUBCOMPACTO, COMPACTO, FAMILIAR,
	EJECUTIVO, SUV}
	tipoA tipoAutomóvil;
	double velocidadMáxima;
	enum tipoColor {BLANCO, NEGRO, ROJO, NARANJA,
	AMARILLO, VERDE, AZUL, VIOLETA}
	tipoColor color;
	double velocidadActual = 0;
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getMotor() {
		return motor;
	}
	public void setMotor(int motor) {
		this.motor = motor;
	}
	public int getPuertas() {
		return puertas;
	}
	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}
	public int getPlazas() {
		return plazas;
	}
	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	public tipoCom getTipoCombustible() {
		return tipoCombustible;
	}
	public void setTipoCombustible(tipoCom tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}
	public tipoA getTipoAutomóvil() {
		return tipoAutomóvil;
	}
	public void setTipoAutomóvil(tipoA tipoAutomóvil) {
		this.tipoAutomóvil = tipoAutomóvil;
	}
	public double getVelocidadMáxima() {
		return velocidadMáxima;
	}
	public void setVelocidadMáxima(double velocidadMáxima) {
		this.velocidadMáxima = velocidadMáxima;
	}
	public tipoColor getColor() {
		return color;
	}
	public void setColor(tipoColor color) {
		this.color = color;
	}
	public double getVelocidadActual() {
		return velocidadActual;
	}
	public void setVelocidadActual(double velocidadActual) {
		this.velocidadActual = velocidadActual;
	}
	public void acelerar(double valor) {
		if (velocidadActual+valor>velocidadMáxima)
			System.out.println("no te da la tartana");
		else
			velocidadActual+=valor;
	}
public void desacelerar(double valor) {
	if (velocidadActual-valor<0)
		System.out.println("negativont");
	else
		velocidadActual-=valor;
	
}
public void frenar() {
	velocidadActual=0;
}

public double calculartiempo(double kms) {
	return kms/this.velocidadActual;
}
//contruyeme las nalgas
public automovil(String marca, String modelo, int motor, int puertas, int plazas, tipoCom tipoCombustible,
		tipoA tipoAutomóvil, double velocidadMáxima, tipoColor color, double velocidadActual) {
	super();
	this.marca = marca;
	this.modelo = modelo;
	this.motor = motor;
	this.puertas = puertas;
	this.plazas = plazas;
	this.tipoCombustible = tipoCombustible;
	this.tipoAutomóvil = tipoAutomóvil;
	this.velocidadMáxima = velocidadMáxima;
	this.color = color;
	this.velocidadActual = velocidadActual;
}
@Override
public String toString() {
	return "automovil [marca=" + marca + ", modelo=" + modelo + ", motor=" + motor + ", puertas=" + puertas
			+ ", plazas=" + plazas + ", tipoCombustible=" + tipoCombustible + ", tipoAutomóvil=" + tipoAutomóvil
			+ ", velocidadMáxima=" + velocidadMáxima + ", color=" + color + ", velocidadActual=" + velocidadActual
			+ "]";
}

}
