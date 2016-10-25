package com.hacktoberfest;
import java.io.*;
import java.util.Scanner;

public class Fichero2ficheros {

	//Cada 3 nombres introducidos, el 3º se copiara tambien en otro fichero
	public static void main(String[] args) throws IOException {

		PrintWriter salida = new PrintWriter("Nombres.txt");
		PrintWriter salida2 = new PrintWriter("Nombres1.txt");
		Scanner sc = new Scanner(System.in);
		String nombre="";
		int cont = 0;
		boolean fuera=true;
		do{
			System.out.println("Siga introduciendo nombres, si desea parar escriba #");
			nombre= sc.next();
			cont ++ ;
			if(nombre.equals("#")) fuera=false;
			else salida.println(nombre);
			if(cont == 3){
				salida2.println(nombre);
				cont = 0;
			}
		}while(fuera);

		salida.flush();
		salida.close();
		salida2.flush();
		salida2.close();
		sc.close();
	}
}
