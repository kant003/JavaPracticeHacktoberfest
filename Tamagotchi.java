public class Tamagotchi {

	// ATRIBUTOS
	static int hambre;
	static int higiene;
	static int diversion;
	static int aprendizaje;
	static int energia;
	static int salud;

	// MÉTODOS
	Tamagotchi() {
		this.hambre = 50;
		this.higiene = 50;
		this.diversion = 50;
		this.aprendizaje = 50;
		this.energia = 50;
		this.salud = 50;
	}

	private int compruebaCeroACien(int valor) {
		if (0 > valor) {
			valor = 0;
		} else if (100 < valor) {
			valor = 100;
		}
		return valor;
	}

	public void darComer() {
		hambre = compruebaCeroACien(hambre + 20);
	}

	public void darleBaño() {
		higiene = compruebaCeroACien(higiene + 20);

	}

	public void jugar() {
		diversion = compruebaCeroACien(diversion + 30);
	}

	public void aprender() {
		aprendizaje = compruebaCeroACien(aprendizaje + 30);
	}

	public void dormir() {
		energia = compruebaCeroACien(energia + 70);
	}

	public void curar() {
		hambre = compruebaCeroACien(hambre + 50);
		higiene = compruebaCeroACien(higiene + 50);
		diversion = compruebaCeroACien(diversion + 50);
		aprendizaje = compruebaCeroACien(aprendizaje + 50);
		energia = compruebaCeroACien(energia + 50);
		salud = compruebaCeroACien(salud + 50);
	}

	public void pasarTiempo() {
		hambre = compruebaCeroACien(hambre - 20);
		higiene = compruebaCeroACien(higiene - 20);
		diversion = compruebaCeroACien(diversion - 20);
		aprendizaje = compruebaCeroACien(aprendizaje - 20);
		energia = compruebaCeroACien(energia - 20);
		salud = compruebaCeroACien(salud - 20);
	}

	public String toString() {
		StringBuffer parametros = new StringBuffer();
		parametros.append("PARAMETROS DEL TAMAGOTCHI");
		parametros.append("\nHambre: " + hambre + "/100");
		parametros.append("\nHigiene: " + higiene + "/100");
		parametros.append("\nDiversión: " + diversion + "/100");
		parametros.append("\nAprendizaje:  " + aprendizaje + "/100");
		parametros.append("\nEnergía: " + energia + "/100");
		parametros.append("\nSalud: " + salud + "/100");
		return parametros.toString();

	}
}