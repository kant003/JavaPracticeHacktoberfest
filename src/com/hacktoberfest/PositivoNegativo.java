package com.hacktoberfest;

import java.util.Scanner;

public class PositivoNegativo {

	
	static int leer_numero() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Por favor, escriba un n�mero:");
		String texto;
		texto = teclado.next();
		int numero;
		numero = Integer.parseInt(texto);

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

