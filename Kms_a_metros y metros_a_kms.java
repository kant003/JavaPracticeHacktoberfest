package proyectos;

import java.util.Scanner;

public class ejercicioMetodos {
	//vamos a construir un método que haga la conversión de
	//metros a kilometros
		protected static double metrosAKilometros(double m) {
		double k =  m/1000;
			return k;
		}
		protected static double kilometrosAMetros(double k) {
		double m = k*1000;
			return m;
		}
	
	public static void main(String[] args) {
		double metros;
		double kilometros;
		Scanner sc = new Scanner(System.in);
		System.out.println("por favor introduzca número de metros: "); metros=sc.nextDouble();
		kilometros=metrosAKilometros(metros);
		System.out.println("en kilometros son: " + kilometros);
		
		System.out.println("introduce kilometros: "); kilometros=sc.nextDouble();
		metros=kilometrosAMetros(kilometros);
		System.out.println("en metros son: " + metros);
		
	}
}
