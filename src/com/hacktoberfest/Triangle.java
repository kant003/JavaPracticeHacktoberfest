/**
 * The class prints out a triangle pyramid with *.
 */

package com.hacktoberfest;


public class Triangle {

	public static void main(String[] args) {
		trianglePyramid(10); // Pyramid with 10 rows
	}

	public static void trianglePyramid(int rows) {
		int counter = rows;
		int spaces = rows - 1;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < counter; j++) {
				if (j < spaces)
					System.out.print(" ");
				else 
					System.out.print("*");
			}
			System.out.println();
			counter++;
			spaces--;
		}
	}

}
