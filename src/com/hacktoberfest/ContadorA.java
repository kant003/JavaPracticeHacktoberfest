package com.hacktoberfest;
public class ContadorA {

	final static String TEXTO = "CamiseTAS gratis para todos";

	public static void main(String[] args)
	{
		char[] letras  = TEXTO.toLowerCase().toCharArray();

		int contadoraes = 0;
		for(char letra : letras ){
			if(letra=='a'){
				contadoraes +=1;
			}
			}
		System.out.println("Tienes " + contadoraes + " aes.");


	}
}