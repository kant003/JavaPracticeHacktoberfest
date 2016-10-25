package com.hacktoberfest;

import java.util.Scanner;

public class ContarCadena {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introducir una cadena de texto:");
		String entrada=teclado.nextLine();
		System.out.println("La cadena '"+entrada+"' tiene "+entrada.length()+ " caracteres");
teclado.close();
	}

}
