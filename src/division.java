import java.util.Scanner;
public class division{

public static void main(String[] args) {
    int dividendo;
	    int divisor;
	    int cociente;
	    int resto; 
	    System.out.println("Dime el dividendo: ");
	    Scanner esc=new Scanner (System.in);
	    dividendo=esc.nextInt();
	    System.out.println("Dime el divisor: ");
	    Scanner esc1=new Scanner (System.in);
	    divisor=esc1.nextInt();
	    cociente=dividendo/divisor;
	    resto=dividendo%divisor;
	    System.out.println("El cociente es: "+cociente);
	    System.out.println("El resto es: "+resto);


}

}