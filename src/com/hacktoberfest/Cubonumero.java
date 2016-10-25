package com.hacktoberfest;
import java.util.Scanner;
public class Cubonumero {


	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
		int numero;
		System.out.println("Introduce un número: ");
		numero=sc.nextInt();
		
	
		System.out.println(numero +" al cubo es: "+Math.pow(numero, 3));
	}
}