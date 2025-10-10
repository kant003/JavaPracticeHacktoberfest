package tres;

import java.util.Scanner;

public class arbol_mejorado {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Como de alto quieres el árbol?: ");
        int filas = sc.nextInt();
        
        System.out.print("¿De que quieres que esté echo el árbol?: ");
        char sim = sc.next().charAt(0);

        // arbol
        for (int i = 0; i < filas; i++) {
            for (int k = 0; k < filas - i - 1; k++) {
                System.out.print(" ");
            }

            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print(sim);
            }
            System.out.println("");
        }

        // tronco
        int ancho = 3; // Cambiar esto valor para tronco mas grueso
        int centrar = filas - ancho / 2 - 1; // Centrar tronco
        
        for (int i = 0; i < filas / 3; i++) {
            for (int k = 0; k < centrar; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < ancho; j++) {
                System.out.print("|");
            }
            System.out.println();
        }

        System.out.println("¡Feliz Navidad! :D");
    }
}