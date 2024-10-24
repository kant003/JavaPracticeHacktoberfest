package anfiteatro;

import java.util.Scanner;

public class anfiteatro {

	public static void main(String[] args) {
		//declaracion de variables
		
		Scanner teclado2 =new Scanner (System.in);
		Scanner teclado = new Scanner(System.in);
		boolean bandera = false;
		int fila = 0;
		int columna=0;
		String closed;
		String verMapa;
		

		// creamos la matriz

		char asientos[][] = new char[10][10];

		// cargamos la matriz de asientos

		for (int f = 0; f <= 9; f++) {
			
			for (int c = 0; c <= 9; c++) {

				asientos[f][c] = 'L';

			}
		}
		
		
// bienvenida al sistema
		System.out.println("****BIENVENIDOS AL SISTEMA DE RESERVAS****");

		//reserva de asientos
		while ((bandera != true)){
			
		//visualizacion del mapa
			System.out.println("Desea ver los asientos diponibles? S: si, cualquier cotra letra no" );
			verMapa=teclado.next();

			if(verMapa.equalsIgnoreCase("s")) {
			dibujarMapa(asientos);
			}
			
			//reserva
			boolean estaOk=false;
			while(estaOk!=true) {
				
			System.out.println("\n INGRESE LA FILA y ASIENTO A RESERVAR : ");
			System.out.println("Fila (debe ser entre 0 y 9): ");
			fila = teclado.nextInt();
			
			System.out.println("Asiento (debe ser entre 0 y 9); ");
			columna = teclado.nextInt();
			
			if(fila>=0 && fila <=9 ) {
			 if (columna >=0 && columna <=9) {
					estaOk=true;
					
					}else {
				System.out.println("el numero de columna no es valido");
			}
			}
			else{
				System.out.println("El numero de filas no es valido");
			}
			}
			if (asientos [fila][columna]=='L') {
				asientos [fila][columna] = 'X';
				
				System.out.println("El asiento fue reservado correctamente");
			}
							
				else {
						System.out.println("El asiento ya esta ocupado puedes reservar alguno de estos: " );
					
				}	
				System.out.println("¿desea continuar reservando ? S: si. cualquier otra letra no");
				closed = teclado2.next();

				if (!closed.equalsIgnoreCase("s")) {
					bandera =true;
					System.out.println("fin");
				
				}
		}
		
		}	
			
	
	static void dibujarMapa(char asientos[][] ) {

		for (int f = 0; f <= 9; f++) {
			System.out.print(f + " ");
			for (int c = 0; c <= 9; c++) {
				

				System.out.print("["+ asientos [f][c]+"]");

			}
	
			System.out.println("");
}}}
	

