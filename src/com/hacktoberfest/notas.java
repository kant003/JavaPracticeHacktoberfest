import java.util.Scanner;

public class notas {

	public static void main(String[] args) {
		int nota, contador=0, contador2=0, contador3=0;
		Scanner sc=new Scanner(System.in);
		for (int i=0; i<6; i++){
			System.out.println("Dame una nota entre 0 y 10: ");
			nota=sc.nextInt();
			if (nota>10||nota<0){
				System.out.println("LA NOTA NO ES VALIDA");
				i--;
			}
			else if (nota>=5){
				contador++;
			}else if(nota==4){
				contador2++;
			}else{
				contador3++;
			}
		}
		System.out.println("Aprobados: "+contador);
		System.out.println("Condicionados: "+contador2);
		System.out.println("Suspensos: "+contador3);
		
		System.out.println("FIN DE PROGRAMA");
		sc.close();
	}

}
