import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestInetAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		System.out.println("dame una ip");
		String dirsc = sc.next();
		InetAddress dir = null;

		System.out.println("        ");
		System.out.println("Salida para LocalHost");
		try {
			// LOCALHOST
			dir = InetAddress.getByName("localhost");
			pruebaMetodos(dir);

			// URL www.google.es
			System.out.println("             ");
			System.out.println("Salida para una URL:");
			
			dir = InetAddress.getByName(dirsc);
			pruebaMetodos(dir);

			// Array de tipo inetAddres con todas las direcciones IP asignadas a google.es

			System.out.println("\tDirecciones IP para: " + dir.getHostName());
			InetAddress[] direcciones = InetAddress.getAllByName(dir.getHostName());
			for (int i = 0; i < direcciones.length; i++) {
				System.out.println("\t\t" + direcciones[i].toString());
			}

			System.out.println("               ");

		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}

	}// main

	private static void pruebaMetodos(InetAddress dir) {
		System.out.println("\tMetodo getByName(): " + dir);
		InetAddress dir2;
		try {
			dir2 = InetAddress.getLocalHost();
			System.out.println("\tMetodo getLocalHost(): " + dir2);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		System.out.println("\tMetodo getHostName(): " + dir.getHostName());
		System.out.println("\tMetodo getHostAddress(): " + dir.getHostAddress());
		System.out.println("\tMetodo toString(): " + dir.toString());
		System.out.println("\tMetodo getCanonicalHostName(): " + dir.getCanonicalHostName());
	}

}
