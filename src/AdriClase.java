package datos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EjFile02 {
	
	//SE PUEDE CREAR EL OBJETO FILE Y LUEGO UN FILEWRITER

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("Fichero01.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(f, true); //------>TRUE AÑADE AL TEXTO QUE YA EXISTE
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//PERO TAMBIÉN SE PUEDE CREAR EL FICHERO DESDE EL PROPIO FILEWRITER
		FileWriter fw1 = null;
		try {
			fw1 = new FileWriter("Fichero02.txt", false); //------>VIENE POR DEFECTO. SOBREESCRIBE LO QUE ESCRIBAS
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//PARA ESCRIBIR
		
		try {
			fw.write("hastaluego");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fw1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
