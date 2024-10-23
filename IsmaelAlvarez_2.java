import java.util.Scanner;

public class IsmaelAlvarez_2 {

public static void main(String[] args) {
		
		int mes;
		Scanner sc = new Scanner(System.in);
		System.out.println("dime numero mes: ");
		mes = sc.nextInt();
		
		switch(mes) {
		
		case 1,3,5,7,8,10,12:
			System.out.println("el mes tiene 31 dias");
			break;
			
		case 4,6,9,11:
			System.out.println("el mes tiene 30 dias");
			break;
			
		case 2:
			System.out.println("el mes tiene 28 dias");
			
		default:
			System.out.println("ese mes no existe empanao...");
		}
	}
}
