package com.hacktoberfest;

import java.util.Scanner;
public class LecturaCaracterTresIntentos {
	// El número de intentos se declara como una constante.
	public static final int INTENTOS = 3 ;
	public static final char RESPOSTA_CORRECTA = 'b';
	public static void main (String [] args) {
		@SuppressWarnings("resource")
		Scanner lector = new Scanner (System.in);
		System.out.println ("Adivina la pregunta.");
		System.out.println ("¿Cuál de los siguientes no es un tipo primitivo?");
		System.out.println ("a) Enter");
		System.out.println ("b) Scanner");
		System.out.println ("c) Carácter");
		System.out.println ("d) Booleano");
		// Hay un contador de intentos.
		int intentos = 0 ;
		// Hay que saber si se ha acertado (semáforo).
		boolean acertado = false ;
		// Se pregunta mientras no se acierte ni agoten los intentos.
		while (( intentos < INTENTOS ) && ( !acertado ) ) {
			System.out.print ("Tu respuesta es la opción:");
			// Se lee la cadena de texto.
			String palabra = lector.next ();
			// Es una palabra de un único carácter?
			if (palabra. length () == 1) {
				// Se extrae el carácter de la cadena de texto.
				char caracter = palabra. charAt(0);
				// Es un carácter válido? (a, b, c o d).
				if ((caracter>= 'a') && (caracter <= 'd')) {
					// La respuesta final es correcta?
					if (caracter == RESPOSTA_CORRECTA) {
						System.out.println ("Efectivamente, la respuesta era " + RESPOSTA_CORRECTA +
								".");
						acertado = true ;
					}
					else {
						System.out.println ("La respuesta " + caracter + " es incorrecta.");
						intentos ++;
					}
				}
				else {
					System.out.println (" " + caracter + " es una opción incorrecta.");
					// Si existe este error, no se agotará ningún intento ...
				}
			}
			else {
				// No lo era.
				System.out.println ("\" "+ palabra +"\" no es un carácter individual.");
				// Si existe este error, no se agotará ningún intento ...
			}
			lector. nextLine ();
		}
		if(intentos >= INTENTOS ) {
			System.out.println ( "Has agotado todos tus intentos." ) ;
		}
	}
}