import java.util.Scanner;

public class TablaMultiplicar {

	public static void main(String[] args) {
		int num, multiplicacion=0;
		
		Scanner sc=new Scanner (System.in);
		
		System.out.println("Introduzca un número del 1 al 10 del cual quiera saber la tabla de multiplicar");
		
		num=sc.nextInt();
		
		if (num>=1 && num<=10){
			
			for (int i=1; i<=10; i++){
				
				multiplicacion=num*i;
				System.out.println(num + " x " + i + " = " + multiplicacion);
				
			
			}
			
			
		}
			else{ System.out.println("Usted no ha introducido un número válido. Fin del programa");
				
			}
		}
	}
