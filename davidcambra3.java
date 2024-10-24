import java.util.Scanner;
import java.util.Random;

public class davidcambra3 {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        // Generacion del numero aleatorio
        int numeroAleatorio = random.nextInt(100) + 1;
        int intento;
        int intentos = 0;

        System.out.println("Bienvenido al juego de adivinanzas!");
        System.out.println("Eres capaz de adivinar el numero que estoy pensando? Venga, te dejo intentarlo!");


        do {
            System.out.print("Introduce tu numero: ");
            intento = sc.nextInt();
            intentos++;

            // Pista del numero
            if (intento > numeroAleatorio) {
                System.out.println("El numero es menor que " + intento + ". Intenta de nuevo.");
            } else if (intento < numeroAleatorio) {
                System.out.println("El numero es mayor que " + intento + ". Intenta de nuevo.");
            } else {
                System.out.println("¡Felicidades! Adivinaste el número en " + intentos + " intentos.");
                System.out.println("Intentalo de nuevo y consigue acertarlo en el menor numero de intentos posibles!");
            }

        } while (intento != numeroAleatorio); // Bucle hasta adivinar el numero

        sc.close();
    }
}
