import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir número al usuario
        System.out.print("Introduce un número entero: ");
        int n = sc.nextInt();

        // Inicializamos el resultado
        long factorial = 1;

        // Algoritmo iterativo para calcular el factorial
        for (int i = 1; i <= n; i++) {
            factorial *= i;  // factorial = factorial * i
        }

        // Mostramos el resultado
        System.out.println("El factorial de " + n + " es: " + factorial);

        sc.close();
    }
}
