package dos;
	import java.util.Random;
	import java.util.Scanner;

	public class generadordecontras {

	    // Conjunto de caracteres posibles en la contraseña
	    private static final String LETRAS_MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    private static final String LETRAS_MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
	    private static final String NUMEROS = "0123456789";
	    private static final String SIMBOLOS = "!@#$%^&*()-_=+[]{};:,.<>?";

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("=== Generador de contraseñas ===");
	        System.out.print("Ingresa la longitud deseada de la contraseña: ");
	        int longitud = scanner.nextInt();

	        System.out.print("Incluir mayúsculas? (s/n): ");
	        boolean usarMayusculas = scanner.next().equalsIgnoreCase("s");

	        System.out.print("Incluir minúsculas? (s/n): ");
	        boolean usarMinusculas = scanner.next().equalsIgnoreCase("s");

	        System.out.print("Incluir números? (s/n): ");
	        boolean usarNumeros = scanner.next().equalsIgnoreCase("s");

	        System.out.print("Incluir símbolos? (s/n): ");
	        boolean usarSimbolos = scanner.next().equalsIgnoreCase("s");

	        String password = generarPassword(longitud, usarMayusculas, usarMinusculas, usarNumeros, usarSimbolos);
	        System.out.println("Contraseña generada: " + password);

	        scanner.close();
	    }

	    private static String generarPassword(int longitud, boolean mayusculas, boolean minusculas, boolean numeros, boolean simbolos) {
	        StringBuilder caracteres = new StringBuilder();

	        if (mayusculas) caracteres.append(LETRAS_MAYUSCULAS);
	        if (minusculas) caracteres.append(LETRAS_MINUSCULAS);
	        if (numeros) caracteres.append(NUMEROS);
	        if (simbolos) caracteres.append(SIMBOLOS);

	        if (caracteres.length() == 0) {
	            return "Error: Debes seleccionar al menos un tipo de carácter.";
	        }

	        Random random = new Random();
	        StringBuilder password = new StringBuilder();

	        for (int i = 0; i < longitud; i++) {
	            int indice = random.nextInt(caracteres.length());
	            password.append(caracteres.charAt(indice));
	        }

	        return password.toString();
	    }
	}


