package ejemplos04BLecturaEscrituraTexto;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejemplo01LecturaEscritura {

	public static void main(String[] args) {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int opcion = 0;
		do{
			try{
				System.out.println("1.- Escribir en el fichero");
				System.out.println("2.- Leer del fichero");
				System.out.println("3.- Salir");
				System.out.println("Elegir opcion: ");
				opcion = Integer.parseInt(br.readLine());
				switch (opcion){
				case 1:
					EscrituraDisco();
					break;
				case 2:
					LecturaDisco();
					break;
				}
			}catch(NumberFormatException e){
				System.out.println("Error al introducir la opcion");
			}catch(IOException ioe){
				System.out.println("Error al introducir la opcion");
			}
		}while(opcion != 3);
	}
	static void EscrituraDisco(){ File archivo = null;
	DataOutputStream flujoescritura = null;
	String respuesta="";
	System.out.println("Introduce el nombre del fichero de claves desde el teclado") ;
	try{
		String nombrefich= new BufferedReader (new InputStreamReader (System.in)).readLine().trim(); archivo= new File (nombrefich) ; if (archivo.exists()){
			System.out.println ("El fichero ya existe ¿Desea sobreescribirlo (SI/NO)?");
			respuesta= new BufferedReader (new InputStreamReader (System.in)).readLine().trim();
		}
		//compareToIgnoreCase es que compare sin distinguir mayúsculas y minúsculas
		if (respuesta.compareToIgnoreCase("si")==0){
			flujoescritura = new DataOutputStream ( new FileOutputStream(nombrefich));
		}else{
			flujoescritura= new DataOutputStream (new FileOutputStream(nombrefich,true));
		}
		System.out.println ("Introduce el nombre del usuario por teclado: ");
		String nombre= new BufferedReader (new InputStreamReader (System.in)).readLine().trim();
		System.out.println ("Introduce el código del usuario por teclado: ");
		int codigo = Integer.parseInt(new BufferedReader (new InputStreamReader (System.in)).readLine().trim());
		flujoescritura.writeInt(codigo);
		flujoescritura.writeUTF(nombre);
	}catch (IOException ioe){
		System.out.println("No se ha podido escribir la información en el fichero " +archivo.getName());
	}finally{
		try{
			if (flujoescritura != null){
				flujoescritura.close();
			}
		}catch (IOException ioe){
			System.out.println("No se ha podido cerrar correctamente el flujo del fichero " + archivo.getName());
		}
	}
	}// fin EscrituraDisco
	static void LecturaDisco(){
		File archivo = null;
		DataInputStream flujolectura =null;
		
		System.out.println("Introduce el nombre del fichero por teclado") ;
		try{
			archivo= new File (new BufferedReader (new InputStreamReader (System.in)).readLine().trim());
			flujolectura= new DataInputStream (new FileInputStream(archivo));
			//Ojo el orden al leer tiene que ser el mismo que al escribir
			while (true){
				System.out.println ("Codigo de Usuario: "+ flujolectura.readInt());
				System.out.println ("Nombre de Usuario: "+ flujolectura.readUTF());
			}
		}catch (FileNotFoundException fnf){
			System.out.println("No se ha podido encontrar el fichero " +archivo.getName());
		}catch (EOFException eof){
		}catch (IOException ioe){
			System.out.println("No se ha podido leer la información del fichero " +archivo.getName());
		}finally{
			try{
				if (flujolectura!=null){
					flujolectura.close();
				}
			}catch (IOException ioe){
				System.out.println("No se ha podido cerrar el flujo del fichero " + archivo.getName());
			}
		} //fin finally
	}//fin main
}// fin clase


