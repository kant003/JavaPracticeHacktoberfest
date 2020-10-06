
import java.util.Scanner;

public class ej10 {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el número de casas");
        System.out.println(calculo(sc.nextInt()));
        sc.close();
    }

    public static int ladoizquierdo(int n) {
        n--;
        int ladoizquierdo = 0;
        for (; n > 0; n--) {
            ladoizquierdo = ladoizquierdo + n;
        }
        return ladoizquierdo;
    }

    public static int ladoderecho(int n, int casastotales) {
        n++;
        int ladoderecho = 0;
        for (; n <= casastotales; n++) {
           ladoderecho = ladoderecho + n;
        }
        return ladoderecho;
    }

    public static int calculo(int casastotales) {


        for (int i = 0; i <= casastotales; i++) {
            if (ladoizquierdo(i) == ladoderecho(i, casastotales)) {

                return i;

            } else {

            }
        }
        return -1;

    }

}