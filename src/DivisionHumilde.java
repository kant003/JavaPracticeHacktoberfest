import java.util.Scanner;

public class Division {

	public static void main(String[] args) {
		
		
		//1. DECLARACIÓN DE VARIABLES
		
		int dividendo;
		int divisor;
		int cociente;
		int modulo;
		double resultado;
		
		Scanner sc= new Scanner(System.in);
		
		
		
		//2. LECTURA DE NÚMEROS
		
		System.out.println("Introduce el dividendo: ");
		dividendo= sc.nextInt();
		
		System.out.println("Introduce el divisor");
		divisor= sc.nextInt();
		
		
		
		//3. ALGORITMO
		
		cociente=dividendo/divisor;
		modulo=dividendo%divisor;
		resultado=(double)dividendo/divisor;
		
		
		// 4. MUESTRA DE RESULTADO
		
		System.out.println(dividendo+" dividido entre "+divisor+" da como cociente "+cociente+", como resto "+modulo+" y como resultado "+resultado);
		
		

	}

}