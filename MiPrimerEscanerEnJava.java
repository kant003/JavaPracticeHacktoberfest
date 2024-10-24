public class MiPrimerEscanerEnJava {
    

package hola;

import java.util.Scanner;



	public static void main(String[] args) {
		System.out.println("Introduce tu nombre:");

		
	String nombre;
	Scanner escan = new Scanner(System.in);
	nombre = escan.nextLine();
	
	System.out.println("HOLA, "+nombre);

	escan.close();
	
	}
}

