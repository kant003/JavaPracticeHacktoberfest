package escaner;

import java.util.Scanner;

public class Scany {
	
	public static int menu(String[] opciones,String titulo) {
		int res=0;
		do {
			System.out.println("\n==="+titulo+"===\n");

			System.out.println("0- Salir");
			for (int i = 0; i < opciones.length; i++) {
				System.out.println((i+1)+"- "+opciones[i]);
			}


			res=Scany.scanyInt("\nOpcion seleccionada:");
			if(res>opciones.length)
				System.out.println("Error, selecciona una de las opciones ofrecidas.");
		}while(res>opciones.length);

		return res;
	}
	
	public static int menu(String[] opciones) {
		int res=0;
		do {

			System.out.println("0- Salir");
			for (int i = 0; i < opciones.length; i++) {
				System.out.println((i+1)+"- "+opciones[i]);
			}


			res=Scany.scanyInt("\nOpcion seleccionada:");
			if(res>opciones.length)
				System.out.println("Error, selecciona una de las opciones ofrecidas.");
		}while(res>opciones.length);

		return res;
	}
	
	public static String scanyString(String texto) {
		String res = null;
		Boolean fallo=false;
		
		do {
			try {
				Scanner sc=new Scanner(System.in);
				System.out.println(texto);
				res=sc.nextLine();
				fallo=false;
			}catch(Exception e) {
				fallo=true;
				System.err.println("Error con el dato introducido: " + e.getMessage());
				System.out.println("Debe de ser un string, intentalo de nuevo");
			}
			
		}while(fallo);
		
		
		return res;
	}
	
	public static int scanyInt(String texto) {
		int res = 0;
		Boolean fallo=false;
		
		do {
			try {
				Scanner sc=new Scanner(System.in);
				System.out.println(texto);
				res=sc.nextInt();
				fallo=false;
			}catch(Exception e) {
				fallo=true;
				System.err.println("Error con el dato introducido: " + e.getMessage());
				System.out.println("debe de ser un int, intentalo de nuevo");
			}
			
		}while(fallo);
		
		
		return res;
	}
	
	
	
	public static Boolean scanyBoolean(String texto) {
		Boolean res=false;
		Boolean fallo=false;
		
		do {
			try {
				Scanner sc=new Scanner(System.in);
				System.out.println(texto);
				res=sc.nextBoolean();
				fallo=false;
			}catch(Exception e) {
				fallo=true;
				System.err.println("Error con el dato introducido: " + e.getMessage());
				System.out.println("debe de ser un boolean, intentalo de nuevo");
			}
			
		}while(fallo);
		
		
		return res;
	}
	
	public static float scanyFloat(String texto) {
	float res = 0;
	Boolean fallo=false;
	
	do {
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println(texto);
			res=sc.nextFloat();
			fallo=false;
		}catch(Exception e) {
			fallo=true;
			System.err.println("Error con el dato introducido: " + e.getMessage());
			System.out.println("debe de ser un float, intentalo de nuevo");
		}
		
	}while(fallo);
	
	
	return res;
}
	
	
	
	

}
