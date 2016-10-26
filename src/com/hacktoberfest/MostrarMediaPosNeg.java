package com.hacktoberfest;
import java.util.*;
public class MostrarMediaPosNeg {
	

	public static void main(String[] args) {
		int num;
		int cont_ceros; // el contador de ceros
		int cont_pos; // contador de positivos
		int cont_neg; // contador de negativos
		int suma_pos,suma_neg; // suma de los números positivos y negativos
		float media_pos,media_neg; // las medias 8positivas y negativa9 pueden tener decimales

		cont_ceros=0;
		cont_pos=0;
		cont_neg=0;
		suma_pos=0;
		suma_neg=0;
		for (int i=1;i<=10;i++)
		{
			Scanner sc=new Scanner(System.in);
		System.out.print("Introduce número: ");
		num=sc.nextInt();
		if(num==0)
		cont_ceros++;
		else
		{
		if(num>0)
		{
		cont_pos++;
		suma_pos+=num;
		}
		else
		{
		cont_neg++;
		suma_neg+=num;
		}
		}
		}
		// tratamos los ceros
		System.out.println("El número de ceros introducidos es de: "+cont_ceros);
		//Tratamos los positivos
		if (cont_pos ==0)
		System.out.println("No se puede hacer la media de los positivos");
}
}
