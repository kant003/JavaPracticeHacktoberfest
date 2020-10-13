import java.util.Scanner;

public class Raposo { 
	    
	    public static void main(String[] args) {
	        int numero;
	        char ascii;
	        Scanner scan=new Scanner (System.in);
	        System.out.println("introduce un numero: ");
	        numero=scan.nextInt();
	        ascii=(char) numero;
	        System.out.println("El numero "+numero+" es "+ascii);
	    }
	        
	    


}