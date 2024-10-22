import java.util.Scanner;

public class JimmyCalderon3 {
    public static double millasAMetros(double millas) {
        double aux;
        aux = (millas * 1852) / 1;
        return aux;
    }

    public static double millasAKilometros(double millas) {
        double aux;
        aux = millasAMetros(millas);
        return aux / 1000;
    }
public static void main(String[] args) {
    
Scanner sc=new Scanner(System.in);
System.out.println("Por favor dame numero de millas: ");
double mil=sc.nextDouble();
System.out.println("Pasado a metros es: "+millasAMetros(mil));
System.out.println("Pasado a Kilometros es: "+millasAKilometros(mil));
}
}// fin class
