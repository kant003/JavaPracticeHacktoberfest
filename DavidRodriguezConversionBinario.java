import java.util.Scanner;

public class DavidRodriguezConversionBinario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Qué conversión quieres realizar?");
        System.out.println("1. Binario a Decimal");
        System.out.println("2. Decimal a Binario");
        System.out.print("Elije una opción (1 o 2): ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Ingresa un número binario: ");
                String binario = scanner.next();
                try {
                    int decimal = Integer.parseInt(binario, 2);
                    System.out.println("El número decimal es: " + decimal);
                } catch (NumberFormatException e) { git init
                    System.out.println("El número ingresado no es un binario válido.");
                }
                break;
            case 2:
                System.out.print("Ingresa un número decimal: ");
                int decimal = scanner.nextInt();
                String binarioResultante = Integer.toBinaryString(decimal);
                System.out.println("El número binario es: " + binarioResultante);
                break;
            default:
                System.out.println("Error");
        }

        scanner.close();
    }
}
