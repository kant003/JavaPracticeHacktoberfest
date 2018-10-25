package ejemplos10FicherosAleatorios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.BufferedReader;

/*
 * En el siguiente ejemplo crearemos una aplicación que nos permita guardar 
 * datos de los alumnos de un curso en un fichero de texto con RandomAccesFile. 
 * Crearemos un menú para poder seleccionar entre las opciones: Introducir nota,
 * Listado completo, Ver notas de un alumno, Modificar nota y Salir.
 */
public class Ej02ClaveAutoIncrementable {

	//atributos
	private static final int TAMANHOREGISTRO=50; // tamaño del registro
	private static final int NOMBRELONGMAX=30;	// longitud máxima del nombre
	private static final int MODULOLONGMAX=15;	// // longitud máxima del modulo
	
	public static void main(final String[] args) {
		
		File f = new File("Notas.txt");
		
		int opcion;
		do{
				System.out.println("1.- Introducir Alumnos");
				System.out.println("2.- Listado Alumnos");
				System.out.println("3.- Buscar un Alumno");
				System.out.println("4.- Modificar notas un Alumno");
				System.out.println("5.- Salir");

				opcion = Integer.parseInt(introduccionDatos("Introduce una opcion: "));
				try{
					switch (opcion){
					case 1: 
						insertarNotaEnFichero(f);
						break;
					case 2: 
						listadoCompleto(f);
						break;
					case 3: 
						notasDe1Alumno(f);
						break;
					case 4: 
						modificarNota(f);
						break;      
					case 5: 
						System.exit(0);
					default: 
						System.out.println("Opción erronea");
					}
				}catch (NumberFormatException e){
					System.out.println("La opcion tiene que ser un numero");
				}
			}while(opcion != 5);
		
	}// fin del main
	/*---------------------------------------------------------------
	 * Método para introducir datos desde el teclado
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
	}
	/*---------------------------------------------------------------
	 * Método que devuelve el número de registros del fichero
	 */
	private static int numRegistros(File f){
		RandomAccessFile nota;
		try {
			nota = new RandomAccessFile(f, "r");
			return (int)Math.ceil ((double)nota.length()/ (double)TAMANHOREGISTRO);
		} catch (FileNotFoundException e1) {
			System.out.println("Error el fichero no existe");
			return 0;
		}catch (IOException e){
			System.out.println("ERROR GRAVE DE ENTRADA/SALIDA");
			return 0;
			
		}
	}
	/*---------------------------------------------------------------
	 * Escribe los datos en el fichero
	 */
	public static void insertarNotaEnFichero(File f){
		RandomAccessFile nota;
		try{
			String aux="";
			nota = new RandomAccessFile(f, "r");                     
			nota.seek( numRegistros(f)* TAMANHOREGISTRO);// se coloca al final del fichero

			// si el nombre es demasiado largo vuelve a solicitarlo, en caso contrario lo escribe en el fichero
			do{	
				aux=introduccionDatos("Introduce nombre: ");
				if (aux.length()>=NOMBRELONGMAX){
					System.out.println("\nNombre demasiado largo\n");
					System.out.println("--------------------------------------------------------");
				}
			}while(aux.length()>=NOMBRELONGMAX);
			nota.writeUTF(aux);

			// si el nombre del modelo es demasiado largo vuelve a solicitarlo, en caso contrario 
			// lo escribe en el fichero
			do{
				aux=introduccionDatos("Introduce modulo: ");
				if (aux.length()>=MODULOLONGMAX){
					System.out.println("\nNombre de modulo demasiado largo");
					System.out.println("--------------------------------------------------------");
				}
			}while(aux.length()>=MODULOLONGMAX);
			nota.writeUTF(aux);
			System.out.println("--------------------------------------------------------");

			boolean sw = false;
			do{
				sw = false;
				try{
					aux=introduccionDatos("Introduce nota: ");
					nota.writeInt(Integer.parseInt(aux));
				}catch (NumberFormatException e){
					System.out.println("Debes introducir un numero");
					sw = true;
				}
			}while(sw);
		}catch(IOException ioe){
			System.out.print("\nError "+ioe.toString());
		}
	}// fin del metodo meterNotaEnFichero()

	/*---------------------------------------------------------------
	 * Listado de todos los datos del fichero
	 */
	public static void listadoCompleto(File f){
		RandomAccessFile nota; 
		
		if (numRegistros(f)!=0){
			System.out.println("\n\t LISTADO COMPLETO\n---------------------------------------------");
			System.out.println("Nombre\tModulo\tNota");
			System.out.println("\n---------------------------------------------");
			try{
				nota = new RandomAccessFile(f, "r");
				for (int i=0; i<numRegistros(f);i++){
					nota.seek(i* TAMANHOREGISTRO);
					System.out.println(nota.readUTF() +"\t"+ nota.readUTF() +"\t"+ nota.readInt());
				}
				System.out.println("\n---------------------------------------------");
			}catch (IOException ioe){
				System.out.println("\nError "+ioe.toString());
			}
		}else
			System.out.println("\nNo hay registros introducidos");
	}// fin método listadoCompleto()

	//---------------------------------------------------------------
	public static void notasDe1Alumno(File f){
		RandomAccessFile nota; 
		String aux = "";
		boolean esta = false;
		if (numRegistros(f)>0) {
			aux = introduccionDatos("Introduce el nombre de un alumno: ");
			try{
				nota = new RandomAccessFile(f, "r");
				for (int i=0; i<numRegistros(f);i++){
					nota.seek(i* TAMANHOREGISTRO);
					if (aux.compareToIgnoreCase(nota.readUTF()) == 0){
						nota.seek(i* TAMANHOREGISTRO);
						System.out.println("\n---------------------------------------------");
						System.out.println("Nombre: "+ nota.readUTF());
						System.out.println("Modulo: "+ nota.readUTF());
						System.out.println("Nota: "+ nota.readInt());
						esta = true;
					}
				}

				if (esta==false)
					System.out.println("\nAlumno inexistente");

			}catch (IOException ioe){
				System.out.println("\nError "+ioe.toString());
			}
		}else
			System.out.println("No hay datos en el fichero");
	}// fin metodo notasDe1Alumno()


	/*---------------------------------------------------------------
	 * Metodo que modifica la nota de un determinado alumno
	 */
	public  static void modificarNota(File f){
		String aux="";
		String aux2="";
		boolean esta = false;
		RandomAccessFile nota; 

		if (numRegistros(f)>0) {
			aux = introduccionDatos("Introduce el nombre de un alumno: ");
			aux2 = introduccionDatos("Introduce el modulo: ");
			String opcion="";
			try{
				nota = new RandomAccessFile(f, "r");
				for (int i = 0; i < numRegistros(f); i++){
					nota.seek(i* TAMANHOREGISTRO);
					if (aux.compareToIgnoreCase(nota.readUTF()) == 0){
						if (aux2.compareToIgnoreCase(nota.readUTF())==0){
							nota.seek(i* TAMANHOREGISTRO);
							System.out.println("Nombre: "+ nota.readUTF());
							System.out.println("Modulo: "+ nota.readUTF());
							opcion = introduccionDatos("Introduce la nueva nota: ");
							nota.writeInt(Integer.parseInt(opcion));
							esta = true;
						}
					}
				}// fin for

				if (esta == false)
					System.out.println("Alumno inexistente");

			}catch (IOException ioe){
				System.out.println("\nError "+ioe.toString());
			}
		}else
			System.out.println("No hay datos en el fichero");
	}// fin metodo modificarNota

}
