package com.hacktoberfest;

import java.util.Scanner;

public class Grados {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Conversión de grados Celsius a Farenheit
		
		double c;
		double f;

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca la temperatura en grados centígrados: ");

		c = sc.nextDouble();

		f = 32 + (9 * c / 5);

		System.out.println(f + " grados Farenheit");

		sc.close();
	}

}
