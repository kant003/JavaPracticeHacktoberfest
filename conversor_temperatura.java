import java.util.Scanner;

public class conversor_temperatura {

	
	
	
	public static double conversor(double c) {
		
		double f = (c*9/5)+32;
		return f;
		
	}
	
public static double conversor2 (double f) {
	
	double c = ((f-32) * 5/9);
			return c;
	
}
	




	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			double num;

			System.out.println("Introduce un número para pasar de celsius a fahrenheit");
			num = sc.nextDouble();
			
			System.out.println( num + " en Fahrenheit = " + conversor(num));
			
			System.out.println("Introduce un número para pasar de fahrenheit  a celsius");
			num = sc.nextDouble();
			
			System.out.println( num + " en celsius = " + conversor2(num));
		}
		
		
		
	}

}
