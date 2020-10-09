package propuestos;

import java.util.Scanner;

public class tresb {
	
	public static int CalcularCuadrado(int num) {
		
		int cuad= num * num;
		
		return cuad;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numero;
		Scanner pillame=new Scanner(System.in);
		System.out.println("intro numero: ");
		numero=pillame.nextInt();
		
		System.out.println("EL CUADRADO DE "+numero+" ES: "+CalcularCuadrado(numero));
		pillame.close();
	}

}