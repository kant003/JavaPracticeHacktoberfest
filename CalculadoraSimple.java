package dos;
	import java.util.Scanner;

	public class CalculadoraSimple {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        double num1, num2, resultado = 0;
	        char operador;

	        System.out.println("=== Calculadora Simple ===");
	        System.out.print("Introduce el primer número: ");
	        num1 = scanner.nextDouble();

	        System.out.print("Introduce el operador (+, -, *, /): ");
	        operador = scanner.next().charAt(0);

	        System.out.print("Introduce el segundo número: ");
	        num2 = scanner.nextDouble();

	        switch (operador) {
	            case '+':
	                resultado = num1 + num2;
	                break;
	            case '-':
	                resultado = num1 - num2;
	                break;
	            case '*':
	                resultado = num1 * num2;
	                break;
	            case '/':
	                if (num2 != 0) {
	                    resultado = num1 / num2;
	                } else {
	                    System.out.println("Error: No se puede dividir entre cero.");
	                    scanner.close();
	                    return;
	                }
	                break;
	            default:
	                System.out.println("Operador no válido.");
	                scanner.close();
	                return;
	        }

	        System.out.println("Resultado: " + resultado);
	        scanner.close();
	    }
	}

