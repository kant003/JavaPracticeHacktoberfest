import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fichero {
	public static String leerFichero(File ficheroOrigen) throws IOException {
		
		//CODIGO LEER FICHERO TEXTO
		FileReader fr = new FileReader(ficheroOrigen);
		BufferedReader br = new BufferedReader(fr);
		String resultado = "";
		String linea;
		while((linea = br.readLine()) !=null){
			resultado = resultado + linea +"/n"; 
			br.close();
		}
		
		return null;
	}
	
public static void guardarFichero (File ficheroDestino, String contenido) throws IOException {
	
	//CODIGO GRABAR FICHERO
	
	FileWriter fw = new FileWriter(ficheroDestino);
	fw.write(contenido);
	fw.close();
	
}
}
