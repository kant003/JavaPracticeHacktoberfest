import java.util.Scanner;

public class comparar2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int secreto = 6;
		int intento;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Introduce un entero: ");
		intento= sc.nextInt();
		
		if(intento==secreto) {
			System.out.println("HAS ACERTADO");
		}
		else if(intento>secreto) {
			System.out.println("El numero introducido es MAYOR que el secreto.");
		}
		else {
			System.out.println("El numero introducido es Menor que el secreto.");
		}
		sc.close();
	}

}
