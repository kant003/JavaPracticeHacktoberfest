import java.util.Scanner;

public class suma {

	public static void main(String[] args) {

		// variables locales
		Scanner mepiro = new Scanner(System.in);
		int n1;
		int n2;
		int suma;
		int cont=0;
		
		
	while(cont<5)	{
			// ENTRADAS
			System.out.println("introduce primer sumando: ");
			n1 = mepiro.nextInt();
			System.out.println("introduce segundo sumando: ");
			n2 = mepiro.nextInt();

			// ALGORITMO
			suma = n1 + n2;

			// SALIDA
			System.out.println("LA SUMA ES: " + suma);
			cont=cont+1;
			System.out.println("el contador vale: "+cont);
		}//fin while
	
	System.out.println("FIN PROGRAMA");

	}

}