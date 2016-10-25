package com.hacktoberfest;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.PrintWriter;
import java.util.Scanner;

public class UpperCase {
	
	//Method to convert the phrase you write to capital letters and save it in a file.
	public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
			File f = new File("Fichero.txt");
	        PrintWriter salida=null;
			try {
				salida = new PrintWriter(f);
		        boolean fuera=true;
		        String cadena;
		        
		        do{
			        System.out.println("Introduce a phrase, type # to stop");
			        cadena= sc.nextLine();
			        if(cadena.equals("#")) fuera=false;
			        else salida.println(cadena.toUpperCase());
		        }while(fuera);
	 
			}catch(FileNotFoundException fn){
				System.out.println("Error. File doesn't exists.");
			}finally{
					sc.close();
					salida.flush();
					salida.close();
					
			}
	}
	}