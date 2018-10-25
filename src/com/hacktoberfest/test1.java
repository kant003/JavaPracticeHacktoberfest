package com.hacktoberfest;

public class test1 {

	public static void main(String[] args) {
		
		int recogeedad;
		char recogecolor;
		
		felipe felipebird;
		felipebird = new felipe();
		felipebird.setedad(5);
		felipebird.printedad();
		felipebird.setcolor('n');
		felipebird.printcolor();
		
		recogeedad=felipebird.getedad();
		recogecolor=felipebird.getcolor();
		
		System.out.println("El pajaro tiene "+recogeedad+" años");
		System.out.println("El pajaro es de color "+recogecolor);
		
	}

}