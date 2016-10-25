package com.hacktoberfest;
import java.util.Scanner;

public class suma {

	private static Scanner a1;
	private static Scanner a2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 0, m = 0, suma;
		suma = n + m;
		a1 = new Scanner(System.in);
		a2 = new Scanner(System.in);
		System.out.println("introdusco primer digito a sumar : ");
		n = a1.nextInt();
		System.out.println("sigiente numero a sumar");
		m = a2.nextInt();

		System.out.println("resultado : " +suma);
	}

}
