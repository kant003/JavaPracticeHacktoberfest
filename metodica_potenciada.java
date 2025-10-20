package P1Y1;

import java.util.Scanner;

public class metodica_potenciada {
	
	public static int poty (int base, int exp) {
	int auxilia; 
	auxilia = (int) Math.pow(base, exp);
	
	return auxilia;
	
	}

	public static void main(String[] args) {
			System.out.println("introduce el primer número");
	int base, exp, pot;
			
			Scanner can = new Scanner(System.in);
			base = can.nextInt();
			
	System.out.println("introduce el segundo número");
			
			Scanner an = new Scanner(System.in);
			exp = an.nextInt();
			
			pot = poty(base, exp);

			
			System.out.println("la potencia es: "+ pot);
			
			can.close();
			an.close();
			
	}
	
	
}
