package propuesto;

import java.util.Scanner;

public class metodos2 {
	
	public static double centAFahr(double c) {
		double f = (9*c/5)+32 ;
		return f;
	}
	public static double fahrACent(double f) {
		double c = 5*(f-32)/9 ;
		return c;
	}
	
	

	public static void main(String[] args) {
		
		double aux;
		
		Scanner sc= new Scanner(System.in) ;
		
		System.out.println("numero de centigrados");
		aux=sc.nextDouble();	
		System.out.println("en fahr "+ centAFahr(aux));
		
		System.out.println("numero de fahr");
		aux=sc.nextDouble();	
		System.out.println("en centigrados "+ fahrACent(aux));
	
	
	}

}
