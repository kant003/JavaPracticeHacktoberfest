import java.util.*;

public class Adivina_numero {

	public static void main(String[] args) {
		
		int aleatorio = (int)(Math.random()*100);//Refundicion, le decimos que no lo convierte en entero
		
		Scanner entrada=new Scanner(System.in);
		
		int numero=0;
		int intentos=0;
		
		do {
			intentos++;
			System.out.println("Introduce un numero, por favor");
			numero=entrada.nextInt();
			
			if(aleatorio<numero) {
				System.out.println("Más bajo");
			}else if(aleatorio>numero) {
				System.out.println("Más alto");
			}
		}while(numero!=aleatorio); 
		System.out.println("Muy bien, has acertado el número!!!");
		System.out.println("Lo has conseguido en "+intentos+" intentos");
		
		entrada.close();
		}
	}