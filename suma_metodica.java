package P1Y1;

import java.util.Scanner;

public class suma_metodica {
	public static int suma (int pri, int seg) {
		int sum; 
		sum = pri + seg;
		
		return sum;
		
		}

		public static void main(String[] args) {
				System.out.println("introduce el primer número");
		int pri, seg, res;
				
				Scanner can = new Scanner(System.in);
				pri = can.nextInt();
				
		System.out.println("introduce el segundo número");
				
				Scanner an = new Scanner(System.in);
				seg = an.nextInt();
				
				 res= suma(pri, seg);

				
				System.out.println("la potencia es: "+ res);
				
				can.close();
				an.close();
				
		}
}
