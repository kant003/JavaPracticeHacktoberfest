
public class HolaMundo {

	public static void main(String[] args) {
		
		System.out.println("Hola Mundo");
		/* lo único que hace este programa es mostrar
		la cadena “Hola Mundo” por pantalla*/
		
		HolaMundo Manolito = new HolaMundo ();
		/*A partir de la clase HolaMundo, creamos Manolito, que sería un new objeto de HolaMundo*/
		
		System.out.println(Manolito.toString());
		
		/* Manolito al ser ejecutado como string, muestra por pantalla la ubicación en la memoria del pc,
		 * en codigo hexadecimal, del objeto manolito.
		 */
		
	}

}
