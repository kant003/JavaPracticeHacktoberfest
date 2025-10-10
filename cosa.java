import java.util.Scanner;

public class cosa {
    // constante
    final static double PI = 3.141592;

    public static void main(String[] args) {

        double radio, longitud, area;
        Scanner sc = new Scanner(System.in);

        System.out.println("introduce radio: ");
        radio = sc.nextDouble();

        // longitud circunferencia
        longitud = 2 * PI * radio;

        // area circulo
        area = PI * radio * radio;

        System.out.println("La longitud de la circunferencia: " + longitud);
        System.out.println("El area del circulo es: " + area);

    }

}
