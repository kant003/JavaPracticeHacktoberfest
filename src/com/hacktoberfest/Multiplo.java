package com.hacktoberfest;
import java.util.Scanner;


public class Multiplo {
	public static void main(String[] args) {
		int a,b;
		 
		 Scanner sc = new Scanner (System.in);
		 
		 System.out.println("Introduzca primer número: "); 
		 a=sc.nextInt();
		 
		 System.out.println("Introduzca segundo número: ");
		 b=sc.nextInt();
		 
		 
		 if (a%b==0 || b%a==0) {
			 System.out.println("Son multiplos");
			 
		 }
		 else {
			 System.out.println("No son multiplos");
		 }


	}

}


