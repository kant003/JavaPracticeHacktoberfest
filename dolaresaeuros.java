package uno;

import java.util.Scanner;

public class dolaresaeuros {
	
	/*Realiza una clase finanzas que convierta dólares a euros y viceversa. Codifica los métodos dolaresToEurot y
	eurosToDolares. Prueba que dicha clase funciona correctamente haciendo conversiones entre euros y dólares. L¿
	clase tiene que tener:
	Un constructor finanzas() por defecto el cual establecerá el cambio Dólar-Euro en 1.36.
	Un constructor finanzas (double), el cual permitirá configurar el cambio dólar-euro. */
	
	//scanner para la clase
	public static Scanner sc;

	public static double dolaresToEuros(double dol) {
		double aux = 0;
		aux = dol*0.92;
		return aux;
	}
	
	public static double eurosToDolares(double eur) {
		double aux = 0;
		aux = eur*1.08;
		return aux;
	}
	
	public static int pillaEntero() {
		int numero = 0;
		boolean entradaValida = false;
		
		while(!entradaValida) {
			//System.out.println("por favor, ingrese un numero entero: ");
			if(sc.hasNextInt()) {
				numero = sc.nextInt();
				entradaValida = true;
			}else {
				System.out.println("Entrada invalida, ingresa 1 o 2");
				sc.nextLine();
			}
		}
		
		//System.out.println("El numero es " + numero);
		return numero;
	}
	
	public static double pillaDoble() {
		double doble = 0;
		boolean entradaValida2 = false;
		
		while(!entradaValida2) {
			//System.out.println("por favor, ingrese un numero entero: ");
			if(sc.hasNextDouble()) {
				doble = sc.nextDouble();
				entradaValida2 = true;
			}else {
				System.out.println("Entrada invalida, ingresa un numero valido");
				sc.nextLine();
			}
		}
		
		//System.out.println("El numero es " + numero);
		return doble;
	}
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		boolean sigue = false;
		
		do {
			int opc = 0;
			double cantidad = 0;
			
			
			System.out.println("pulsa 1 para convertir dolares a euros");
			System.out.println("pulsa 2 para convertir euros a dolares");
			System.out.println("--------------------------------------");
			opc = pillaEntero();
			
			switch(opc) {
			case 1:
				System.out.println("introduce cantidad de dolares: ");
				cantidad = pillaDoble();
				System.out.println("cantidad convertida a euros: " + dolaresToEuros(cantidad));
				break;
				
			case 2:
				System.out.println("introduce cantidad de euros: ");
				cantidad = pillaDoble();
				System.out.println("cantidad convertida a dolares: " + eurosToDolares(cantidad));
				break;
				
			default:
				System.out.println("nop, te dije que 1 o 2");
			}
			

			System.out.println("------------------------------------------------");
			System.out.println("Quieres seguir? (1 = y, otro numero = n)");
			int sino = pillaEntero();
			if(sino != 1) 
				sigue = true;
			
		}while(!sigue);
		
		System.out.println("chau :3");
	}
}

