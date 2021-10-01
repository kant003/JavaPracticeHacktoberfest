public class Satelite {

	// atributos
	private double meridiano;
	private double paralelo;
	private double distancia_tierra;

	// Constructor con todos los parametros
	Satelite(double m, double p, double d) {
		meridiano = m;
		paralelo = p;
		if (d >= 0) {
			distancia_tierra = d;
		} else {
			distancia_tierra = 0d;
		}

	}

	// constructor sin parametros (por defecto)
	Satelite() {
		meridiano = paralelo = distancia_tierra = 0;
	}

	public void setPosicion(double m, double p, double d) {
		meridiano = m;
		paralelo = p;
		if (d >= 0) {
			distancia_tierra = d;
		} else {
			distancia_tierra = 0d;
		}
	}

	public void printPosicion() {
		System.out.println("El satélite se encuentra en el paralelo " + paralelo + "\n Meridiano " + meridiano
				+ "\n a una distancia de la tierra de " + distancia_tierra + " Kilómetros");

	}

//Método void variaAltura(double desplazamiento). Este método acepta un parámetro que será positivo o
//negativo dependiendo de si el satélite tiene que alejarse o acercarse a La Tierra.
//Método boolean enOrbitaQ. Este método devolverá false si el satélite está en tierra y true en caso
//contrario.
//Método void variaPosicion(double variap, double variam). Este método permite modificar los atributos de
//posición (meridiano y paralelo) mediante los parámetros variap y variam. Estos parámetros serán valores
//positivos o negativos relativos que harán al satélite modificar su posición.

	public void variaAltura(double desplazamiento) {
		double aux = 0d;
		aux = distancia_tierra + desplazamiento;
		if(aux>0) {
		distancia_tierra += desplazamiento;
		}
	}
		public boolean enOrbita() {
			
			if (distancia_tierra>0) {
				return true;
			}
			else {
				return false;
			}
		}
		
		public void variaPosicion(double variap, double variam) {
			meridiano+=variam;
			paralelo+=variap;
			
		}
}
