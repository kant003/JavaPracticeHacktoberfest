import java.util.Scanner;

public class victorpicallo3 {
        
        public static Scanner sc;
        
        public static int dimeClientes(double p, double c) {
            int num=0;
            //Calculos
            while((p>=1) && (c>=0.5)) {
                num+=3;
                p-=1;
                c-=0.5;
            }
            return num;
        }
        
        
        public static void main(String[] args) {
            
            sc= new Scanner (System.in);
            System.out.println("Cuantos kg patatas hay: ");
            double p=sc.nextDouble();
            System.out.println("Cuantos kg chochos hay: ");
            double c=sc.nextDouble();
            
            System.out.println("Podemos dar de comer a: " + dimeClientes(p, c));
            
        }
}
