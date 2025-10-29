
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class NarcisoServer {

    public static void main(String[] args) throws IOException {

        int port = 11234;
        DatagramSocket socket = new DatagramSocket(port);

        byte[] recibir = new byte[1024];
        byte[] enviar;
        boolean cortar = false;

        System.out.println("Arrancado el server Falangista...");

        while (!cortar) {

            DatagramPacket recibirDatos = new DatagramPacket(recibir, recibir.length);
            socket.receive(recibirDatos);

            String frase = new String(recibirDatos.getData(), 0, recibirDatos.getLength()).trim();
            System.out.println("recibido: " + frase);

            if (!frase.equals("quit")) {

                String devolver = comprobarNarciso(frase);

                enviar = devolver.getBytes();
                DatagramPacket enviarDatos = new DatagramPacket(enviar, enviar.length, recibirDatos.getAddress(), recibirDatos.getPort());

                socket.send(enviarDatos);
            } else {
                cortar = true;
                System.out.println("Cerrando...");
            }

        }

    }

    private static String comprobarNarciso(String frase) {
        int n = Integer.parseInt(frase);
        int temp = n;
        int suma = 0;

        int digitos = String.valueOf(n).length();

        while (temp > 0) {
            int digito = temp % 10;
            suma += Math.pow(digito, digitos);
            temp /= 10;
        }

        if (suma == n) {
            return "Es narcisista";
        } else {
            return "No es narcisista";
        }
    }

}
