package uno;

import java.util.Scanner;

import uno.automovil.color;
import uno.automovil.tipoAutomovil;
import uno.automovil.tipoCombustible;

public class testautomovil {
	
	public static void main(String[] args) {
		
		automovil c1 = new automovil("Audi", 2006, 50, tipoCombustible.DIESEL, tipoAutomovil.FAMILIAR, 5, 5, 180, color.BLANCO, 0 );
		System.out.println(c1.toString());
		c1.acelera(20);
		System.out.println(c1.toString());
		c1.acelera(200);
		System.out.println(c1.toString());
		c1.frena(50);
		System.out.println(c1.toString());
		c1.frena(500);
		System.out.println(c1.toString());
		c1.setVelocidadact(80);
		System.out.println(c1.toString());
		System.out.println("--------------------------------------------------------------------");
		Scanner sc = new Scanner(System.in);
		System.out.println("dime la distancia: ");
		double dis = sc.nextDouble();
		System.out.println("a este ritmo tardaras " + c1.tiempoLlegada(dis) + " horas");
		
	}
	
	

}
