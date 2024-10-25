import java.util.Scanner;

public class ejercicioCondicionales {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String n, e, m;
        System.out.println("Tienes tarjeta de oro: ");
        n = sc.nextLine();
        System.out.println("Tienes tarjeta club: ");
        e = sc.nextLine();
        System.out.println("Eres modalidad joven: ");
        m = sc.nextLine();

        if (n == "si") {
            if (m == "si") {
                System.out.println("Tienes un 20% de descuento");
            } else {
                if (m == "no") {
                    System.out.println("Tienes un 15% de descuento");
                }
            }

        } else {
            if (e == "si" && m == "si") {
                System.out.println("Tienes un 10% de descuento");

            } else {
                if (e == "si" && m == "no") {
                    System.out.println("Tienes un 5% de descuento");
                }
            }
        }
    }

}