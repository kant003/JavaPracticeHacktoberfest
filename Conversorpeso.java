package dos;
import java.util.Scanner;

public class Conversorpeso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double valor, resultado;
        String unidadOrigen, unidadDestino;

        System.out.println("=== Conversor de Unidades de Peso ===");
        System.out.println("Unidades disponibles: kg, g, lb, oz");
        System.out.print("Ingresa el valor a convertir: ");
        valor = scanner.nextDouble();

        System.out.print("Ingresa la unidad de origen (kg/g/lb/oz): ");
        unidadOrigen = scanner.next().toLowerCase();

        System.out.print("Ingresa la unidad de destino (kg/g/lb/oz): ");
        unidadDestino = scanner.next().toLowerCase();

        resultado = convertirPeso(valor, unidadOrigen, unidadDestino);

        if (resultado != -1) {
            System.out.printf("%.4f %s = %.4f %s%n", valor, unidadOrigen, resultado, unidadDestino);
        } else {
            System.out.println("Error: Unidad no reconocida.");
        }

        scanner.close();
    }

    public static double convertirPeso(double valor, String origen, String destino) {
        // Convertimos todo primero a kilogramos
        double enKg;

        switch (origen) {
            case "kg":
                enKg = valor;
                break;
            case "g":
                enKg = valor / 1000.0;
                break;
            case "lb":
                enKg = valor * 0.453592;
                break;
            case "oz":
                enKg = valor * 0.0283495;
                break;
            default:
                return -1;
        }

        // Luego, de kilogramos a la unidad destino
        switch (destino) {
            case "kg":
                return enKg;
            case "g":
                return enKg * 1000.0;
            case "lb":
                return enKg / 0.453592;
            case "oz":
                return enKg / 0.0283495;
            default:
                return -1;
        }
    }
}

