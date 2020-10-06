import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fichero {
	public static String leerFichero(File ficheroOrigen) throws IOException {
		FileReader fr = new FileReader(ficheroOrigen);
		BufferedReader br = new BufferedReader(fr);
		String resultado = "", linea;
		while ((linea = br.readLine()) != null) {
			resultado += linea + "\n";

		}
		br.close();
		return resultado;

	}

	public static void guardarFichero(File ficheroDestino, String contenido) throws IOException {
		FileWriter fw = new FileWriter(ficheroDestino);
		fw.write(contenido);
		fw.close();
	}
}
