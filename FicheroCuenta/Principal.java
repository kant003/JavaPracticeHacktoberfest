package Ejercicio3JuanJPuertasFormigo;

import java.io.File;
import java.util.Scanner;

public class Principal {

	public static final long tamRegistro=100;
	
	public static void main(String[]args) {
		
		Scanner sc=new Scanner(System.in);
		int opcion=0;
		File f=new File("cuentas.dat");
		do {
			System.out.println("Introduzca la opcion que quiera usar");
			opcion=Integer.parseInt(sc.nextLine());
			
			switch(opcion) {
			case 1:
				InsertarCuenta.insertarCuenta(f,sc);
				break;
			case 2:
				ModificarCuenta.modificarCuenta(f, sc);
				break;
			case 3:
				MostrarClientes.mostrarClientes(f,sc);
				break;
			case 4:
				System.out.println("Programa finalizado");
				break;
			default:
				System.out.println("Inroduce un numero valido");
			
			}
		}while(opcion!=4);
		
	}
	
}
