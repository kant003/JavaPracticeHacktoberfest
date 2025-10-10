import java.util.Scanner;

public class eloycostas {
    
	public static void main(String[] args) {

		int num1, num2, suma;

		Scanner sc = new Scanner(System.in);

//pedir primer numero
		System.out.println("primer sumando: ");
//guardar{
		num1 = sc.nextInt();
//pedir segundo numero0
		System.out.println("segundo sumando: ");
//guardar
		num2 = sc.nextInt();
//algoritmo de la suma
		suma = num1 + num2;
		// mostrar la salida
		System.out.println(" la suma da:" + suma);

	}
}
