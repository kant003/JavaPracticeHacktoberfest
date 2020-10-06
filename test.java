import java.util.Scanner;

public class test {

	public static void main(String[] args) {

		Scanner opc_user = new Scanner(System.in);

		int opc = 02;

		while (opc != 3) {

			System.out.println("BIENVENIDO A MI PROGRAMA DE CONVERSION DE KM A MILLAS Y DE MILLAS A KM");
			System.out.println("-----------------------------------------");

			System.out.println("1 - Convertir de KM a MILLAS");
			System.out.println("2 - Convertir de MILLAS a KM");
			System.out.println("3 - Salir del programa");

			System.out.println("Escoge que quieres hacer: ");
			opc = opc_user.nextInt();

			if (opc == 1) {

				Scanner km_user = new Scanner(System.in);
				System.out.println("Introduce los KM que quieres convertir a millas: ");
				double km = km_user.nextInt();

				System.out.println("-----------------------------------------");

				double operacion = (km / 1.6);
				long operacionRedondeada = Math.round(operacion);
				System.out.println("El resultado de la operacion redondeada es: " + operacionRedondeada + " millas");

			}

			else if (opc == 2) {
				Scanner mll_user = new Scanner(System.in);
				System.out.println("Introduce los KM que quieres convertir a millas: ");
				double mll = mll_user.nextInt();

				System.out.println("-----------------------------------------");

				double operacion = (mll / 0.62137);
				long operacionRedondeada = Math.round(operacion);
				System.out.println("El resultado de la operacion redondeada es: " + operacionRedondeada + " KM");

			}

			else if (opc == 3) {
				System.out.println("¡HASTA LA PRÓXIMA!");
				System.exit(0);
			}

			else {
				System.out.println("Numero introducido no valido, por favor intentelo de nuevo");
			}

		}
	}

}
