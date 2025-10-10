package miprimerproyecto;

import java.util.Scanner;

public class rectángulos {
  // se dan dos lados para calcular el perímetro del rectángulo
	public static void main(String[] args) {
		
	    double lado1,lado2,perimetro,area;
		Scanner keyboard = new Scanner (System.in);
		
		System.out.println("inserte un lado del rectángulo :");
		lado1 = keyboard.nextDouble();
		
		System.out.println("Inserte otro lado del rectángulo: ");
        lado2 = keyboard.nextDouble();
        
        //Perímetro
        perimetro = lado1*2+lado2*2;
        System.out.println("El perímetro del rectángulo es: "+perimetro);
        
        //Área
        area = lado1*lado2;
        System.out.println("El área del rectángulo es: "+area);
        
		
	}
	
}
