package samuel.chistes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/*
 * Clase MAIN del programa de refranes y chistes.
 * @author: Samuel B. Díaz
 * @version: 1.0
 */

public class Main {

	/*
	 * DECLARACION DE CONSTANTES
	 */
	public static final String chistes_dir = "./res/chistes.txt";
	public static final String refranes_dir = "./res/refranes.txt";

	public static void main(String[] args) {
		showMenu();
	}

	/*
	 * Método que muestra el menú interactivo del programa
	 */
	public static void showMenu() {
		Scanner input = new Scanner(System.in);
		System.out.println("VER o AÑADIR (refran/chiste) (default: ver)");

		if (input.nextLine().equalsIgnoreCase("añadir")) {
			System.out.println("REFRAN o CHISTE (default: chiste)");
			if (input.nextLine().equalsIgnoreCase("refran")) {
				System.out.println("Introduce el refrán a continuación:\n");
				add(refranes_dir, input.nextLine());
			} else {
				System.out.println("Introduce el chiste a continuación:\n");
				add(chistes_dir, input.nextLine());
			}
		} else {
			System.out.println("** CHISTES **");
			readFileLines(chistes_dir);
			System.out.println("** REFRANES **");
			readFileLines(refranes_dir);
		}

		input.close();
	}

	/*
	 * Método para añadir un refrán o un chiste al archivo
	 */
	public static void add(String file, String contenido) {
		try {
			BufferedWriter wr = new BufferedWriter(new FileWriter(file, true));
			wr.write("\n" + contenido);
			wr.close();
		} catch (Exception e) {
			System.out.println("Error escribiendo el archivo!\n" + e.toString());
		}
	}

	/*
	 * Método para leer todo el contenido de los archivos refranes y chistes
	 */
	public static void readFileLines(String option) {
		try {
			Scanner file = new Scanner(new File(option));
			while (file.hasNextLine()) {
				System.out.println(file.nextLine());
			}
			file.close();
		} catch (Exception e) {
			System.out.println("Error leyendo el archivo chistes!\n" + e.toString());
		}
	}
}
