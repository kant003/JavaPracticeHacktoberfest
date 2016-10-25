package com.hacktoberfest;

import java.util.Scanner;

public class PositivoNegativo {

	public static int leerNumero() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Inserte un numero: ");
		int numero = sc.nextInt();

		return numero;
	}

	public static void main(String[] args) {

		int numero = leerNumero();

		if (numero >= 0) {
			System.out.println(numero + " Es positivo.");
		} else {
			System.out.println(numero + " Es negativo.");
		}
	}
}