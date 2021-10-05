
import java.util.Scanner;

public class ejercicio188 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		String linea;
		String[] palabras = new String[20];
		String cad1 = "";
		String cad2 = "";
		boolean encadenando;


		while(s.hasNext()) {

			encadenando = false;

			linea = s.nextLine();

			palabras = linea.split(" ");

			if(palabras.length <= 1) {

				System.out.println("SI");

			} else {

				for(int i=0; i<palabras.length-1; i++) {

						cad1 = palabras[i].substring(palabras[i].length() - 2);
						cad2 = palabras[i+1].substring(0, 2);

						if(cad1.equals(cad2)) {
							encadenando = true;
						} else {
							encadenando = false;
							break;
						}

				}


				if(encadenando == true) {
					System.out.println("SI");
				} else {
					System.out.println("NO");
				}


			}

			


		}

		s.close();

	}




}