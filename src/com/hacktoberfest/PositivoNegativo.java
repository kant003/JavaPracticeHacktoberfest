package com.hacktoberfest;

import java.util.Scanner;

public class PositivoNegativo {
	
	static int leer_numero() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Por favor, escriba un número:");
		String texto;
		texto = teclado.next();
		int numero;
		numero = Integer.parseInt(texto);
		return numero;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numero;
		numero = leer_numero();
		if (numero >= 0)
			System.out.println("Es positivo");
		if (numero <= 0)
			System.out.println("Es negativo");
		

	}

}
