package com.hacktoberfest;

import java.util.Scanner;

public class SqrtNewton {
	private static final double PRECISION = 1E-10;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double n = s.nextDouble();
		System.out.println(sqrt(n, PRECISION)); //prints out first 20
	}

	public static double sqrt(double number, double precision) {
        if (number < 0) return Double.NaN;
        double t = number;
        while (Math.abs(t - number/t) > precision*t)
            t = (number/t + t) / 2.0;
        return t;
	}

}
