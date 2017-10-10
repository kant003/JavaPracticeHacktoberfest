package com.hacktoberfest;

import java.util.Scanner;

public class XoelVeiga1 {
 public static void main (String [] args){
		int num, a, b, c, d;
		System.out.println("introduzca un numero entre 0 y 9999");
		Scanner N= new Scanner(System.in);
		num=N.nextInt(); 
		a=num%10;
		num=num/10;
		b=num%10;
		num=num/10;
		c=num%10;
		d=num/10;
		if (d!=0 && c!=0 && b!=0){
			System.out.println("Tiene cuatro cifras");
		}else{	
			if (d==0 && c!=0 && b!=0){
				System.out.println("Tiene tres cifras");
			}else{
				if (d==0 && c==0 && b!=0){
					System.out.println("Tiene dos cifras");
				}else{
					System.out.println("Tiene una cifra");
				}
 }
		}
		}
 }
