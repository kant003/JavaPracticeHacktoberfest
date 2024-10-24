public class pajaro {
    
    // atributo estatico

	public static int numpajaros = 0;

	// atributos o propiedades
	private char color; // propiedad o atributo color
	private int edad; // propiedad o atributo edad

	// constructor con todos los parametros
	public pajaro(char color, int edad) {
		this.color = color;
		this.edad = edad;
		numpajaros++;
	}

	// constructor por defecto
	public pajaro() {
		this.edad = 0;
		numpajaros++;

	}

	// metodo estatico

	static void muestrapajaros() {
		System.out.println("el contador de pajaros es: " + numpajaros);
	}

	// métodos de la clase
	public void setEdad(int e) {
		edad = e;
	}

	// no util
	public void printedad() {
		System.out.println(edad);
	}

	public void setColor(char c) {
		color = c;

	}

	public char getColor() {
		return color;
	}

	public int getEdad() {
		return edad;
	}

	public void volar() {

		System.out.println("estoy volando ");

	}

	public void sevanACagar() {

		System.out.println("target acquired ");
	}

	// no util
	public void printcolor() {
		switch (color) {
		// Los pájaros son verdes, amarillos, grises, negros o blancos
		// No existen pájaros de otros colores
		case 'v':
			System.out.println("verde");
			break;
		case 'a':
			System.out.println("amarillo");
			break;
		case 'g':
			System.out.println("gris");
			break;
		case 'n':
			System.out.println("negro");
			break;
		case 'b':
			System.out.println("blanco");
			break;
		default:
			System.out.println("color no establecido");
		}
	}

	// fin método print color

	// super util
	@Override
	public String toString() {
		return "Pajaro [color = " + color + ", edad =" + edad + "]";
	}

}
