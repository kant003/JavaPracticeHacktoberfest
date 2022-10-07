package ejercicios;

import java.util.Scanner;

public class horas_semanas_dias {

	public static void main(String[] args) {

		double horas, semanas, dias, hours;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dime cuantas horas llevas trabajando: ");
		
		horas = sc.nextDouble();
		
	semanas = horas/168;
	dias = (horas%168)/24;
	hours = dias%24;
	
		
		
	
		System.out.println("Llevas currando " + dias + " dias y " + semanas + " semanas y " + hours + " horas restantes.");
		
		
		
		
		
	}

}
