import java.util.Scanner;

public class davidcambra {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double r;
        double area, volumen;

        System.out.println("dame radio: ");
        r = sc.nextDouble();

        area = 4 * Math.PI * Math.pow(r, 2);
        volumen = 4 / 3 * Math.PI * Math.pow(r, 3);

        System.out.println("area es: " + area);
        System.out.println("volumen es: " + volumen);

        sc.close();
    }
}