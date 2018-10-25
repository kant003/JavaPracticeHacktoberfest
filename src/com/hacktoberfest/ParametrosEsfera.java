package com.hacktoberfest;
/*Clase que te calcula la longitud, el área y el volumen de una esfera*/
public class ParametrosEsfera{
	
	public static void main(String[] args){
		double longitud, area, volumen;
		double radio=5;

		longitud=2*3.1416*radio;//2*pi*r
		area=3.1416*radio*radio;//pi*area^2
		volumen=(double)3/4*3.1416*Math.pow(radio, 3);

		System.out.println("Longitud=" +longitud);
		System.out.println("Area=" +area);
		System.out.println("Volumnen=" +volumen);

	}
}