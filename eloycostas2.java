import java.util.Scanner;

public class eloycostas2 {
    public static void main(String[] args) {
	
        int edad,nivel,ingresos;
        Scanner sc = new Scanner(System.in);
        boolean jasp;
        
        
        System.out.println("dime edad: ");
        edad=sc.nextInt();
        System.out.println("dime  nivel: ");
        nivel=sc.nextInt();
        System.out.println("dime ingresos: ");
        ingresos=sc.nextInt();
        
        
         if ( (edad<=28)&&(nivel>3)&& (ingresos>28000) )  {
               jasp=true;
               }	
        
         else {
              jasp=false;
         }
    
         
         System.out.println("eres un jasp??"+jasp);
    
    }
}
