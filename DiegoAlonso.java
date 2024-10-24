import java.util.Scanner;

public class DiegoAlonso {

	public static void main(String[] args) {

		int s;
		Scanner sc = new Scanner(System.in);
		System.out.println("dime los segundos que quieras");
		s = sc.nextInt();
		System.out.println("se mostrarán" + s + " segsundos en dias, horas minutos y segundos");
		
		int h = s / 3600;
		int m = s / 60;
		int minus = m - (h * 60);
		int res = s%60;
		int dias= h/24;
		int horas= h-(dias*24);
		System.out.println("es "+dias+" dias " + horas + " horas " + minus + " minutos y " + res + " segundos");

	}
    
  
}

    
