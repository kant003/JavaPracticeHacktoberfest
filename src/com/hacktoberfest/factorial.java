import java.util.Scanner;

public class factorial {
	public static double factoria(int n) {
		if (n == 1) {
			return n;
		} else {
			return n * factoria(n - 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Calcular factorial");
		int N = sc.nextInt();
		System.out.println(factoria(N));
		sc.close();
	}

}
