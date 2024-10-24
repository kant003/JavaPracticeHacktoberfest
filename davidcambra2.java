import java.util.Scanner;

public class davidcambra2 {
    
    public static void main(String[] args) {
        
        double base,altura,area,perimetro;
        Scanner sc = new Scanner (System.in);

        System.out.println("introduce base: ");
            base = sc.nextDouble();

        System.out.println("introduce altura: ");
            altura = sc.nextDouble();
        
        //calcular perimetro
        perimetro = 2*base+2*altura;

        //calcular area
        area = base*altura;

        System.out.println("la area es: "+area);
        System.out.println("el perimetro es: "+perimetro);

        sc.close();
    }
        
}