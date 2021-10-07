import java.util.Scanner;

public class TablasDeMultiplicarConFiltro {
	public static void main(String[] args) {

		int tabla = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("Por favor introduzca el número de tabla que quiere visualizar");
		tabla = sc.nextInt();

		// decidimos si el numero es mayor o igual que 1 y (AND) menor o igual que 10
		if ((tabla >= 1) && (tabla <= 10)) {

			System.out.println("TABLA DE MULTIPLICAR DEL " + tabla);
			System.out.println("----------------------------");

			for (int i = 1; i <= 10; i++) {
				System.out.println(tabla + " * " + i + " = " + tabla * i);
			}
		}

		else {
			System.out.println("NUMERO INCORRECTO");
		}
		sc.close();
	}

}