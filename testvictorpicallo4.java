import java.util.Scanner;

public class testvictorpicallo4 {
    
    public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Dime patatas para iniciar:");
		double p = sc.nextDouble();
		System.out.println("Dime chocos para iniciar");
		double c = sc.nextDouble();
		victorpicallo4 isra = new victorpicallo4(p, c);

		System.out.println(isra.toString());

		isra.muestraComensales();

		System.out.println(isra.toString());
		sc.close();

	}
}


