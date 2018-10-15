package Ejercicio3JuanJPuertasFormigo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class InsertarCuenta {

	public static void insertarCuenta(File f, Scanner sc) {
		RandomAccessFile raf=null;
		int numCuenta=0;
		String nombre="";
		String direccion="";
		int telefono=0;
		double saldo=0;
		int numRegistros=0;
		long tamRegistro=100;
		try {
			raf=new RandomAccessFile(f,"rw");
			numRegistros=(int)Math.ceil ((double)raf.length()/ (double)tamRegistro);
			
			System.out.println("Procederemos a insertar una cuenta");
			numCuenta=numRegistros+1;
			System.out.println("Numero de cuenta autogenerado "+ numCuenta);
			System.out.println("Nombre titular");
			nombre=sc.nextLine();
			if(nombre.length()<25) {
				for(int i=nombre.length();i<=25;i++) {
					nombre+=" ";
				}
			}else {
				nombre=nombre.substring(0, 25);
			}
			System.out.println("Direccion");
			direccion=sc.nextLine();
			if(direccion.length()<25) {
				for(int i=direccion.length();i<=25;i++) {
					direccion+=" ";
				}
			}else {
				direccion=direccion.substring(0, 25);
			}
			System.out.println("Telefono");
			telefono=Integer.parseInt(sc.nextLine());
			System.out.println("Saldo");
			saldo=Double.parseDouble(sc.nextLine());
			
			raf.seek(numRegistros*tamRegistro);
			raf.writeInt(numCuenta);
			raf.writeUTF(nombre);
			raf.writeUTF(direccion);
			raf.writeInt(telefono);
			raf.writeDouble(saldo);
			
		} catch (FileNotFoundException e) {
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
