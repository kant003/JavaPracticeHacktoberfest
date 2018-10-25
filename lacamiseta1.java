import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner (System.in);
	
		
		int edad;
		int nivel_de_estudios;
		int ingresos;
		boolean jasp;
		
		
		
		System.out.println("Introduzca su edad ");
		edad=sc.nextInt();
		
		System.out.println("Introduzca su nivel de estudios");
		nivel_de_estudios=sc.nextInt();
		
		System.out.println("Introduza sus ingresos");
		ingresos=sc.nextInt();
		
		jasp = ((edad <= 28) && (nivel_de_estudios > 3) && (ingresos > 28000));
		
		System.out.println("Chaval tu jasp es "+jasp);
	}

}
