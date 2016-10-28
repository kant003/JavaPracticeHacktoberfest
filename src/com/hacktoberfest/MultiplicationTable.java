package com.hacktoberfest;

import java.util.Scanner;

public class MultiplicationTable {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Type a number to see its multiplication table");
		int n = sc.nextInt(), m = 0;

		do {
			m = m + 1;
			System.out.println(n + "x" + m + "=" + n * m);
		} while (m < 10);
		sc.close();

	}

}
