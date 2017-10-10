package com.hacktoberfest;

public class ProductoImpares {
	public static void main(String[] args) {

		long producto = 1;

		for (int i = 1; i < 20; i += 2) {
			producto = producto * i;
		}
		System.out.println("La multiplicación de los 10 primeros impares: " + producto);

	}
}
