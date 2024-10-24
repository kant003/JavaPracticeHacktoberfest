package estacionamiento;

import java.util.Scanner;

public class Principal {
public static void main(String[] args) {
	

	String patente= "";
	int tipoServicio, cantHoras,cont1=0,cont2=0,cont3=0;
	double total,totalDia=0;
	Scanner teclado = new Scanner (System.in);

while( !patente.equalsIgnoreCase("fin"))  {
	System.out.println("Ingresa la patente del vehiculo(PARA FINALIZAR INGRESE 'FIN'");
	patente=teclado.nextLine();
	
	if(!patente.equalsIgnoreCase("fin")) {
	System.out.println("Ingrese el tipo de servicio");
	System.out.println("1- Por hora");
	System.out.println("2- Media jornada (5 horas)");
	System.out.println("3 - Jornada completa (10 horas)");

	teclado =new Scanner (System.in);
	tipoServicio=teclado.nextInt();
	if (tipoServicio <1 || tipoServicio>3) {
		System.out.println("Ingrese un tipo de servicio correcto");
		
	}else {
		
		if (tipoServicio ==1) {
			
			System.out.println("Ingrese la cantidad de horas que desea estacionar");
	cantHoras=teclado.nextInt();
	total= cantHoras*3;
	System.out.println("El total de su estacionamiento es de : "+ total);
		cont1++;
		totalDia+=total;
		}
		else if (tipoServicio ==2) {
			System.out.println("El servicio de media jornada corresponde a 5 horas y posee un descuento del 5%");
		total = 15 * 0.95;
		cont2++;
		System.out.println("El total de su estacionamiento es de:" +total);
		totalDia+=total;
		
		} else {
			System.out.println("El servicio de jornada completa corresponde a 10 horas y posee un descuento del 10%");
		total = 30*0.90;
		System.out.println("El total de su estacionamiento es de:" +total);
		cont3++;
		totalDia+=total;
		}
	}}
	System.out.println("");
	System.out.println("********** ¡MUCHAS GRACIAS POR SU COMPRA!**********");
	System.out.println("---------------------------------------------------");
	teclado=new Scanner (System.in);
}
System.out.println("====================================");
System.out.println("Totales monetarios del dia");
System.out.println("Cantidad de servicios por hora = " + cont1);
System.out.println("Cantidad de servicios por media jornada = "+ cont2);
System.out.println("Cantidad de servicios por jornada completa = "+cont3);
System.out.println("El monto totral recaudado del dia es de € = "+ totalDia+ " EUROS");
}}
