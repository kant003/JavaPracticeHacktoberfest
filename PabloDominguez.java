public class PabloDominguez {
    public static double DolarAEuro(double dolar) {
		
		double moneda=0;
		moneda = dolar*1.05;
		return moneda;
		
	}
	public static double EuroADolar (double euro) {
		double moneda=0;
		moneda = euro*0.96;
		return moneda;
		
	}
	public static void main(String[] args) {
		double aux;
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduce los dolares: ");
		aux=sc.nextDouble();
		System.out.println("En Euros es: " + DolarAEuro(aux));
		
		System.out.println("Introduce los Euros: ");
		aux=sc.nextDouble();
		System.out.println("En Dolares es: " + EuroADolar(aux));
	}

}

