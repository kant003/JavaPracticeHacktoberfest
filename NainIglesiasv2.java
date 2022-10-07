public class NainIglesiasv2 {
 

import java.util.Scanner;

/* Codigo para calcular el
 
 perimetro y el area de un 
 rectangulo pidiendo sus dos 
  lados (double)
 */


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		double lado1, lado2;

		System.out.println("Escribe el primer lado (double)");

		lado1 = sc.nextDouble();

		System.out.println("Escribe el segundo lado (double)");

		lado2 = sc.nextDouble();

		System.out.println("El area es " + lado1 * lado2);
		System.out.println("El perimetro es " + 2 * (lado1 + lado2));

	}



}
