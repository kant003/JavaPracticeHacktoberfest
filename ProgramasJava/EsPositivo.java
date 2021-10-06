import java.util.Scanner;

public class EsPositivo
    
public static void main (String() args) {

    int numero
    System.out.println("Inserte un numero");
    Scanner lector = new Scanner(System.in);
    numero = lector.nextInt();
    if(numero >= 0){
        System.out.println("Es positivo");
    }
    else {
        System.out.println("Es negativo");
    }
}