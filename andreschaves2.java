import java.util.Scanner;

public class andreschaves2 {

    public static void main(String[] args) {

        Scanner dimequequieresytedirecomoeres = new Scanner(System.in);
        String responde = "";

        System.out.println("¿Quieres una camiseta o plantar un árbol? ");

        responde = dimequequieresytedirecomoeres.nextLine();

        if (responde.equals("camiseta")) {

            System.out.println("¡Bienvenido a DAM!");

        } 
        
        else {
            System.out.println("Eres buena gente. Ojalá hubiera más como tú");
        }

    }

}