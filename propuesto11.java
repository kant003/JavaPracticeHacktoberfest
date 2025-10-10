package Reisen;

import java.util.Scanner;

public class propuesto11 {
private static int dimeclientes(double p, double c) {
	int num=0;

	while((p>=1) && (c>=0.5)) {

	p-=1;
	c-=0.5;
	num=+3;

}	return num;

}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("cuanto hay de patatas: ");
	double patatas=sc.nextDouble();
	System.out.println("cuanto hay de chocos: ");
	double chocos=sc.nextDouble();
	
	System.out.println("podemos dar de comer a: "+dimeclientes(patatas, chocos));

}
}
