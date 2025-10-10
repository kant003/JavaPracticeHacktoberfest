package Tema2;

import java.util.Scanner;
//Este es el test de mi cambio4
public class coche_test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        coche renault = new coche();
        System.out.println("Introduce la velocidad del vehículo");
        int vel = sc.nextInt();
        System.out.println("Cuanto acelera el vehículo?");
        int acelera = sc.nextInt();
        System.out.println("Cuanto frena el vehículo?");
        int frena = sc.nextInt();
        renault.setVelocidad(vel);
        System.out.println(renault.toString());
        renault.acelera(acelera);
        System.out.println(renault.toString());
        renault.frena(frena);
        System.out.println(renault.toString());

        coche merchi = new coche();
        System.out.println("Introduce la velocidad de merchi: ");
        int vm = sc.nextInt();
        merchi.setVelocidad(vm);
        System.out.println(merchi.toString());
        int potito=merchi.getVelocidad();
        System.out.println(potito);
    }
}