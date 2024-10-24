package miprimerproyecto;

import java.util.Scanner;

public class potencias {

   public static void main(String[] args ) {
	  
	   //variables
       int base,exponente,potencia;
       Scanner sc = new Scanner (System.in);
    		  
       //pedir y almacenar la base
       System.out.println("dame una base: ");
       base=                    sc.nextInt() ;
	   
	   //pedir almacenar el exponente
       System.out.println("dame el exponente: ");
       exponente=                    sc.nextInt() ;
	   
       //algoritmo de potencia
       potencia =  (int) Math.pow(base, exponente);
       
       //salida del resultado
       System.out.println("la potencia de "+base+" elevado a "+exponente+" es: "+potencia);
       
       
       
   }
	
}
