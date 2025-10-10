package P1Y1;

import java.util.Scanner;

public class potente_el_cringe {

	public static void main(String[] args) {
		System.out.println("introduce el primer número");
int pri, se, pot;
		
		Scanner can = new Scanner(System.in);
		pri = can.nextInt();
		
System.out.println("introduce el segundo número");
		
		Scanner an = new Scanner(System.in);
		se = an.nextInt();
		
		pot =  (int) Math.pow(pri, se);
		
		System.out.println("la potencia es: "+ pot);
		
		can.close();
		an.close();
		
	}
	
	
}
