import java.util.Scanner;

public class NainIglesias {
    
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    try{
    int respuesta = 0;
		int sumando = 0;
		int sumador = 0;
		int total = 0;
		int restador = 0;
		int restado = 0;
		int divisor = 0;
		int dividendo = 0;
		int cociente = 0;
		int resto = 0;
		int multiplicador = 0;
		int multiplicando = 0;
		System.out.println("Que quieres hacer?" + "1 Sumar" + "2 Restar" + "3 Dividir" + "4 Multiplicar");

		respuesta = sc.nextInt();

		if (respuesta == 1) {

			System.out.println("Primer sumador:");

			sumador = sc.nextInt();

			System.out.println("Segundo sumador: ");

			sumando = sc.nextInt();

			total = sumador + sumando;

			System.out.println("Respuesta: " + total);

		}

		else if (respuesta == 2) {

			System.out.println("Primer restador:");

			restador = sc.nextInt();

			System.out.println("Segundo restador: ");

			restado = sc.nextInt();

			total = restador - restado;

			System.out.println("Respuesta: " + total);

		}

		else if (respuesta == 3) {

			System.out.println("Primer divisor:");

			divisor = sc.nextInt();

			System.out.println("Primer dividendo : ");

			dividendo = sc.nextInt();

			cociente = divisor / dividendo;
			resto = divisor % dividendo;

			System.out.println(divisor + "/" + dividendo + " da como cociente " + cociente + " y de resto " + resto);

		} else if (respuesta == 4) {

			System.out.println("Primer multiplicador:");

			multiplicador = sc.nextInt();

			System.out.println("Segundo multiplicando : ");

			multiplicando = sc.nextInt();

			total = multiplicador * multiplicando;

			System.out.println("Total de la multiplicación: " + total);

		}

		else {
			System.out.println("Bro no se que es eso intentalo con otro número anda");
		}
    }

    finally {
        sc.close();
        } 
	}


}
