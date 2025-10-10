package miprimerproyecto;

import java.util.Scanner;

public class potenciaconmetodo {

	
	       public static int potencia(int base, int exponente) {
	          //algoritmo de potenciacion
	           int auxiliar; 
               auxiliar =  (int) Math.pow(base, exponente);
               return auxiliar; 
	       }
	
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
		   
	       //FALTA UN POCO DE CODIGO
	       potencia= potencia(base, exponente); 
	       
	       //salida del resultado
	       System.out.println("la potencia de "+base+" elevado a "+exponente+" es: "+potencia);
	       
	       
	       
	   }
		
	}	
	

	
	

