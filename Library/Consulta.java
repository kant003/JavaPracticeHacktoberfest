package LibreriaJJ;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Consulta {

	public static void consulta(File f,int opcion,Scanner sc,long tamanhoRegistro) {
		int registro=1;
		String autor="";
		String autorFichero="";
		RandomAccessFile raf=null;
		int cantidad=0;
		int sumaCantidad=0;
		long contadorRegistros = 0;
		try {
			raf=new RandomAccessFile(f,"rw");
			contadorRegistros = (int)Math.ceil ((double)raf.length()/ (double)tamanhoRegistro);
			if(opcion==1) {
			System.out.println("¿Que numero de registro quieres comprobar?");
			registro=sc.nextInt();
			raf.seek((registro-1)*tamanhoRegistro);
			System.out.println(raf.readInt()+" "+raf.readUTF()+" "+raf.readUTF()+" "+raf.readFloat()+" "+raf.readInt());
		}
		else if(opcion==2) {
			System.out.println("¿Que autor quieres comprobar?");
			autor=sc.next();
			sc.nextLine();
			
			for(int i=0;i<contadorRegistros;i++) {
				raf.seek((i)*tamanhoRegistro);
			raf.readInt();
			raf.readUTF();
			autorFichero=raf.readUTF();
			System.out.println(autorFichero);
			raf.readFloat();
			cantidad=raf.readInt();
			System.out.println(cantidad);
			
			autorFichero=autorFichero.substring(0, autor.length());
			
			if(autorFichero.equalsIgnoreCase(autor)) {
				System.out.println("recibido");
				sumaCantidad+=cantidad;
			}
			
			}
			
				System.out.println("El numero total de ejemplares disponibles del autor "+autor+" es "+sumaCantidad);
			
		}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
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
