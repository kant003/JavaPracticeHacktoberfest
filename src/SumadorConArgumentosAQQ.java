package Ejemplo2;

import java.util.Scanner;

public class SumadorConArgumentos {
	public int sumar(int n1, int n2) {
		int resultado = 0;
		for (int i=n1; i<=n2;i++) {
			resultado = resultado +i;
		}
		return resultado;
	}
	public static void main(String[]args) {
		
		Scanner sc = new Scanner(System.in);
		SumadorConArgumentos s = new SumadorConArgumentos();
		int resultado;
		
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		//System.out.println("n1: ");
		//int n1 = sc.nextInt();
		//System.out.println("n2: ");
		//int n2 = sc.nextInt();
		resultado = s.sumar(n1, n2);
		
		System.out.println(resultado);
	}
}
