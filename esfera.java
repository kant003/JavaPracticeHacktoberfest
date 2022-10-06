package ejercicios;

import java.util.Scanner;

public class esfera {
		final static double PI = 3.1415;
	public static void main(String[] args) {

		/*Programa que dado el radio de una esfera calcule y 
		 * devuelva por pantalla el valor de la superficie y el volumen de la esfera*/
		
		double numero;
		
		double superficie, volumen;
		boolean on = false;
		do {
		Scanner sc = new Scanner(System.in); 
				System.out.println("Dime el radio de una esfera: ");
				
				numero = sc.nextDouble();
			
			
			superficie =  4*PI*(numero*numero);
			volumen = 4/3 * PI*(Math.pow(numero, 3));
			
			System.out.println("La superficie es: " + superficie + " y el volumen es: " + volumen);
			
				System.out.println("Quieres seguir calculando? SI (1).");
				numero =(int) sc.nextInt();
				if (numero == 1) {
					on = true;
				}
				else {
					System.out.println("Hasta luego.");
					on = false;
				}
				
				
			
				
		} while (on);
	
		
		
		
		
		
	}

}
