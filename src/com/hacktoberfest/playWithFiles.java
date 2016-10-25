package com.hacktoberfest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*creamos dos ficheros en uno guardamos la frase y en el segundo fichero cogemos solo las vocales*/


public class playWithFiles {

		public static void main(String[] args) throws IOException {
			String cadena;

			Scanner sc = new Scanner(System.in);
			//fichero1
			File f= new File("FichTexto01.txt");
			//segundo fichero
			File f2= new File("FichTexto02.txt");
			//preparamos el fileWriter
			FileWriter fw = new FileWriter(f); 
			FileWriter fw2 = new FileWriter(f2);
			System.out.print("Enter the phrase to save: ");
			cadena =sc.nextLine();
			//guardamos en un array por caracteres la frase
			char[] cad = cadena.toCharArray();

			for(int i=0; i< cad.length; i++){
				//guardadmos el caracter en el fichero nuevo
				fw.write(cad[i]); 
				//controlamos si es una letra y la guardamos en el segundo fichero
				if(cad[i] == 'a' || cad[i] == 'e' || cad[i] == 'i' || cad[i] == 'o' || cad[i] == 'u'){
					fw2.write(cad[i]);
				}
			}
			fw.close(); 
			fw2.close();
			

		}

	

}
