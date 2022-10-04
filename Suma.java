import java.util.Scanner;

public class Suma {
	
	
	public static void main(String [] args){
		
		Scanner sc=new Scanner(System.in);

		int n1, n2, suma = 0; 
		System.out.println("Dime número entero: ");
		n1=sc.nextInt();
		System.out.println("Dime otro número entero: ");
		n2=sc.nextInt();
		
		suma= n1 + n2;
		
		System.out.println("LA SUMA ES: "+ suma);
		 sc.close();
	}
	
}