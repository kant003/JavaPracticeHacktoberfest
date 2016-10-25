package com.hacktoberfest;

import java.util.Scanner;
public class DividirNumerosDecimales {

	public static void main(String[] args) {
		double num1, num2;
		double resul;
		Scanner sc=new Scanner (System.in);
		System.out.println("Primer numero: ");
		num1=sc.nextDouble();
		System.out.println("Segundo numero: ");
		num2=sc.nextDouble();
		resul=num1/num2;
		System.out.println("El resultado es "+resul);
		sc.close();
		

	}

}
