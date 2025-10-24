package DavidCambra;
import java.text.DecimalFormat;
import java.util.Scanner;

public class davidcambra6 {

    private static final double PSI_TO_BAR = 0.0689475729;
    private static final double BAR_TO_PSI = 1 / PSI_TO_BAR;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("=================================");
        System.out.println("   CONVERSOR DE PRESIÓN");
        System.out.println("=================================");
        System.out.println("1) Convertir de PSI a BAR");
        System.out.println("2) Convertir de BAR a PSI");
        System.out.print("Elige una opción (1 o 2): ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1 -> {
                System.out.print("Introduce el valor en PSI: ");
                double psi = sc.nextDouble();
                double bar = psi * PSI_TO_BAR;
                System.out.println(df.format(psi) + " psi = " + df.format(bar) + " bar");
            }
            case 2 -> {
                System.out.print("Introduce el valor en BAR: ");
                double bar = sc.nextDouble();
                double psi = bar * BAR_TO_PSI;
                System.out.println(df.format(bar) + " bar = " + df.format(psi) + " psi");
            }
            default -> System.out.println("Opción no válida. Intentalo de nuevo.");
        }

        sc.close();
    }
}