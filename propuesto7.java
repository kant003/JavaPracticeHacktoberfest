
    import java.util.Scanner;

public class propuesto7 {

	public static double millasAMetros(double millas) {
		double aux;
		aux = millas * 1852 / 1; // una milla marina son 1852m
		return aux;
	}

	public static double millasAKilometros(double millas) {
		double aux = millasAMetros(millas); // llamamos al metodo anterior
		return aux / 1000;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Dame numero de millas: ");
		double mill = sc.nextDouble();

		System.out.println("Pasadas a metros son: " + millasAMetros(mill));
		System.out.println("Y en kilometros son: " + millasAKilometros(mill));

	}
}
