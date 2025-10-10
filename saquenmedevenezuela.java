package P1Y1;

import java.util.Scanner;

public class saquenmedevenezuela {

	
	public static void main(String[] args) {
		System.out.println("introduce tu nombre");
		
		String nombre;
		Scanner escan = new Scanner(System.in);
		nombre = escan.nextLine();
		
		System.out.println("Hola " +nombre);
		
		escan.close();
	}
	
	
	
}
