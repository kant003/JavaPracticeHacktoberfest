import java.util.Random;
import java.util.Scanner;

public class minijuego {

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {
			Random num = new Random();
			boolean vivo = true;
			int hpmax = 100, hpmonster = 100, hit = 0, mhit = 0;
			int attack = 1;
			int quest = 0;
			int lifes = 5;
			int ac = 13, mac = 13;
			int dado1 = 0;
			int dadom = 0;

			while (vivo) {

				System.out.println(
						"VIDA = " + hpmax + "      VIDA MONSTRUO = " + hpmonster + "    NUMERO DE VIDAS: " + lifes);

				System.out.println("Quieres atacar? Presiona 1.");

				attack = scan.nextInt();

				if (attack == 1) {
					dado1 = num.nextInt(21)+1;
					dadom = num.nextInt(21)+1;
					if (dado1 >= mac) {
						hit = num.nextInt(21)+1;
						hpmonster = hpmonster - hit;
						System.out.println("Has sacado un " + dado1 + "y el AC de tu enemigo es de" + mac);
						System.out.println("Has atacado con un" + hit + ". La vida del monstruo se reduce a " + hpmonster);
						if (hit == 20) {
							hpmonster = hpmonster - 100;
							System.out.println("HAS HECHO UN GOLPE CRÍTICO");

						}

					} else {
						System.out.println("Has sacado un " + dado1 + " y el AC de tu enemigo es de " + mac + ""
								+ " por lo que has fallado el ataque");
					}
					if (dadom >= ac) {
						mhit = num.nextInt(21)+1;
						hpmax = hpmax - mhit;
						System.out.println("El monstruo ha sacado un  " + dadom + "y tu AC es de \n1  " + ac
								+ ". Has sido atacado con un " + mhit + ". Tu vida es de " + hpmax);
						if (mhit == 20) {
							hpmax -= 100;
							System.out.println("EL MONSTRUO TE HA HECHO UN GOLPE CRÍTICO");
						}

					} else {
						System.out.println("Tu enemigo ha sacado un " + dadom + " y tu AC es de " + ac
								+ "por lo que ha fallado el ataque");
					}

					while (hpmax <= 0) {
						vivo = false;
						lifes--;
						System.out.println("Has muerto amigo. Quieres reiniciar? Si (1). No (2)");

						quest = scan.nextInt();

						if (quest == 1) {

							vivo = true;
							hpmax = 100;
							hpmonster = 100;
							if (lifes == 0) {

								vivo = false;
								System.out.println("SE TE ACABARON LAS VIDAS");
								break;

							}

						} else if (quest == 2) {
							System.out.println("Pos hasta luego muchachoooooo");
							break;

						} else {
							System.out.println("COMANDO NO VÁLIDO");
						}

					}
					while (hpmonster <= 0 & hpmax >= 1) {
						vivo = false;
						System.out.println("HAS GANADO. HASTA LUEGO MAN");
						System.out.println("Quieres volver a empezar? SI (1). NO (2). ");
						quest = scan.nextInt();
						if (quest == 1) {
							vivo = true;
							hpmax = 100;
							hpmonster = 100;
							System.out.println("has vuelto a empezar");
							break;
						}
						else if (quest == 2) {
							System.out.println("HASTA LUEGO MARICARMEN");
							break;
							
							
						}

					}

				} else {

					System.out.println("COMANDO NO VÁLIDO");

				}

			}
		}

		
	}

	
}
