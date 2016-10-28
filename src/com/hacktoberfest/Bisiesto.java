package com.hacktoberfest;

import java.util.Scanner;

public class Bisiesto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ano;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el año");
		ano=sc.nextInt();
		sc.close();
		
		if (ano%4==0&&ano%100!=0||ano%400==0){
			System.out.println("El año "+ano+" es bisiesto");
		
		}
		else 
			
			System.out.println("El año "+ano+" no es bisiesto");
	}

}
