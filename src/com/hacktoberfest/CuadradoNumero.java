package com.hacktoberfest;

import java.util.Scanner;

/* Leer un número y mostrar su cuadrado, 
 * repetir el proceso hasta que se introduzca un número negativo.
 */
public class CuadradoNumero {

	public static void main(String[] args) {
		 
		 Scanner sc=new Scanner(System.in);
		 int num,cuadrado;  
		 // num guardará el número que leamos  
		 // y cuadrado guardará el cuadrado de num  
		 
		 System.out.print("Introduzca número: ");   
		 num=sc.nextInt();    
		 
		 while(num>=0){ // repetimos el proceso mientras el número leído no sea negativo 
			 cuadrado=num*num;  
			 System.out.println(num+ "² es igual a "+ cuadrado);     
			 System.out.print("Introduzca otro número: ");       
			 num=sc.nextInt(); // volvemos a leer num      
			 }     
		 }
}
	