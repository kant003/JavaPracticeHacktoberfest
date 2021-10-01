public class seviene {

	public static void main (String[] args) {
		
		pico("Pepe", 1000);
		int que = pico("Pepe",30);
		System.out.println(que);
		pico(80);
	}
	
	public static int pico (String nombre, int hola) {
		
		System.out.println("El jugador: " + nombre + " consiguio " + hola + " puntos.");
		return hola*1000;
		
	}
	
	public static int pico (int hola) {
		
		System.out.println("El jugador anonimo consiguio: " + hola + " puntos.");
		return hola*1000;
		
	}
	
}