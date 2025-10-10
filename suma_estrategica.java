package P1Y1;

import java.util.Scanner;

public class suma_estrategica {

	public static void main(String[] args) {
		System.out.println("introduce el primer número");
		
		int prim, seg, suma;
		
		Scanner escan = new Scanner(System.in);
		prim = escan.nextInt();
		
	System.out.println("introduce el segundo número");
		
		Scanner scan = new Scanner(System.in);
		seg = scan.nextInt();
		
		suma= seg + prim;
		
		System.out.println("la suma de tus números es: "+ suma);
		
		escan.close();
		scan.close();
	}
	
	
	
	
}
