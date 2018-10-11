import java.util.Scanner;
public class Billetes2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner (System.in);
		int cant = 0;
		
		System.out.println("Intoduzca cantidad ");
		cant = sc.nextInt();
		
		//Variables para contar tipo de billete
		int q = 0;
		int d = 0;
		int c = 0;
		int ci= 0; 
		int v = 0;
		int di = 0;
		int cin = 0;

		if (cant >= 500) {
			q++;
			cant = cant-500 ;}
		else if (cant >= 200) {
			d++;
			cant -= 200;}
		else if (cant >= 100) {
			c++;
			cant -= 100;}
		else if (cant >= 50) {
			ci++;
			cant -= 50;}
		else if (cant >= 20) {
			v++;
			cant -= 20;}	
		else if (cant >= 10) {
			di++;
			cant -= 10;}
		else if (cant >= 5) {
			cin++;
			cant -= 5;}
		else {
			System.out.println("La cantidad sobrante es: "+ cant);}
		
		System.out.println("La cantidad de 500 es: " + q);
		System.out.println("La cantidad de 200 es: " + d);
		System.out.println("La cantidad de 100 es: " + c);
		System.out.println("La cantidad de 50 es: " + ci);
		System.out.println("La cantidad de 20 es: " + v);
		System.out.println("La cantidad de 10 es: " + di);
		System.out.println("La cantidad de 5 es: " + cin);
		sc.close();
		
		}

}
