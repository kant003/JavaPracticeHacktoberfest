package miprimerproyecto;

import java.util.Scanner; 

public class RESTA {
	
   public static void main(String[] args ) {

	   int num1,num2,resta; 
	   Scanner sc = new Scanner(System.in); 
	   
	   //pedir primer numero
	   System.out.println("primer restando: ");
	   //guardar
	   num1=sc.nextInt();
	   //perdir segundo numero
	   System.out.println("segundo restando: ");
	   
	   //guardar
	   num2=sc.nextInt();
	   
	   //algoritmo de la resta
	   resta=            num1-num2;
	   
	   //mostrar la salida
	   System.out.println("la resta da: "+resta);
	   
   
   }
   

}
