package capitulo.dos;

public class Pajaro {

	// atributos o caracteristicas
	private static int numPajaros=0;
	private String nombre;
	private char colorPlumas;
	private int edad;
	private boolean domestico;

	// metodo constructor por defecto

	public void printedad() {
		System.out.println(edad);
	}

	public void printcolor() {
		switch (colorPlumas) {
		case 'v':
			System.out.println("verde");
			break;
		case 'a':
			System.out.println("amarillo");
			break;
		case 'g':
			System.out.println("gris");
			break;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getColorPlumas() {
		return colorPlumas;
	}

	public void setColorPlumas(char colorPlumas) {
		this.colorPlumas = colorPlumas;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isDomestico() {
		return domestico;
	}

	public void setDomestico(boolean domestico) {
		this.domestico = domestico;
	}

	// metodo constructor con parametros

	Pajaro(String n, int e, char c, boolean d) {
		nombre = n;
		edad = e;
		colorPlumas = c;
		domestico = d;
	}

	Pajaro() {
		colorPlumas = 'v';
		edad = 0;
	} // constructor de la clase pájaro

	Pajaro(char c, int e) {
		colorPlumas = c;
		edad = e;
	} // constructor de la clase pájaro

	public String toString() {
		return "Pajaro [nombre=" + nombre + ", colorPlumas=" + colorPlumas + ", edad=" + edad + ", domestico="
				+ domestico + "]";
	}

	// metodos
//	volar()
//	piar()
//	comer()

}
