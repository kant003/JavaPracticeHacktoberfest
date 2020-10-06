package samuel.chistes;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("INDICA QUE ARCHIVO QUIERES VER [Refranes (por defecto) / Chistes]:\n");
		Scanner input = new Scanner(System.in);
		readFile(input.next());
		input.close();
	}

	public static void readFile(String tipo) {
		try {
			String file_name = (tipo.equalsIgnoreCase("chistes") || tipo.equalsIgnoreCase("chiste"))
					? "./res/chistes.txt"
					: "./res/refranes.txt"; // TODO encontrar una manera más elegante
			Scanner file = new Scanner(new File(file_name));

			while (file.hasNextLine()) {
				System.out.println(file.nextLine());
			}
			file.close();
		} catch (Exception e) {
			System.out.println("Error leyendo el archivo chistes!\n" + e.toString());
		}
	}
}
