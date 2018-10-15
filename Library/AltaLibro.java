package LibreriaJJ;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class AltaLibro {

	public static void altaLibro(File f, Scanner sc, long tamanhoRegistro) {
		long contadorRegistros = 0;
		RandomAccessFile raf=null;
		String titulo="";
		String autor="";
		float precio=0f;
		int cantidad=0;
		try {
			
			raf=new RandomAccessFile(f,"rw");
			//System.out.println(raf.length());
			System.out.println("Título:");
			titulo=sc.nextLine();
			
			if(titulo.length()<30) {
				for(int i=titulo.length(); i <30; i++)
					titulo=titulo+" ";
			}else {
				titulo.substring(0,30);
			}
			
			
			System.out.println("Autor:");
			autor=sc.next();
			sc.nextLine();
			
			if(autor.length()<50) {
				for(int i=autor.length(); i <50; i++)
					autor=autor+" ";
			}else {
				autor.substring(0,50);
			}
			
			System.out.println("Precio:");
			String precioAux=sc.next();
			
			precio=Float.parseFloat(precioAux);
			
			System.out.println("Cantidad:");
			cantidad=sc.nextInt();
			
			contadorRegistros = (int)Math.ceil ((double)raf.length()/ (double)tamanhoRegistro);
			
			raf.seek((contadorRegistros)*tamanhoRegistro);
			raf.writeInt((int)contadorRegistros+1);
			raf.writeUTF(titulo);
			raf.writeUTF(autor);
			raf.writeFloat(precio);
			raf.writeInt(cantidad);
			
			
			
		}
		catch(NumberFormatException nfe){
			System.out.println("Error al introducir los datos");
		}catch(FileNotFoundException fnf){
			System.out.println("Fichero inexistente");
		}catch (IOException ioe) { 
			System.out.println(" Error al escribir en el fichero");
			ioe.printStackTrace();
		}finally {
			try {
				raf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
