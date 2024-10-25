	package TCPPalindromo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientePalindromo {



public static void main(String[] args) throws IOException {

		String host = "localhost";
		int puerto = 6000;
		Socket cliente = new Socket(host, puerto);

		// salida
		PrintWriter fsalida = new PrintWriter(cliente.getOutputStream(), true);
		// Entrada
		BufferedReader fentrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		// entrada teclado
		Scanner sc = new Scanner(System.in);

		// revisar donde se instancian
		String cadena;
		boolean corta = false;
		System.out.println("tcp comprobacion palindromo (cliente)");
		System.out.println("Introduce cadena a comprobar (quit para salir): ");
		cadena = sc.nextLine();

		while (!corta) {

			// manda la cadena
			fsalida.println(cadena);
			// muestra la recibida
			String eco = fentrada.readLine();
			System.out.println("comprobacion: " + eco);

			// pide cadena a enviar
			System.out.println("Introduce cadena: ");
			cadena = sc.nextLine();

			if (cadena.equals("quit")) {
				fsalida.println(cadena);
				corta = true;
				System.out.println("ultimo envio ....");
			}
		
		}//fin while

		fsalida.close();
		fentrada.close();
		System.out.println("Cerrando cliente ...");
		sc.close();
		cliente.close();

	}}

	
	
