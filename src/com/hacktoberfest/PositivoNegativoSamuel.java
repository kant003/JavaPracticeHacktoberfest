package com.hacktoberfest;
	import java.util.Scanner;
public class PositivoNegativoSamuel {


		static int leerNumero() {
			Scanner teclado = new Scanner(System.in);
			System.out.println("inserte numero: ");
			String texto;
			int numero;
			texto = teclado.next();
			numero = Integer.parseInt(texto);
			return numero;
		}

		public static void main(String[] args) {
			int numero;
			numero = leerNumero();
			if (numero >= 0) {
				System.out.println("Es Positivo");
			} else {
				System.out.println("Es negativo");

			}

		}

	}

