package DavidCambra;
import java.util.Scanner;

public class davidcambra13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Escribe algo: ");
        String texto = sc.nextLine();

        String invertido = new StringBuilder(texto).reverse().toString();
        System.out.println("Texto invertido: " + invertido);

        sc.close();
    }
}
