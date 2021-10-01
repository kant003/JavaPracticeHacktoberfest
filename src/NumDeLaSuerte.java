import java.util.Scanner;

// This program calculates your lucky number 
// based on your birth date

public class NumDeLaSuerte{
	public static int nDigitos(int n) {
		int digitos = 0, n2 = n;
		while (n2 != 0) {
			n2 /= 10;
			++digitos;
		}
		return digitos;
	}

	public static int desc(int n, int digitos) {
		int n2 = 0;
		for (int i = 0; i < digitos; i++) {
			n2 += Integer.parseInt(Integer.toString(n).substring(i, i + 1));
		}
		return n2;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca su día de nacimiento: ");
		int d = sc.nextInt();
		System.out.println("Introduzca su mes de nacimiento: ");
		int m = sc.nextInt();
		System.out.println("Introduzca su año de nacimiento: ");
		int y = sc.nextInt();
		int n = d + m + y;
		System.out.println("Su número de la suerte es: " + desc(n, nDigitos(n)));
		sc.close();
	}
}
