package samuel.chistes;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			Scanner file = new Scanner(new File("./res/chistes.txt"));
			while (file.hasNextLine()) {
				System.out.println(file.nextLine());
			}
			file.close();
		} catch (Exception e) {
			System.out.println("Error leyendo el archivo chistes!\n" + e.toString());
		}
	}
}
