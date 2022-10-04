
import java.util.Scanner;

public class GabrielRomero {
    
    //1 euro = 0,96 dolares
	public static double  euroADolar(double e) {
		
		double temp=0;
		temp = e*0.96 ;
		return temp;
	}
	
	//1 dolar= 1,05 euros
	public static double dolarAEuro(double d) {
		
		double temp=0;
		temp =  d*1.05;
		return temp;
	}

	public static void main(String[] args) {
		
		double aux;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("por favor introduzca euros: ");
		aux=sc.nextDouble();
		System.out.println("en dolares son: "+euroADolar(aux));
		
		System.out.println("por favor introduzca dolares: ");
		aux=sc.nextDouble();
		System.out.println("en euros son: "+dolarAEuro(aux));

		sc.close();
	}
}
