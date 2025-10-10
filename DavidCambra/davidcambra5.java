package DavidCambra;
import java.util.Random;
import java.util.Scanner;

class Jugador {
    private String nombre;
    private int saldo;

    public Jugador(String nombre, int saldoInicial) {
        this.nombre = nombre;
        this.saldo = saldoInicial;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSaldo() {
        return saldo;
    }

    public void agregarDinero(int cantidad) {
        saldo += cantidad;
    }

    public boolean apostar(int cantidad) {
        if (cantidad > saldo) {
            System.out.println("No tienes suficiente saldo.");
            return false;
        }
        saldo -= cantidad;
        return true;
    }
}

class JuegosCasino {
    private static Random random = new Random();

    public static void tragaperras(Jugador jugador, int apuesta) throws InterruptedException {
        if (!jugador.apostar(apuesta))
            return;

        int r1 = random.nextInt(5);
        int r2 = random.nextInt(5);
        int r3 = random.nextInt(5);

        System.out.println("Girando los rodillos...");
        Thread.sleep(1000);
        System.out.print("Rodillos: ");
        Thread.sleep(1200);
        System.out.print(r1);
        Thread.sleep(1200);
        System.out.print(" | " + r2);
        Thread.sleep(1200);
        System.out.println(" | " + r3);
        Thread.sleep(1000);

        if (r1 == r2 && r2 == r3) {
            int premio = apuesta * 5;
            jugador.agregarDinero(premio);
            System.out.println("¡Jackpot! Ganaste " + premio + "$");
        } else if (r1 == r2 || r2 == r3 || r1 == r3) {
            int premio = apuesta * 2;
            jugador.agregarDinero(premio);
            System.out.println("¡Pareja! Ganaste " + premio + "$");
        } else {
            System.out.println("No ganaste nada. Suerte la próxima.");
        }
    }

    public static void ruleta(Jugador jugador, int apuesta) throws InterruptedException {
        if (!jugador.apostar(apuesta))
            return;

        Scanner sc = new Scanner(System.in);
        System.out.print("Apuesta a un número (0-36): ");
        int eleccion = sc.nextInt();

        int resultado = random.nextInt(37);
        System.out.println("Girando la ruleta...");
        Thread.sleep(2000);
        System.out.println("La bola cayó en el " + resultado);

        if (eleccion == resultado) {
            int premio = apuesta * 35;
            jugador.agregarDinero(premio);
            System.out.println("¡Ganaste " + premio + "$!");
        } else {
            System.out.println("Perdiste tu apuesta.");
        }

        sc.close();
    }
}

public class davidcambra5 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.println("¡BIENVENIDO AL GRAN CASINO DE LA FORTUNA!");
        System.out.println();
        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Bienvenido " + nombre + "!");
        System.out.println("Empezarás con un saldo de 100$. ¿Estás listx para perderlo todo?");
        String respuesta = sc.nextLine();

        if (respuesta.equalsIgnoreCase("no")) {
            System.out.println("Fuera de mi puto casino.");
            System.exit(0);
        } else {
            System.out.println("Muy bien! A perder todo se ha dicho!");
        }

        Jugador jugador = new Jugador(nombre, 100);
        int opcion;

        System.out.println("--------------------------------");
        System.out.println("GRAN CASINO DE LA FORTUNA");
        do {
            System.out.println("\n--- MENÚ CASINO ---");
            System.out.println("1. Ver saldo");
            System.out.println("2. Jugar a la tragaperras");
            System.out.println("3. Jugar a la ruleta");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Tu saldo es: " + jugador.getSaldo() + "$");
                    Thread.sleep(2000);
                    break;
                case 2:
                    System.out.println("--------------------------------");
                    System.out.println("Bienvenido a la tragaperras loca!");
                    System.out.println("Tu saldo actual es: " + jugador.getSaldo() + "$");
                    Thread.sleep(1000);
                    System.out.print("Introduce tu apuesta: ");
                    int apuestaT = sc.nextInt();
                    JuegosCasino.tragaperras(jugador, apuestaT);
                    break;
                case 3:
                    System.out.println("--------------------------------");
                    System.out.println("Bienvenido a la ruleta!");
                    System.out.println("Tu saldo actual es: " + jugador.getSaldo() + "$");
                    Thread.sleep(1000);
                    System.out.print("Introduce tu apuesta: ");
                    int apuestaR = sc.nextInt();
                    JuegosCasino.ruleta(jugador, apuestaR);
                    break;
                case 4:
                    System.out.println("¿Ya te vas? Menudo perdedor. Vuelve cuando quieras perder más dinero.");
                    System.out.println("Te quedas con " + jugador.getSaldo() + "$. ¡Adiós perdedor!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 4 && jugador.getSaldo() > 0);

        if (jugador.getSaldo() <= 0) {
            System.out.println("Te quedaste sin dinero pringado. Fuera del casino perdedor.");
        }

        sc.close();
    }
}
