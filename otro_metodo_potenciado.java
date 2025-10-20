package P1Y1;

import java.util.Scanner;

public class otro_metodo_potenciado {


public static int potenciadistinta (int base, int exp) {
	int auxilia=1; 

	for (int i = 0; i < exp ; i++) {
		System.out.println("pasada "+i);
		auxilia= auxilia*base;
		System.out.println(auxilia);
		
	}
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
			
			pot= potenciadistinta(base, exp);
			
			System.out.println("la potencia es: "+ pot );
			
			can.close();
			an.close();
			
	}
	
}