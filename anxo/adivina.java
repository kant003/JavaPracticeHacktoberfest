import java.util.Scanner;

public class adivina {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numeroAleatorio = (int) (Math.random() * 100) + 1;
        int numero;
        int intentos = 0;

        do {

            System.out.print("Adivina un número (entre 1 y 100): ");
            numero = sc.nextInt();
            intentos ++;

            if (numero > numeroAleatorio) {
                System.out.println("El numero es mas pequeño");
            }else if(numero < numeroAleatorio){
                System.out.println("El numero es mas grande");
            }else{
                System.out.println("Adivinaste el numero a buscar!!");
            }

        } while (numero != numeroAleatorio || intentos <10);
        
    }
    
}
