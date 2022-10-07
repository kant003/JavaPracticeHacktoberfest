package proyectos;

import java.util.Scanner; 

public class longitud_area_circulo {
	protected static final double pi = 3.141592;
	static float radio;

	public static void main(String[] args) {
		longitud_y_radio_circulo();
	}

	protected static void longitud_y_radio_circulo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el díametro: ");
		float radio = sc.nextFloat();
		float diametro = radio*2;
		double longitud = pi*diametro;
		System.out.println("La longitud del círculo es: " + longitud);
		double area = pi*(radio);
		System.out.println("El área del círculo es: " + area);
	}

}
//area = pi*(r*r)