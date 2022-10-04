package metodos;

import java.util.Scanner;

public class Conversorgrados {
	
	public static double	cAf(double c) {
		double temp = 0;
		temp = (9*c/5)+32;
		return temp;
	}
		
		public static double	fAc(double f) {
			double temp = 0;
			temp = 5*(f-32)/9;
			return temp;			
	}
		
	public static void main(String[] args) {
		
		double aux;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("introduce grados cº: ");
		aux= sc.nextDouble();
		System.out.println("en grados fº: " + cAf(aux));
		
		System.out.println("introduce grados fº: ");
		aux= sc.nextDouble();
		System.out.println("en grados cº: " + fAc(aux));
		
		
		
	}
	
}
