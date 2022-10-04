public class JorgeGarcia {
    
    public static int getNumber() {
		return (int) (Math.random() * 99);
	}

	public static void main(String[] args) {
		
		int contador = 0;
		int numero;
		
		for (int i = 0 ; i < 40 ; i++) {
			numero = getNumber();
			System.out.println("Generado: " + numero);
			if (numero % 2 == 0) {
				contador++;
				System.out.println("Es par");
			}
		}
		System.out.println("Pares: " + contador);
	}
	
}
