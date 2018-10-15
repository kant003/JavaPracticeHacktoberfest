package Ejercicio2JuanJPuertas;

import java.io.File;
import java.util.Scanner;

public class Principal {

	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		File f=new File("alumnos.dat");
		
		int opcion=0;
		
		do {
			System.out.println("Introduce la opcion que quieres:"
					+ "\n 1 - Insertar alumno"
					+ "\n 2 - Mostrar alumnos y notas medias"
					+ "\n 3 - Mostrar alumnos aprobados");
			opcion=sc.nextInt();
			sc.nextLine();
			switch(opcion) {
			case 1:
				InsertarAlumno.insertarAlumno(f,sc);
				break;
			case 2:
				MostrarAlumnos.mostrarAlumnos(f);
				break;
			case 3:
				MostrarAlumnosAprobados.mostrarAlumnosAprobados(f);
				break;
			case 4:
				break;
			default:
				System.out.println("Programa finalizado");
			}
			
		}while(opcion!=4);
		
		sc.close();
		
	}
	
}
