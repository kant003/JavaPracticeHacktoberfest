import java.util.Scanner;

public class Zahlenraten {

    public static void main(String[] args) {

        // Erzeuge zufällige Zahl zwischen 1 und 100
        int randomNumber = (int) (Math.random() * 100) + 1;
        System.out.println("Versuche eine Zahl zwischen 1 und 100 zu erraten, du hast 10 Versuche");
        Scanner input = new Scanner(System.in);
        // Schleife für 10 Versuche die richtige Zahl zu finden.
        for (int i = 0; i <= 9; i++) {
            int inputUser = input.nextInt();
            if (inputUser == randomNumber) {
                System.out.println("Du hast die Zahl erraten!");
                break;
            } else if (i == 9) {
                System.out.println("Du hast leider verloren!");
                break;
            } else if (inputUser < randomNumber) {
                System.out.println("Die gesuchte Zahl ist größer, versuche es nochmal!");
            } else {
                System.out.println("Die gesuchte Zahl ist kleiner, versuche es nochmal!");
            }
        }

    }
}
