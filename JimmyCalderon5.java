
/*12. (Ejercicio de dificultad alta) Realiza un programa que dado un importe en euros nos indique el mínimo número
de billetes y la cantidad sobrante que se pueden utilizar para obtener dicha cantidad.
Por ejemplo:
232 euros:
1 billete de 200.
1 billete de 20.
1 billete de 10
Sobran 2 euros.*/

import java.util.Scanner;

public class JimmyCalderon5 {
	public static void main(String[] args) {
		int pago = 0, cincocentos = 0, doscientos = 0, cien = 0, cincuenta = 0, veinte = 0, diez = 0, cinco = 0, doseuros=0,uneuro = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Cantidad a pagar: ");
		pago = sc.nextInt();

		System.out.println("la cantidad a pagar es: " + pago);
		System.out.println("-----------------------------");
		// Algoritmo
		while (pago > 0) {

			// condicionales relacionadas entre si
			if (pago >= 500) {
				cincocentos++;
				pago -= 500;
			} else if (pago >= 200) {
				doscientos++;
				pago -= 200;
			} else if (pago >= 100) {
				cien++;
				pago -= 100;
			} else if (pago >= 50) {
				cincuenta++;
				pago -= 50;
			} else if (pago >= 20) {
				veinte++;
				pago -= 20;
			} else if (pago >= 10) {
				diez++;
				pago -= 10;
			} else if (pago >= 5) {
				cinco++;
				pago -= 5;
			}
			
			else if (pago >= 2) {
				doseuros++;
				pago -=2;
			}
			else if (pago >= 1) {
				uneuro++;
				pago -=1;
			}
			} // fin while

		System.out.println("billete de 500: " + cincocentos);
		System.out.println("billete de 200: " + doscientos);
		System.out.println("billete de 100: " + cien);
		System.out.println("billete de 50: " + cincuenta);
		System.out.println("billete de 20: " + veinte);
		System.out.println("billete de 10: " + diez);
		System.out.println("billete de 5: " + cinco);
		System.out.println("monedas de 2 euros: "+doseuros);
		System.out.println("monedas de 1 euro: "+uneuro);
		
		sc.close();

	}

}
