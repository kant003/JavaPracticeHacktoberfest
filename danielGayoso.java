import java.util.Scanner;
public class danielGayoso {
    public static void main(String[] args) {
        //Programa para verificar los requisitos de edad
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce tu edad: ");
        int edad = sc.nextInt();
        if (edad >= 18) {
            System.out.println("Tienes la entrada permitida, eres mayor de edad");
        }
        else if (edad >= 0 && edad < 18) {
            System.out.println("Lo siento, eres menor de edad, no puedes pasar");
        }
        else{
            System.out.println("Edad no válida");
        }
    
    }
}
