import java.util.Scanner;

public class llamar_pablo_reboredo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cómo te llamas? ");
        String nombre = scanner.nextLine();

        System.out.println("¡Hola, " + nombre + "!");
        
        scanner.close();
    }
}