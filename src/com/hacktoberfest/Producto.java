package com.hacktoberfest;

import java.util.Scanner;

public class Producto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int contador=0, multiplicar=1,impares=0;

		do{
			impares=impares +1;
			if(impares%2!=0){
				multiplicar=multiplicar *impares;
				contador++;
			}
			}while (contador<10);
		
			System.out.println("Muestra el producto de los 10 primeros numeros impares: " + multiplicar);

		
		}
				
	}
