package com.hacktoberfest;

import java.util.*;
public class MostrarCuadradoNumero {

	public static void main(String[] args) {
		int num,cuadrado;
		Scanner sc=new Scanner(System.in);
		// num guardará el número que leamos
		// y cuadrado guardará el cuadrado de num
		
		System.out.print("Introduzca número: ");
		num=sc.nextInt();
		while(num>=0){ 
		// repetimos el proceso mientras el número leído no sea negativo
		cuadrado=num*num;
		System.out.println(num+ "² es igual a "+ cuadrado);
		System.out.print("Introduzca otro número: ");
		num=sc.nextInt();
		// volvemos a leer num
		}
		}
		}
