package psp;

import java.util.Scanner;

public class sumador {
public int sumar(int n1,int n2) {
	int resultado =0;
	for (int i = n1; i <= n2; i++) {
		resultado= resultado +i;
	}
	return resultado;
}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	sumador s = new sumador();
	System.out.println("n1 : ");
	int n1 = sc.nextInt();
	System.out.println("n2 : ");
	int n2 = sc.nextInt();
	int resultado = s.sumar(n1, n2);
	System.out.println(resultado);
}
}
