package com.hacktoberfest;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.BufferedReader;

/* crea un fichero de acceso directo
 * registro: clave (int), nombre (String 25), edad (int)
 * la clave es la posición del registro dentro del fichero
 */
public class Fichero {

	// en un fichero ramdow hay que establecer el tamaño del registro
	//recordar que un caracter son dos bytes en archivo
	private static final long tamanhoRegistro = 35;

	public static void main(final String[] args) {
		
		File f = new File("NombresEdades.DAT");
		String opcion;
		
		do{
			System.out.println("1.- Introducir nuevo registro");
			System.out.println("2.- Listado completo");
			System.out.println("3.- Buscar registro");
			System.out.println("4.- Modificar registro");
			System.out.println("5.- Salir");

			opcion = introduccionDatos("Introduce una opcion: ");
			try{
				switch (Integer.parseInt(opcion)){
				case 1: 
					insertarRegistro(f);
					break;
				case 2: 
					if(f.exists())
						listadoCompleto(f);
					else
						System.out.println("El fichero no existe. Tiene que insertar datos");
					break;
				case 3: 
					buscarRegistro(f);
					break;
				case 4: 
					
					
					modificarRegistro(f);
					break;      
				case 5: 
					System.exit(0);
				default: 
					System.out.println("Opcion erronea");
				}
			}catch (NumberFormatException e){
				System.out.println("La opcion tiene que ser un numero");
			}
		}while(!opcion.equals("5"));	
	}// fin main

	// métodos publicos y static

	/*---------------------------------------------------------------
	 * método para introducir los datos desde el teclado
	 */
	public static String introduccionDatos(final String s){
		try{
			System.out.println("--------------------------------------------------------");
			System.out.print(s);
			return (new BufferedReader (new InputStreamReader (System.in))).readLine();
		}catch (IOException ioe){
			System.out.println("\nError interno en sistema de entrada/salida\n");
		}
		return "";
	}// fin metodo introduccionDatos()
	
	/*---------------------------------------------------------------
	 * Metodo que inserta los registrsos en el fichero
	 * el campo clave determina la posición del registro dentro del fichero	
	 */
	public static void insertarRegistro(File f){

		RandomAccessFile puntero = null;
		int clave=0;
		String nombre="";
		int edad=0;
		try{
			// abriendo archivo, capturando y grabando datos
			puntero = new RandomAccessFile (f,"rw");

			String respuesta = null;

			do{
				// teclea los datos
				clave = Integer.parseInt(introduccionDatos("Introduce la clave: "));

				//comprueba la longitud del nombre tecleado si es menor que 25 lo rellena
				// si es mayor lo acorta
				nombre = introduccionDatos("Introduce el nombre: ");
				if (nombre.length() < 25) {
					for(int i=nombre.length(); i <25; i++)
						nombre=nombre+" ";
				}
				else { 
					nombre=nombre.substring(0,25);
				}

				edad = Integer.parseInt(introduccionDatos("Introduce la edad: "));
				//	 grabando el registro en el archivo
			
				//colocamos el puntero según la clave
				puntero.seek((clave-1) * tamanhoRegistro);
				puntero.writeInt(clave);
				puntero.writeUTF(nombre);
				puntero.writeInt(edad);

				respuesta = introduccionDatos("Desea continuar S/N");
			}while(respuesta.equalsIgnoreCase("s"));
		}
		catch(NumberFormatException nfe){
			System.out.println("Error al introducir los datos");
		}catch(FileNotFoundException fnf){
			System.out.println("Fichero inexistente");
		}catch (IOException ioe) { 
			System.out.println(" Error al escribir en el fichero");
		}finally{
			try{
				puntero.close();
			}
			catch(IOException e){
				System.out.println(" Error al cerrar el fichero ");
			}
		}

	}
	//---------------------------------------------------------------	
	public static void listadoCompleto(File f){
		int clave=0;
		String nombre="";
		int edad=0;
		RandomAccessFile puntero = null;
		long contadorRegistros = 0;
		try {
			// abriendo archivo, capturando datos
			puntero = new RandomAccessFile (f,"r");

			//calculando el numero de registros
			contadorRegistros = puntero.length()/tamanhoRegistro;
			System.out.println("Nº registros: " +contadorRegistros+" Tamaño del fichero: " +puntero.length()+ "\n\n");

			for (int r=0; r < contadorRegistros; r++) {
				puntero.seek(r* tamanhoRegistro);
				clave=puntero.readInt();
				nombre = puntero.readUTF(); 
				edad=puntero.readInt();
				if(clave != 0)
					System.out.println(clave+" "+nombre+" "+edad);

			}

		}catch(EOFException eof){
			System.out.println("Final del fichero ");
		}catch(FileNotFoundException fnf){
			System.out.println("Fichero inexistente");
		}catch (IOException ioe) { 
			System.out.println("Error al leer el fichero "); 
		}finally{
			try{
				puntero.close();
			}
			catch(IOException e){
				System.out.println(" Error al cerrar el fichero ");
			}
		}

	}
	//---------------------------------------------------------------
	public static void buscarRegistro(File f){
		int clave=0;
		String nombre="";
		int edad=0;
		RandomAccessFile puntero = null;
		
		try {
			// abriendo archivo, capturando datos
			puntero = new RandomAccessFile (f,"r");

			clave = Integer.parseInt(introduccionDatos("Introducir la clave. < 0 para Finalizar>: "));
			while(clave != 0){
				//colocamos el puntero según la clave
				puntero.seek((clave-1) * tamanhoRegistro);

				//leemos los campos del registro
				clave=puntero.readInt();
				nombre = puntero.readUTF(); 
				edad=puntero.readInt();

				//visualizamos los datos
				System.out.println(clave+" "+nombre+" "+edad);
				clave = Integer.parseInt(introduccionDatos("Introducir la clave. < 0 para Finalizar>: "));
			}// fin while

		}catch(NumberFormatException nfe){
			System.out.println("Error al introducir los datos");
		}catch (IOException ioe) { 
			System.out.println("Error de posicionamiento o lectura");
			System.out.println(ioe.getMessage());
		}finally{
			try{
				puntero.close();
			}catch(IOException e){
				e.printStackTrace();

			}
		}

	}

