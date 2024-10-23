	package TCPPalindromo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerPalindromo {
	
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
    String resultado = comprobacionpalindromo(cad);
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
	
	
	

public static String comprobacionpalindromo(String cad) {
	String  sale = null;
	System.out.println("recibido: " + cad);
	if(isPalindromo(cad))
		sale= " la cadena es PALINDROMO";
	else
		sale = "la cadena no es palindromo";
		return sale;
}
	
	private static boolean isPalindromo(String cad) {
	
		String test = cad.replace(" ", "");
		String test2 = new StringBuilder(test).reverse().toString(); // StringBuilder es un constructor de cadenas
         if (test.equalsIgnoreCase(test2))
		
		return true;
         else
        	 return false;
		
}}