package com.hacktoberfest;
import java.util.*;
public class BucleSumasIncrementales {
	/*Programita que va sumando hasta el número límite un número+1, y así sucesivamente, dádndonos el total*/

		public static void main(String[] args) {
			Scanner entrada=new Scanner(System.in);
			int num=0, cont=0, total=0, cont2=1, suma=0;
			
			do{//Mientras el número sea mayor que cero, entra
			System.out.print(" Dame el numero limite: ");
			num= entrada.nextInt();
			}while(num<=0);
			
			do{
				cont=cont+1;
				total=total+cont;
				
				/*Ponemos esta condicional para evitar, en el caso del 5, que nos muestre el numero 6
				 *  dado que entra bucle al comprobar la condicion y lo mismo para la suma.*/
				if(total<=num){
					System.out.println(total);
					suma=suma+total;
				}
			
			}while(total<num);
			
			System.out.println(" La suma total es: "+suma);
			
		}

	}
