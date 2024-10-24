import java.util.Scanner;

public class davidcambra4 {
    public static double calculaPorcentaje(double antes, double despues) {
        double aux = antes - despues;
        double coci = aux / antes;
        return coci * 100;
    }

    public static double dimePrecioFinal(double antes, double porcentaje) {

        double aux = 0;

        aux = 1 - (porcentaje / 100);
        return antes * aux;

    }

    public static double dimePrecioOriginal(double despues, double porcentaje) {
        double aux = 0;
        aux = 1 - (porcentaje / 100);
        return despues * aux;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        boolean sigue = true;

        do {
            System.out.println("pulsa 1 para obtener porcentaje descuento");
            System.out.println("pulsa 2 para obtener precio final");
            System.out.println("pulsa 3 para obtener precio original");
            opc = sc.nextInt();

            switch (opc) {
                case 1: {

                    double uno, dos;
                    System.out.println("precio original: ");
                    uno = sc.nextDouble();
                    System.out.println("precio final: ");
                    dos = sc.nextDouble();
                    System.out.println("el porcentaje de descuento es: " + calculaPorcentaje(uno, dos));
                    break;
                }
                case 2: { // sale final
                    double ori, por;
                    System.out.println("dame final: ");
                    ori = sc.nextDouble();
                    System.out.println("dame porcentaje: ");
                    por = sc.nextDouble();
                    System.out.println("precio original es: " + dimePrecioFinal(ori, por));
                    break;
                }
                case 3: { // sale original
                    double fin, por;
                    System.out.println("dame final: ");
                    fin = sc.nextDouble();
                    System.out.println("dame porcentaje: ");
                    por = sc.nextDouble();
                    System.out.println("precio original es: " + dimePrecioOriginal(fin, por));
                    break;
                }
                default: {
                    System.out.println("OPCION NO VALIDA");
                }
            } // fin switch

            System.out.println("otro calculito?? (s/n): ");
            char res = sc.next().charAt(0);
            if (res == 'n')
                sigue = false;

        } while (sigue);

        sc.close();
    }
}