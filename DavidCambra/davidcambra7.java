package DavidCambra;
import java.util.Scanner;

public class davidcambra7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el primer número: ");
        double a = sc.nextDouble();

        System.out.print("Introduce el segundo número: ");
        double b = sc.nextDouble();

        System.out.print("Elige una operacion (+, -, *, /): ");
        char operador = sc.next().charAt(0);

        double res = switch (operador) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> (b != 0) ? a / b : Double.NaN;
            default -> Double.NaN;
        };

        if (Double.isNaN(res))
            System.out.println("Operación invalida");
        else
            System.out.println("Resultado: " + res);

        sc.close();
    }
}
