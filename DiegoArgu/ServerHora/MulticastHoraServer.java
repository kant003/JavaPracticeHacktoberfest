package DimeHora;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MulticastHoraServer {

    public static void main(String[] args) throws Exception {

        int puerto = 1234;
        String host = "230.0.0.1";

        MulticastSocket ms = new MulticastSocket(puerto);
        InetAddress grupo = InetAddress.getByName(host);

        ms.joinGroup(grupo);

        while (true) {

            try {

                Thread.sleep(5000);

                byte[] buf = new byte[1024];
                buf = obtenerHora().getBytes();

                DatagramPacket dp = new DatagramPacket(buf, buf.length, grupo, puerto);

                ms.send(dp);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public static String obtenerHora() {

        LocalDate fecha = LocalDate.now();
        LocalTime horaActual = LocalTime.now();

        DateTimeFormatter formateadorFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatteadorHora = DateTimeFormatter.ofPattern("HH:mm:ss");

        String horaFormateada = horaActual.format(formatteadorHora);
        String fechaFormateada = fecha.format(formateadorFecha);

        return "Fecha: " + fechaFormateada + ", Hora actual: " + horaFormateada;
    }

}
