import java.util.Scanner;
public class comparar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int secreto=6;
		int intento;
		Scanner sc= new Scanner(System.in);
		System.out.println(" introduce un entero:");
		intento= sc.nextInt();
		
		if (intento > secreto) {
			
		System.out.println("el número es menor que :" +intento);
		}
		else {
		System.out.println("el número es mayor o igual que:" +intento);
		}
		sc.close();
	}
	
 

}
