import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir palabra al usuario
        System.out.print("Introduce una palabra: ");
        String palabra = sc.nextLine();

        // Convertimos a minúsculas y quitamos espacios
        palabra = palabra.toLowerCase().replace(" ", "");

        // Invertimos la palabra
        String invertida = new StringBuilder(palabra).reverse().toString();

        // Comparamos
        if (palabra.equals(invertida)) {
            System.out.println("La palabra ES un palíndromo");
        } else {
            System.out.println("La palabra NO es un palíndromo");
        }

        sc.close();
    }
}
