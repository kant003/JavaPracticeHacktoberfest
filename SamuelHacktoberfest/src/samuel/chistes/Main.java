package samuel.chistes;

import java.io.File;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("¿Quieres VER los chistes/refranes o AÑADIR un chiste/refrán? (por defecto, ver):\n");
		
		if (input.next().equalsIgnoreCase("añadir")) {
			System.out.println("¿Refrán o chiste? (por defecto, chiste)");
			if (input.next().equalsIgnoreCase("refran")) {
				System.out.println("Escribe tu refrán a continuación:\n");
				addRefran(input.next());
			} else {
				System.out.println("Escribe tu refrán a continuación:\n");
				addChiste(input.next());
			}
		} else {
			System.out.println("¿Quieres ver refranes o chistes? (por defecto, refranes):\n");
			readFile(input.next());	
		}
		input.close();
	}

	public static void addRefran(String refran) {
		// TODO IN v1.0
	}
	
	public static void addChiste(String chiste) {
		// TODO IN v1.0
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
