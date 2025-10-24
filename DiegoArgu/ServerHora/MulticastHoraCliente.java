package DimeHora;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class MulticastHoraCliente {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int puerto = 1234;
        String host = "230.0.0.1";

        MulticastSocket ms = new MulticastSocket(puerto);
        InetAddress grupo = InetAddress.getByName(host);

        ms.joinGroup(grupo);
        String mensaje = "";
        boolean corte = false;

        System.out.println("Cliente unido al grupo y recibiendo la pinche hora: ");

        while (!corte) {

            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length, grupo, puerto);
            ms.receive(dp);

            mensaje = new String(dp.getData(), 0, dp.getLength());

            System.out.println("recibido: " + mensaje);
            System.out.println("Seguir: S/N");

            char respuesta = sc.nextLine().toLowerCase().trim().charAt(0);

            if (respuesta == 'n') {
                corte = !corte;
            }
        }

        ms.leaveGroup(grupo);
        ms.close();
        sc.close();
    }
}
