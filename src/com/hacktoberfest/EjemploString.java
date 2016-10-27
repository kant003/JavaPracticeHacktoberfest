package com.hacktoberfest;

import java.util.Scanner;

public class EjemploString {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String [] array  = new String[5];
		
		for(int i=0;i<array.length;i++){
			System.out.println("Introduce una palabra");
			array[i] = sc.nextLine().split(" ")[0];
			
		}
		for(int i=array.length-1;i>=0;i--){
			System.out.println(array[i]);
		}
	}
}