package Reisen;

import java.util.Scanner;

public class propuesto12 {
	private double patatas;
	private double chocos;
	propuesto12(){
		patatas=0;
		chocos=0;
	}
	propuesto12(double p, double c){
		this.patatas=p;
		this.chocos=c;
	}
	
	
	public static int dimeclientes(double p, double c) {
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
	@Override
	public String toString() {
		return "ALMACEN [patatas=" + patatas + ", chocos=" + chocos + "]";
	}
	public void addpatatas(double x) {
		this.patatas+=x;
	}
	public void addchocos(double y) {
	this.chocos+=y;}
	

public void muestracomensales() {
System.out.println("podemos dar de comer a: "+ this.dimeclientes());
}
}








