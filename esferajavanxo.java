package P1Y1;

import java.util.Scanner;

public class esferajava {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	double r;
	double ar,vol;
	System.out.println("dame radio: ");
	r=sc.nextDouble();
	ar=4*Math.PI*Math.pow(r, 2);
	vol=4*Math.PI*Math.pow(r, 3);
	
	System.out.println("area: "+ar);
	System.out.println("volumen "+vol);
	
}
}
