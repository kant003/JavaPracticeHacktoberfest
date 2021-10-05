import java.util.Scanner;

public class diventera {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Variables locales
		Scanner calculator = new Scanner(System.in);
		int n1;
		int n2;
		int cociente;
		int modulo;
		double res;

		// entradas
		System.out.println("introduce el dividendo:");
		n1 = calculator.nextInt();
		System.out.println("introduce el divisor");
		n2 = calculator.nextInt();

		// Algoritmo
		cociente = n1 / n2;
		modulo = n1 % n2;
		res = (n1 / (double) n2);

		// Salida
		System.out.println("el resultado de " + n1 + " entre " + n2 + " es: " + cociente);
		System.out.println("el resto de la división es:" + modulo);
		System.out.println("El resultado es:" + res);

		calculator.close();
	}

}
