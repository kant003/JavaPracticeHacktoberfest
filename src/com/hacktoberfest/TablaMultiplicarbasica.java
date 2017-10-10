
package com.hacktoberfest;
import java.util.Scanner;
public class TablaMultiplicarbasica {

	public static void main(String []args){
		Scanner sc=new Scanner(System.in);
	int numero;
	System.out.println("Introduce un número: ");
	numero=sc.nextInt();
	sc.close();
	
	
	for (int i=1;i<=10;i++){
	
	System.out.println(numero+" x "+i+" = "+ numero*i);
		
	}
	}
	
	
}
