import java.util.Random;

public class Delegado {

    private static final String[] SUJETOS = {
        "Arguelles", "Juan", "Pedro", "Luis", "Ana", "Maria", "Lucia"
    };
    private static final String[] VERBOS = {
        "cambio", "descubrio", "acepto", "escribio", "llamo"
    };
    private static final String[] OBJETOS = {
        "a mi madre", "a mi padre", "a mi hermano", "a Kike"
    };
    private static final String[] EXPRESIONES = {
        "volando", "corriendo", "saltando", "dormido", "bailando"
    };

    public static void main(String[] args) {
        System.out.println("--- Frases del delegado ---");
        System.out.println("Presiona Enter para generar una nueva frase (o escribe 'salir' para terminar).");

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String input;

        do {
            generarYMostrarFrase();
            input = scanner.nextLine();
        } while (!input.equalsIgnoreCase("salir"));

        scanner.close();
        System.out.println("¡Sayonara!");
    }

    public static void generarYMostrarFrase() {
        Random random = new Random();

        String sujeto = SUJETOS[random.nextInt(SUJETOS.length)];
        String verbo = VERBOS[random.nextInt(VERBOS.length)];
        String objeto = OBJETOS[random.nextInt(OBJETOS.length)];

        String expresion = EXPRESIONES[random.nextInt(EXPRESIONES.length)];

        String fraseGenerada = "El delegado dijo: " + sujeto + " " + verbo + " " + objeto + "... " + expresion;

        System.out.println(fraseGenerada);
    }
}