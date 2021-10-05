import java.util.Scanner;

public class constantesyradio {

	// declaracion de constantes
	static final double PI = 3.141592;

	public static void main(String[] args) {

		// declaracion de variables
		Scanner objetoesc = new Scanner(System.in);
		double radio;
		double longitud;
		double area;
		String mensaje="Bienvenido a mi PROGRAMA";
		
		// ENTRADA
		System.out.println(mensaje);
		System.out.println("Por favor, introduce el radio: ");
		radio = objetoesc.nextDouble();
		

		// ALGORITMO
		longitud = 2 * PI * radio;
		area = PI*Math.pow(radio, 2);
		

		// SALIDA
		System.out.println("La long de la circ es: " + longitud);
		System.out.println("El area de la circ es: "+area);
		objetoesc.close();

	}

}