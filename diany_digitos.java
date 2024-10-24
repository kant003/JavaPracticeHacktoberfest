import java.util.Scanner;

public class diany_digitos {

	public static int  sumaDigitos (int n) {
		int cifra=0;
		int suma=0;
		int digitos = cuentaDigitos(n);
		
		while(digitos>0) {
			cifra=(int) (n/Math.pow(10, digitos-1)%10);
			suma+= n/Math.pow(10, digitos-1)%10;
			n-=cifra*Math.pow(10, digitos-1);
			digitos--;
		}
		return suma;
	}
	//iterativo
	public static int invierteNumero(int n) {
		//1634 ------> 4361
		int cifra=0;
		int digitos = cuentaDigitos(n);
		int cons=0;
		int j=0;
		
		while(digitos>0) {
			cifra=(int) (n/Math.pow(10, digitos-1)%10);
			n-=cifra*Math.pow(10, digitos-1);
			digitos--;
			cons+=cifra*Math.pow(10, j);
			j++;
		}
		return cons;
	}
	
	//iterativo
	public static int cuentaDigitos(int n) {
		int aux=0;

		if (n==0)
			return 1;
		else {
			while(n>0) {
			n/=10;
			aux++;
		}
		return aux;
	}}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Dime numero:");
		int numero = sc.nextInt();
		int res = cuentaDigitos(numero);
		System.out.println("Tiene "+res+" digitos");
		System.out.println("----------------------");
		System.out.println("Suma digitos: "+sumaDigitos(numero));
		System.out.println("----------------------");
		int invertido;
		System.out.println("Invertido es: "+invierteNumero(numero));
}}
