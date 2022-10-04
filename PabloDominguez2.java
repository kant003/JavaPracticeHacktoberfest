import java.util.Scanner;
public class PabloDominguez2 {
    public static double centAFahr(double celsius) {
		
		double temperatura=0;
		temperatura = (9*celsius/5) + 32;
		return temperatura;
		
	}
	public static double fahrACent (double fahrenheit) {
		double temperatura=0;
		temperatura = 5* (fahrenheit-32)/9;
		return temperatura;
		
	}
	public static void main(String[] args) {
		double aux;
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduce grados centigrados: ");
		aux=sc.nextDouble();
		System.out.println("En fahrenheit da: " + centAFahr(aux));
		
		System.out.println("Introduce grados fahrenheit: ");
		aux=sc.nextDouble();
		System.out.println("En celsius da: " + fahrACent(aux));
	}
    
}
