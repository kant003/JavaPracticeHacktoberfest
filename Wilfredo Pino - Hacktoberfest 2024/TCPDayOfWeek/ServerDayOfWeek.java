	package TCPDayOfWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

public class ServerDayOfWeek {
	
	public static void main (String[] arg) throws IOException {
	int numeroPuerto = 6000;// Puerto
	ServerSocket servidor = new ServerSocket (numeroPuerto) ;
	String cad="";

	System.out.println ("Buen dia, esperando conexión ... ");
	Socket clienteConectado = servidor.accept () ;
	System.out.println (" **alerta** Cliente conectado ... ") ;

	
	// CREO FLUJO DE SALIDA AL CLIENTE
	PrintWriter fsalida = new PrintWriter(clienteConectado.getOutputStream () , true) ;
	
	
	// CREO FLUJO DE ENTRADA DEL CLIENTE
	BufferedReader fentrada = new BufferedReader
	(new InputStreamReader (clienteConectado.getInputStream()));

	while ((cad=fentrada.readLine() ) != null && !cad.equalsIgnoreCase("salir")) {//recibo cad del cliente
	
	
	System. out.println ("Recibiendo: " + cad);
	
	   // Compruebo si la cadena es un palíndromo y envío la respuesta al cliente
    String resultado = procesarFecha(cad);
    fsalida.println(resultado); // Envía el resultado de la comprobación al cliente
}
	// CERRAR STREAMS Y SOCKETS
	System.out.println ("El cliente cerro la conexión ... ") ;
	System.out.println ("Cerrando conexión ... ") ;
	fentrada. close () ;
	fsalida.close ();
	clienteConectado.close () ;
	servidor.close () ;
	System.out.println ("*HASTA LUEGO*") ;
	}
	
	
	
	

	// Método que procesa la fecha recibida y devuelve el día de la semana
    public static String procesarFecha(String fechaRecibida) {
        //try {
            
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            
            LocalDate fecha = LocalDate.parse(fechaRecibida, formato);

            // Obtener el día de la semana en español
            String diaSemana = fecha.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES"));

            return "El día de la semana para la fecha " + fechaRecibida + " es: " + diaSemana;
       // } catch (Exception e) {
            //return "Formato de fecha inválido. Por favor use el formato dd/MM/yyyy.";
        //}
    }

}