package Ejercicio2JuanJPuertas;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MostrarAlumnosAprobados {

	public static void mostrarAlumnosAprobados(File f) {
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		Alumno a;
		try {
			fis = new FileInputStream(f);
			ois=new ObjectInputStream(fis);
			
			System.out.println("Alumnos aprobados en todas las asignaturas: ");
			while(true) {
				a=(Alumno)ois.readObject();
				
				if( a.getNotaAccesoDatos() > 4 && a.getNotaEmpresa() > 4 && a.getNotaInterFaces() > 4 && a.getNotaMultimedia() > 4 && a.getNotaServicios() > 4 && a.getNotaSistemaGestion()>4) {
					System.out.println(a.getNombre());
				}
			}
			
		} 
		catch(EOFException eofe) {
			System.out.println("Fin del archivo");
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
