package com.hacktoberfest;

import java.util.Scanner;

public class Separador_digitos_inverso {
	public static void main(String[] args) {
		Scanner src = new Scanner(System.in);
		int A;
		int B;
		int C;
		int D;
		int E;

		System.out.println("Introduzca el número de cuatro dígitos");
		A = src.nextInt();
		B = A / 1000 % 10;
		C = A / 100 % 10;
		D = A / 10 % 10;
		E = A % 10;
		System.out.println(E + "," + D + "," + C + "," + B);
	}
}