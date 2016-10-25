package com.hacktoberfest;

import java.util.Scanner;

public class Contadordenumeros {

	public static class ejercicio4 {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int num;
			int i = 0;
			System.out.print("Introduzca número: ");
			num = sc.nextInt();
			while (num > 0) {

				System.out.println("Introduzca otro numero");
				num = sc.nextInt();
				i++;
			}
			if (num < 0)
				System.out.println("Los numero que introduciste son " + i);

		}
	}

}
