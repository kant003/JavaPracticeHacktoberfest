package com.hacktoberfest;

import java.util.Scanner;

public class AUbeiraContador {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num, contador;
		System.out.println("Introduzca un número:");
		num=sc.nextInt();
		contador=0;
		while(num>0)
		{
			contador++;
			System.out.println("Introduzca un numero mas: ");
			num=sc.nextInt();
		}
		System.out.println("Ha introducido "+ contador + " numeros ");
		sc.close();

	}
	
}
