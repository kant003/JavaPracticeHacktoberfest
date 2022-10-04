import java.util.Scanner;

public class JorgeAlleres {
    public static double EurADol(double eur) {
        double mon = 0;
        mon = eur*0.96;
        return mon;
    }

    public static double DolAEur(double dol) {
        double mon = 0;
        mon = dol*1.05;
        return mon;
    }
    
    public static void main(String[] args) {

        double aux1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca Euros: ");
        aux1 = sc.nextDouble();
        System.out.println("En Dolares son: " + EurADol(aux1));

        System.out.println("Introduzca Dolares:");
        aux1 = sc.nextDouble();
        System.out.println("En Euros son: " + DolAEur(aux1));

            sc.close();
        
    }
}