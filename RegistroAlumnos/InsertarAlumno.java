package Ejercicio2JuanJPuertas;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class InsertarAlumno {

	public static void insertarAlumno(File f,Scanner sc) {
		
		String nombre=""; 
		int notaAccesoDatos=0; 
		int notaInterfaces=0; 
		int notaMultimedia=0; 
		int notaServicios=0;
		int notaSistemaGestion=0;
		int notaEmpresa=0;
		
		System.out.println("Procederemos a insertar un alumno.");
		System.out.println("Nombre");
		nombre=sc.nextLine();
		System.out.println("Nota acceso a datos");
		notaAccesoDatos=Integer.parseInt(sc.nextLine());
		System.out.println("Nota interfaces");
		notaInterfaces=Integer.parseInt(sc.nextLine());
		System.out.println("Nota multimedia");
		notaMultimedia=Integer.parseInt(sc.nextLine());
		System.out.println("Nota Servicios");
		notaServicios=Integer.parseInt(sc.nextLine());
		System.out.println("Nota Sistemas de gestion");
		notaSistemaGestion=Integer.parseInt(sc.nextLine());
		System.out.println("Nota Empresa");
		notaEmpresa=Integer.parseInt(sc.nextLine());
		
		crearAlumno(f,nombre,notaAccesoDatos,notaInterfaces,notaMultimedia,notaServicios,notaSistemaGestion,notaEmpresa);
	}
	
	public static void crearAlumno(File f, String nombre, int notaAccesoDatos, int notaInterFaces, int notaMultimedia, int notaServicios,int notaSistemaGestion,int notaEmpresa) {
		
		FileOutputStream fis=null;
		ObjectOutputStream oos=null;
		MiObjectOutputStream moos=null;
		try {
			if(f.exists()) {
				fis=new FileOutputStream(f,true);
				moos=new MiObjectOutputStream(fis);
				
				Alumno a=new Alumno(nombre,notaAccesoDatos, notaInterFaces, notaMultimedia, notaServicios, notaSistemaGestion, notaEmpresa);
				moos.writeObject(a);
			}else {
				fis=new FileOutputStream(f);
				oos=new ObjectOutputStream(fis);
				
				Alumno a=new Alumno(nombre,notaAccesoDatos, notaInterFaces, notaMultimedia, notaServicios, notaSistemaGestion, notaEmpresa);
				oos.writeObject(a);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
			if(fis!=null) {
				fis.close();
			}
			if(moos!=null) {
				moos.close();
			}
			if(oos!=null) {
				oos.close();
			}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
