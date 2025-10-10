package Reisen;

import java.util.Scanner;

public class propuesto7 {

	
	public static double Miame(double millas) {
		double aux;
		aux = millas*1852/1;
		return aux;
	}
	public static double Miakm(double millas) {
		double aux;
		aux= Miame(millas);
		return aux/1000;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double mil=sc.nextDouble();
	}
}