	/*---------------------------------------------------------------
	 * Metodo que modificar datos de un registrsos en el fichero
	 * el campo clave determina la posición del registro dentro del fichero	
	 * hay que posicionarse para leer el registro y hay que volver a posicionarse
	 * antes de escribir
	 */
	public static void modificarRegistro(File f){
		int clave=0;
		String nombre="";
		String respuesta = "";
		int edad=0;
		RandomAccessFile puntero = null;
		try {
			// abriendo archivo, capturando datos
			puntero = new RandomAccessFile (f,"rw");

			clave = Integer.parseInt(introduccionDatos("Introducir la clave a modificar. < 0 para Finalizar>: "));
			while(clave != 0){
				//colocamos el puntero según la clave para leer el registro
				puntero.seek((clave-1) * tamanhoRegistro);

				//leemos los campos del registro
				clave=puntero.readInt();
				nombre = puntero.readUTF(); 
				edad=puntero.readInt();

				//visualizamos los datos
				System.out.println(clave+" "+nombre+" "+edad);

				respuesta = introduccionDatos("Desea modificar el registro. S/N");
				if (respuesta.compareToIgnoreCase("s") == 0){
					//teclea los nuevos valores de los campos

					nombre = introduccionDatos("Introduce el nombre: ");
					if (nombre.length() < 25) {
						for(int i=nombre.length(); i <25; i++)
							nombre=nombre+" ";
					}
					else { 
						nombre=nombre.substring(0,25);
					}

					edad = Integer.parseInt(introduccionDatos("Introduce la edad: "));
					//	 grabando al archivo
					if (puntero.length()!= 0){
						puntero.seek( puntero.length() );
					}
					//recolocamos el puntero según la clave para escribir  
					puntero.seek((clave-1) * tamanhoRegistro);
					puntero.writeInt(clave);
					puntero.writeUTF(nombre);
					puntero.writeInt(edad);
				}

				clave = Integer.parseInt(introduccionDatos("Introducir la clave. < 0 para Finalizar>: "));
			}// fin while

		}catch(NumberFormatException nfe){
			System.out.println("Error al introducir los datos");
		}catch (IOException ioe) { 
			System.out.println("Error de posicionamiento o lectura");
			System.out.println(ioe.getMessage());
		}finally{
			try{
				puntero.close();
			}catch(IOException e){
				e.printStackTrace();

			}
		}

	}// fin metodo modificarEdad()
}


