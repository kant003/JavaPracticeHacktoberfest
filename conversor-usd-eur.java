package metodos;

import java.util.Scanner;

public class Conversormonedas {

	public static double	usdeur(double eur) {
		double a = 0;
		a = eur*1.05;
		return a;
	}
		
		public static double	eurusd(double usd) {
			double a = 0;
			a = usd*0.96;
			return a;			
	}
		
	public static void main(String[] args) {
		
		double aux;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("introduce usd: ");
		aux= sc.nextDouble();
		System.out.println("en eur: " + usdeur(aux));
		
		System.out.println("introduce eur: ");
		aux= sc.nextDouble();
		System.out.println("en usd: " + eurusd(aux));
}
}