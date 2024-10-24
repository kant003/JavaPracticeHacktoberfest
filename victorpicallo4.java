import java.util.Scanner;

public class victorpicallo4 {
    	//Scanner declarado para toda la clase, pero OJO no abierto
	public static Scanner sc;
	/*
	 * Modifica el programa anterior creando una clase que permita almacenar los
	 * kilos de papas y chocos del restaurante. Implementa los siguientes métodos:
	 * public void addChocos(int x). Añade x kilos de chocos a los ya existentes.
	 * public void addPapas(int x). Añade x kilos de papas a los ya existentes.
	 * public int getComensales(). Devuelve el número de clientes que puede atender
	 * el restaurante (este es el método anterior). public void showChocos().
	 * Muestra por pantalla los kilos de chocos que hay en el almacén. public void
	 * showPapas(). Añade Muestra por pantalla los kilos de papas que hay en el
	 * almacén..
	 */

	// Atributos
	private double p;
	private double c;

	// Constructor defecto
	victorpicallo4() {
		this.p = 0;
		this.c = 0;
	}

	// Constructor con datos
	victorpicallo4(double p, double c) {
		this.p = p;
		this.c = c;
	}
	
	//Bucle While
	private int dimeClientes() {
		int num = 0;
		// Calculos
		while ((this.p >= 1) && (this.c >= 0.5)) {
			num += 3;
			this.p -= 1;
			this.c -= 0.5;
		}
		return num;
	}

	@Override
	public String toString() {
		return "Propuesto12 [p=" + p + ", c=" + c + "]";
	}

	// Metodos para añadir
	public void addP(double x) {
		this.p += x;
	}

	public void addC(double x) {
		this.c += x;
	}
	
	//Metodo para mostrar (Deberiamos testearlo antes de darlo por bueno)
	public void muestraComensales() {
		System.out.println("Podemos dar de comer a: " + this.dimeClientes());	
	}
	
}



