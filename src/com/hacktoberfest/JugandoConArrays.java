package com.hacktoberfest;

import java.lang.reflect.Array;
import java.util.Scanner;

public class JugandoConArrays {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int[] numeros = new int[5];
		System.out.println("Dame 5 números: ");
		for(int i=0;i<5;i++){
			numeros[i] = sc.nextInt();
		}
		//mostramos por orden de entrada
		for(int i=0;i<5;i++){
			System.out.println(numeros[i]);
		}
		//mostramos de ultimo hasta el primero
		for(int i=4;i>-1;i--){
			System.out.println(numeros[i]);
		}
		
		int aux;
		for(int j=0;j<5;j++){
			for(int i=1;i<5;i++){
				if(numeros[i]<numeros[i-1]){
					aux=numeros[i];
					numeros[i]=numeros[i-1];
					numeros[i-1]=aux;
				}	
			}
		}
		for(int i=0;i<5;i++){
			System.out.println(numeros[i]);
		}
	}

}
