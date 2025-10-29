package P1Y1;

import java.util.Scanner;

public class ejemplo8 {
public static void main(String[] args) {
	int m, n;
	Scanner sc = new Scanner(System.in);
	System.out.println("dame un entero m ");
	m = sc.nextInt();
	System.out.println("dame un entero n ");
	n = sc.nextInt();
	System.out.println("m es: "+m +" y n es: " +n);
	
	m *= n;
	System.out.println("m es:" +m);
	m /= n;
	System.out.println("m es:" +m);
	m %= n;
	System.out.println("m es:" +m);
	m += n;
	System.out.println("m es:" +m);
	m -= n;
	System.out.println("m es:" +m);
	
}
}
