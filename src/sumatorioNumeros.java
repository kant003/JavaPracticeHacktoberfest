
import java.util.Scanner;
public class sumatorioNumeros {
	public static void main(String[] args) {
		int a=1,resul=0;
		
		System.out.println("Vaya introduciendo numeros y los iremos sumando, hasta que introduzca un cero ");
		
		Scanner sc=new Scanner (System.in);
		
		
		while (a!=0) {
			System.out.println("Introduzca un numero ");
			a=sc.nextInt();
			if (a>0){
				resul=resul+a;
			}
			
				
				}
		System.out.println("La suma de todos sus numero introducidos es " + resul);
		}
		
	}




