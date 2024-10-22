

import java.util.Scanner;

public class JimmyCalderon4 {
	public static void main(String[] args) {
		int t;
		Scanner sc= new Scanner (System.in);
		System.out.println("Dime segundos: ");
		t=sc.nextInt();
		System.out.println("vamos a convertir "+ t+ "segundos a horas, minutos y segundos");
		
		int hora=0;
		int min=0;
		int seg=0;
		
		seg=t%60;	//resto
		hora= (t/60)/60;
		min= (t/60)% 60;
		
		
		System.out.println("en horas son: "+hora);
		System.out.println("en minutos son: "+min);
		System.out.println("en segundos son: "+seg);
		
		sc.close()	;				
	}

}
