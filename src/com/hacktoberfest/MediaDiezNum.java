package com.hacktoberfest;
import java.util.Scanner;

public class MediaDiezNum {
	public static void main(String[] args) {


		float mediapos=0, medianeg=0, positivos=0, negativos=0, cero=0, num=0;
		
		for (int i=1; i<=10; i++){
			Scanner sc=new Scanner (System.in);
			System.out.println("Introduzca un número");
			num=sc.nextFloat();
			
			if (num>0){
				positivos ++;
				mediapos=mediapos+num;
				}
			
			else if(num==0){
					cero++;
					
				}
			
			else{
				negativos++;
				medianeg=medianeg+num;
				}
			
		
			
		}
		
		mediapos=mediapos/positivos;
		medianeg=medianeg/negativos;
		
		System.out.println("La media de los numeros negativos introducidos es: " + medianeg);
		System.out.println("La media de los numeros positivos introducidos es: " + mediapos);
		System.out.println("El numero de ceros introducidos es: " + cero);
	}

}


