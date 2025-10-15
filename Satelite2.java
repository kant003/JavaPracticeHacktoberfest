package dos;

public class Satelite2 {

	// ATRIBUTOS
	private double meridiano;
	private double paralelo;
	private double distancia_tierra;

	Satelite2(double m, double p, double d) {
		this.meridiano = m;
		this.paralelo = p;
		this.distancia_tierra = d;
	}

	Satelite2() {
		meridiano = paralelo = distancia_tierra = 0;
	}

	public void setPosicion(double m, double p, double d) {
		meridiano = m;
		paralelo = p;
		distancia_tierra = d;
	}

	public void printPosicion() {
		System.out.println("El satélite se encuentra en el: \nparalelo " + paralelo + " \nmeridiano " + meridiano
				+ " \na una distancia de la tierra de: \n" + distancia_tierra + " kilometros.");
	
	}
	
	public void variaAltura(double desplazamiento) {
		
		if(distancia_tierra+desplazamiento<0) {
			System.out.println("CUIDADO CON LA HORA");
		} else {
		this.distancia_tierra+=desplazamiento;
		}
	}
		
	public boolean enOrbita() {
		if (distancia_tierra==0) 
			return false;
		else
			return true;
	}
	
	public void variaPosicion(double variaM, double variaP) {
		
		this.meridiano+=variaM;
		this.paralelo+=variaP;
		
	}

	@Override
	public String toString() {
		return "Satelite2 [meridiano=" + meridiano + ", paralelo=" + paralelo + ", distancia_tierra=" + distancia_tierra
				+ "]";
	}
	
}
