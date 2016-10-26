package com.hacktoberfest;

import java.util.Scanner;
public class LeerParOImpar {

	public static void main(String[] args) {
		int num;
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Introduzca un número: ");
		
		num=sc.nextInt();
		while(num!=0) // mientras num sea distinto de 0
		{
		if(num%2 == 0)
		// si el resto de dividir entre dos es cero: esto indica que es par
		System.out.println("Par");
		else
		// en caso contrario: impar
		System.out.println("Impar");
		
		// repetimos el proceso y volvemos a leer num
		System.out.print("Introduzca otro número: ");
		num=sc.nextInt();
		}
		// al salir del mientras tenemos la certeza que num es 0
		}
		}
