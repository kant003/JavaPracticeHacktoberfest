import java.util.Scanner;

public class hacktool {

    public static void main(String[] args) {

        int m, n;

        Scanner sc = new Scanner(System.in);
        System.out.println("Dame un entero m: ");
        m = sc.nextInt();

        System.out.println("Dame un entero n: ");
        n = sc.nextInt();

        boolean res;
        System.out.println("m es: " + m + " y n es: " + n);
        System.out.println("-------------------------");

        res = ((m > n) && (m >= n));// res=false
        System.out.println(res);
        res = !((m < n) || (m != n));// res=false
        System.out.println(res);

        sc.close();
    }

}
