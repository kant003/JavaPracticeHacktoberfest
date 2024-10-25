package uno;

import java.util.Scanner;

public class rebajas {
	
	public static double calculaPorcentaje(double antes, double despues) {
		
		double aux = antes - despues;
		double coci = aux / antes;
		return coci * 100;
		
	}
	
	public static double precioFinal(double antes, double porcentaje) {
		
		/*double aux = 0, desc = 0;
		desc = antes * (porcentaje / 100);
		aux = antes - desc;
		return aux;*/
		
		double aux = 0;
		aux = 1 - (porcentaje / 100);
		return aux * antes;
		
	}
	
	public static double precioOriginal(double despues, double porcentaje) {
		
		double aux = 0;
		aux = 1 - (porcentaje / 100);
		return despues / aux;
		
	}
	
	public static void main(String[] args) {
		
		int elegir;
		boolean seguir = true;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("calcular porcentaje: 1; calcular precio final: 2; calcular precio original: 3;");
		elegir = sc.nextInt();
		
		do {
			
			switch(elegir) {
			
			case 1:{
				double uno, dos;
				System.out.println("precio original: ");
				uno = sc.nextDouble();
				System.out.println("precio final: ");
				dos = sc.nextDouble();
				System.out.println("el porcentaje es: " + calculaPorcentaje(uno, dos) + "%");
				break;
			}
			
			case 2:{
				double ori, por;
				System.out.println("precio original: ");
				ori = sc.nextDouble();
				System.out.println("descuento en %: ");
				por = sc.nextDouble();
				System.out.println("el precio final es: " + precioFinal(ori, por) + "€");
				break;
			}
				
			case 3:{
				double fin, por;
				System.out.println("precio final: ");
				fin = sc.nextDouble();
				System.out.println("descuento en %: ");
				por = sc.nextDouble();
				System.out.println("el precio original es: " + precioOriginal(fin, por) + "€");
				break;
			}
			
			default:{
				System.out.println("dime algo valido gilipollas, ni meter un numero sabes");
			}
		}
			
			System.out.println("------------------------------------------------");
			System.out.println("Quieres seguir? (y/n)");
			char sino = sc.next().charAt(0);
			if(sino == 'n') 
				seguir = false;
			
		}while(seguir);
	}

}
