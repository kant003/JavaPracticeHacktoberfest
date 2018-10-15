package Ejercicio3JuanJPuertasFormigo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class MostrarClientes {

	public static void mostrarClientes(File f,Scanner sc) {
		System.out.println("A continuacion se mostraran los clientes con saldo negativo");
		RandomAccessFile raf=null;
		int numRegistros;
		long tamRegistro=100;
		int numCuenta=0;
		String nombre="";
		String direccion="";
		int telefono=0;
		double saldo=0;
		try {
			raf=new RandomAccessFile(f,"r");
			numRegistros=(int)Math.ceil ((double)raf.length()/ (double)tamRegistro);
			for(int i = 0;i<numRegistros;i++) {
			raf.seek(i*tamRegistro);
			numCuenta=raf.readInt();
			nombre=raf.readUTF();
			direccion=raf.readUTF();
			telefono=raf.readInt();
			saldo=raf.readDouble();
			 System.out.println(numCuenta+" "+nombre+" "+direccion+" "+telefono +" "+saldo);
			if(saldo<0) {
				System.out.println(nombre);
			}
			}
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
