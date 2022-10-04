import java.util.Scanner;

public class andreschaves {

    public static void main(String[] args) {

        Scanner damecamiseta = new Scanner(System.in);
        int cuantas = 0;

        System.out.println("¿Cuántas camisetas de github quieres? ");

        cuantas = damecamiseta.nextInt();

        if (cuantas <= 1) {
            System.out.println("Toma " + cuantas + " camiseta, champion.");

        } else {
            System.out.println("Toma " + cuantas + " camisetas, champion.");
        }

    }

}