package ejemplos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class guardardiscordurofichero {

	public static String leerfichero(File ficheroorigen) throws IOException{
		FileReader fr = new FileReader(ficheroorigen);
		BufferedReader br = new BufferedReader(fr);
		String resultado="";
		String linea;
		while ((linea = br.readLine()) != null) {
			resultado = resultado+linea;
		}
		br.close();
		return resultado;
		}
	
	//terminar
	
	public static void guardarFichero(File ficheroDestino, String contenido) throws IOException{
		
		FileWriter fw =new FileWriter(ficheroDestino);
		fw.write(contenido);
		
		fw.close();
	//todo terminar
	}
}
