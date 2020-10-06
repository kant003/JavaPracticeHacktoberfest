import java.util.Scanner;

public class sumamaria {

	// variable miembro de la clase
	static int n1 = 50;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// variables locales
		int n2 = 30, suma = 0, n3;
		suma = n1 + n2;
		
		System.out.println("LA SUMA ES: "+suma);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el valor de n3: ");
		
		n3 = sc.nextInt();
		
		suma = suma + n3;
		
		System.out.println("EL RESULTADO ES: "+suma);
		
	}

}
