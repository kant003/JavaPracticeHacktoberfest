package ejemplos07Objetos01Persona;
/*
 * este ejemplo escribe objetos del tipo Persona en un fichero en disco
 */

import java.io.*;

public class Ej01EscrituraObjetoPersona {
	public static void main(final String[] args) {
		// creamos los objetos que nos permiten escribir
		FileOutputStream fs = null;
		ObjectOutputStream os = null;

		try{
			fs = new FileOutputStream("Personas.obj", true);
			os = new ObjectOutputStream(fs);
			//declaramos el objeto Persona usando un constructor y escribimos en el disco
			Persona p = new Persona("Marta Perez", 32);
			os.writeObject(p);

			// escribimos pasando la creación del objeto
			os.writeObject(new Persona("Ana Sánchez", 27));
			p = new Persona();
			p.setEdad(44);
			p.setNombre("Pedro Martínez");
			os.writeObject(p);

			// cerramos el fichero
			os.close();
		}catch(FileNotFoundException fne){
			System.out.println("Error en el fichero. nO EXISTE");
		}catch(IOException ioe){
			System.out.println("Error E/L");
		}
		System.out.println("Fin de la escritura");
	}
}

