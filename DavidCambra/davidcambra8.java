package DavidCambra;
import java.util.Random;
import java.util.Scanner;

public class davidcambra8 {
    public static void main(String[] args) {
        Random random = new Random();
        int numeroSecreto = random.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        int intento;
        System.out.println("Adivina el numero entre 1 y 100:");

        int contador = 0;
        do {
            intento = sc.nextInt();
            if (intento < numeroSecreto)
                System.out.println("Te has quedado corto...");
            else if (intento > numeroSecreto)
                System.out.println("Te has pasado!!");
            contador++;
        } while (intento != numeroSecreto);

        System.out.println("Acertaste! El numero secreto era: " + numeroSecreto);
        System.out.println("Lo has acertado en " + contador + " intentos.");
        sc.close();
    }
}
