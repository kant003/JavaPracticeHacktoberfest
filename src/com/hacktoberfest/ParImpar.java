package com.hacktoberfest;

import java.util.Scanner;

public class ParImpar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int numero;

Scanner sc = new Scanner(System.in);
System.out.println("Introduce un número entero");
numero = sc.nextInt();
sc.close();
if (numero%2==0){
	System.out.println(numero+" es par");
}
else {
	System.out.println(numero+" es impar");
}
	}

}
