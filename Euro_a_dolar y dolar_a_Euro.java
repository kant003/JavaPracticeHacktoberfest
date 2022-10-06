package proyectos;

import java.util.Scanner;

public class Euro_a_dolar {
	
	public static double euros_a_dolar() {
		Scanner sc = new Scanner(System.in);
		double a;
		System.out.printf("Introduzca euros :"); a=sc.nextDouble();
		double b = a/1.05;
		System.out.println("Tienes " +  b + " dólares");
		return a/1.05;
	}
	public static double dolar_a_euros() {
		Scanner sc = new Scanner(System.in);
		double b;
		System.out.printf("Introduzca dólares :"); b=sc.nextDouble();
		double a = b*1.05;
		System.out.println("Tienes " +  a + " euros");
		return b*1.05;
	}
	public static void main(String[] args) {
		euros_a_dolar();
		dolar_a_euros();
	}
}
