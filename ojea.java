import java.util.Scanner;

public class divEntera {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Variables
		Scanner sc= new Scanner(System.in);
		int dividendo;
		int divisor;
		int cociente;
		int modulo;
		double resultado;
		
		//ENTRADAS
		System.out.println("introduce el dividendo: ");
		dividendo=sc.nextInt();
		System.out.println("introduce el divisor: ");
		divisor=sc.nextInt();
		
		//ALGORITMO
		cociente= dividendo/divisor;
		modulo= dividendo%divisor;
		resultado= (double)dividendo/divisor;
		
		
		//SALIDA
		System.out.println("El cociente es: " +cociente);
		System.out.println("El modulo es: " +modulo);
		System.out.println("El resultado con decimales es: "+resultado);
		
		sc.close();
	}

}