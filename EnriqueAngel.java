import java.util.Scanner;

public class resuelto4 {
	
	public static void esArmstrong(int numero) {
		int cifra1, cifra2, cifra3, cifra4;
		cifra1=numero/10/10/10;
		System.out.println(cifra1);
		cifra2=(numero/10/10)%10;
		System.out.println(cifra2);
		cifra3=(numero/10)%10;;
		System.out.println(cifra3);
		cifra4=numero%10;
		System.out.println(cifra4);
		
		
		int suma=(int)(Math.pow(cifra1,  4)+Math.pow(cifra2,  4)+Math.pow(cifra3, 4)+Math.pow(cifra4,  4));
		
		if(numero==suma)
			System.out.println("el numero "+numero+" es Armstrong.");
		else
		System.out.println("el numero "+numero+" no es Armstrong.");
	}
		
	

	public static void main(String[] args) {
		int numero;
		Scanner sc =new Scanner(System.in);
		System.out.println("Dame un número de cuatro cifras:");
		numero=sc.nextInt();
		
		esArmstrong(numero);
		
		//for(int i=100;i<1000;i++) {
			//esArmstrong(i);
		//}
		
}
}