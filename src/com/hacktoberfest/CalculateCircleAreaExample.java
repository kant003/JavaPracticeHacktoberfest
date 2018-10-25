package com.hacktoberfest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculateCircleAreaExample {

	public static void main(String[] args) {

		int r = 0;
		System.out.println("Please enter radius of a circle");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			r = Integer.parseInt(br.readLine());
		} catch (Exception ne) {
			System.out.println("invalid value" + ne);
			return;
		} 
		// Math.PI constant to get value of pi
		double area = Math.PI * (r * r);

		System.out.println("Area of a circle is " + area);
	}
}
