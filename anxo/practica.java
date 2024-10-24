import java.net.InetAddress;
import java.net.UnknownHostException;

public class practica {

    public static void main(String[] args) {
        
        InetAddress dir = null;
        System.out.println("================================================");
        System.out.println("SALIDA PARA LOCALHOST");
        try {
            //LOCALHOST nombre de mi equipo
            dir = InetAddress.getByName("DESKTOP-QV8FAO5");
            pruebaMetodos(dir);//

            //URL www.google.es
            System.out.println("================================================");
            System.out.println("SALIDA PARA UNA URL");
            dir = InetAddress.getByName("www.cebem.net");
            // dir = InetAddress.getByName("www.google.es");
            pruebaMetodos(dir);

            System.out.println("================================================");
            //Array de tipo InetAddress con todas las direcciones IP
            //asignadas a google.es
            System.out.println("\tDIRECCIONES IP PARA: " + dir.getHostName());
            // Array de addresses
            InetAddress[] direcciones = InetAddress.getAllByName(dir.getHostName());
            for(int i=0; i < direcciones.length; i++) 
                System.out.println("\t\t"+direcciones[i].toString());

            System.out.println("================================================");

        } catch (UnknownHostException e1) {
            e1.printStackTrace();

        }

    } //main

    private static void pruebaMetodos(InetAddress dir) {
	
		System.out.println("\tMetodo getByName(): " + dir);
        InetAddress dir2;
        try {
            dir2 = InetAddress.getLocalHost();
            System.out.println("\tMetodo getLocalHost(): " + dir2);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        // USAMOS METODOS DE LA CLASE
        System.out.println("\tMetodo getHostName(): " + dir.getHostName());
        System.out.println("\tMetodo getHostAddress(): " + dir.getHostAddress());
        System.out.println("\tMetodo toString(): " + dir.toString());
        System.out.println("\tMetodo getCanonicalHostName(): " + dir.getCanonicalHostName());
    }

}
