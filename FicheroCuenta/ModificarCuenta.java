package Ejercicio3JuanJPuertasFormigo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ModificarCuenta {

	public static void modificarCuenta(File f, Scanner sc) {
		RandomAccessFile raf=null;
		int posicion=0;
		long tamRegistro=100;
		int numCuenta=0;
		String nombre="";
		String direccion="";
		int telefono=0;
		double saldo=0;
		double insercion=0;
		try {
			System.out.println("introduzca el registro a modificar");
			raf=new RandomAccessFile(f,"rw");
			posicion=Integer.parseInt(sc.nextLine());
			raf.seek(posicion*tamRegistro);
			numCuenta=raf.readInt();
			nombre=raf.readUTF();
			direccion=raf.readUTF();
			telefono=raf.readInt();
			saldo=raf.readDouble();
			
			
			System.out.println("Introduce la cantidad a añadir");
			insercion=Double.parseDouble(sc.nextLine());
			raf.seek((posicion-1)*tamRegistro);
			raf.writeInt(numCuenta);
			raf.writeUTF(nombre);
			raf.writeUTF(direccion);
			raf.writeInt(telefono);
			raf.writeDouble(saldo+insercion);
			
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(raf!=null) {
				try {
					raf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
