package dos;
	import java.util.Scanner;
	import java.util.Random;

	public class Dado {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();

	        // Pedir al usuario que elija un número del 1 al 6
	        System.out.print("Elige un número del 1 al 6: ");
	        int numeroUsuario = scanner.nextInt();

	        // Validar que el número esté en el rango
	        if (numeroUsuario < 1 || numeroUsuario > 6) {
	            System.out.println("Número inválido. Debe ser entre 1 y 6.");
	            return;
	        }

	        // Simular la tirada del dado
	        int dado = random.nextInt(6) + 1; // genera un número entre 1 y 6
	        System.out.println("El dado ha salido: " + dado);

	        // Comprobar si acertó
	        if (numeroUsuario == dado) {
	            System.out.println("¡Felicidades! Has acertado.");
	        } else {
	            System.out.println("Lo siento, no acertaste. Intenta de nuevo.");
	        }

	        scanner.close();
	    }
	}

