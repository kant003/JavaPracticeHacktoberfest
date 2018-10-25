package Ejercicio2JuanJPuertas;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MostrarAlumnos {
	
	public static void mostrarAlumnos(File f) {
		int notaAccesoDatos=0; 
		int notaInterfaces=0; 
		int notaMultimedia=0; 
		int notaServicios=0;
		int notaSistemaGestion=0;
		int notaEmpresa=0;
		int totalAlumnos=0;
	FileInputStream fis=null;
	ObjectInputStream ois=null;
	try {
	fis=new FileInputStream(f);
	ois=new ObjectInputStream(fis);
	Alumno a;
	while(true) {
		
		a=(Alumno)ois.readObject();
		totalAlumnos++;
		System.out.println(a.toString()
				+"\n Nota Media: "+a.notaMedia());
		System.out.println("\n------------------------------------------------------------------\n");
		notaAccesoDatos+=a.getNotaAccesoDatos(); 
		notaInterfaces+=a.getNotaInterFaces(); 
		notaMultimedia+=a.getNotaMultimedia(); 
		notaServicios+=a.getNotaServicios();
		notaSistemaGestion+=a.getNotaSistemaGestion();
		notaEmpresa+=a.getNotaEmpresa();
	}
	
	
	
	}
	catch(FileNotFoundException fnfe) {
		System.out.println("Error al encontrar el fichero");
	}
	catch(ClassNotFoundException cnfe) {
		System.out.println("Clase no encontrada");
	}
	catch(EOFException eofe) {
		System.out.println("Fin del fichero");
	} 
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	finally {
		System.out.println("Las medias totales por asignatura son: "
				+ "\n Acceso a datos: " + notaAccesoDatos/totalAlumnos
				+ "\n Interfaces: "+notaInterfaces/totalAlumnos
				+ "\n Multimedia: "+notaMultimedia/totalAlumnos
				+ "\n Servicios: "+notaServicios/totalAlumnos
				+ "\n Sistemas de gestion: "+notaSistemaGestion/totalAlumnos
				+ "\n Empresa: "+notaEmpresa/totalAlumnos);
		
		try {
		ois.close();
		fis.close();
		} 
		catch(FileNotFoundException fnfe) {
			System.out.println("Error al encontrar el fichero");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	
}
