package P1Y1;

import java.util.Scanner;

public class ejercicio_rectangulo {
	
	public static void main(String[] args) {
		
		double l1, l2, peri;
		Scanner sc = new Scanner (System.in);
		System.out.println("introduce base: ");
				l1= sc.nextDouble();
		Scanner sca = new Scanner (System.in);
		System.out.println("introduce altura: ");
				l2= sca.nextDouble();
				
		peri= l1*l2;

		
		System.out.println("la longitud de la circunferencia es " +peri);
		
}

}
