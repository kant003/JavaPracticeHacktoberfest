import java.io.FileWriter;
import java.io.IOException;

public class ClaseCreateWrite {

	public void Escribir(String ruta_archivo) {
		String frase = "esto es un ejemplo";

		try {
			FileWriter escritura = new FileWriter(ruta_archivo);
			for (int i = 0; i < frase.length(); i++) {
				escritura.write(frase.charAt(i));

			}
			escritura.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
