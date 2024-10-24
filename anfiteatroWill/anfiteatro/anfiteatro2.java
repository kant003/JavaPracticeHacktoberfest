package anfiteatro;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import logica.Cliente;
import logica.ticket;

public class anfiteatro2 {

	public static void main(String[] args) {
		
		List<ticket> listaTickets =new ArrayList<>();
		
		ticket ticket1 =new ticket(12, 12, 3, 1500, new Date(), new Date());
		ticket ticket2 =new ticket(13, 12, 4, 1500,  new Date(),  new Date());
		
		
		ticket ticket3= new ticket ();
		ticket3.setNumero(20);
		ticket3.setFila(5);
		ticket3.setColumna(1);
		ticket3.setPrecio(3000);
		ticket3.setFechaCompra( new Date());
		ticket3.setFechaValidez( new Date());
		
		listaTickets.add(ticket1);
		listaTickets.add(ticket2);
		listaTickets.add(ticket3);
	
		
		//suma de precios
		double suma=0;
		for( ticket tick:listaTickets) {
			suma += suma+tick.getPrecio();
			//
		}
		System.out.println("La suma es de " + suma);
		
		Scanner teclado = new Scanner (System.in);
		
		System.out.println("Ingrese la fila de la que desea ver tickets");
		int fila= teclado.nextInt();
		
		boolean bandera = false;
	
		
		for( ticket tick:listaTickets) {
			if(tick.getFila()== fila ) {
				System.out.println(tick.toString());
				bandera =true;
			}
		}
		if (!bandera) {
			System.out.println("No se encontraron datos de la fila en cuestion");
		}
		
		//prueba cliente
		Cliente cli =new Cliente();
		cli.setId(1);
		cli.setNombre("Wilfredo");
		cli.setApellido("Pino");
		cli.setDni("100903124");
	cli.getListaTickets().add(ticket1);
	
	
	 // Usar fechas válidas
    Calendar calendar = Calendar.getInstance();
    calendar.set(2023, Calendar.OCTOBER, 12);
    Date fecha = calendar.getTime();
    
    ticket ticket4 = new ticket(12, 4, 6, 2000, fecha, new Date());
    cli.getListaTickets().add(ticket4);
	
	}
	
}
