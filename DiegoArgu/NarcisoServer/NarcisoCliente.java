
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class NarcisoCliente {

    public static void main(String[] args) throws IOException {

        int port = 11234;
        String server = "localhost";

        InetAddress addresss = InetAddress.getByName(server);

        DatagramSocket socket = new DatagramSocket();
        boolean corte = false;

        Scanner sc = new Scanner(System.in);

        while (!corte) {

            System.out.println("Dame un numero de 3 cifras: ");
            String frase = sc.nextLine();

            frase = filtroFrase(frase);

            byte[] enviar = frase.getBytes();
            DatagramPacket enviarDatos = new DatagramPacket(enviar, enviar.length, addresss, port);

            socket.send(enviarDatos);

            if (!frase.equals("quit")) {

                byte[] recibir = new byte[1024];
                DatagramPacket recibirDatos = new DatagramPacket(recibir, recibir.length);

                socket.receive(recibirDatos);
                String mensaje = new String(recibirDatos.getData(), 0, recibirDatos.getLength());
                System.out.println("recibido: " + mensaje);

            } else {
                System.out.println("cerrando server...");
                corte = !corte;
            }

        } // fin while

    }

    private static String filtroFrase(String frase) {
        if (frase.equals("quit")) {
            return "quit";
        }

        Integer numero = Integer.parseInt(frase);

        if (numero >= 100 && numero <= 999) {
            return String.valueOf(numero);
        } else {
            return "no";
        }
    }

}
