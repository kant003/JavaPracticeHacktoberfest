public class ZoelSanroman {
	public static void main(String[] args) {
		System.out.println("Inicio de simulacion de la primitiva: ");
		System.out.println("La primitiva es: ");
		for (int x = 1; x < 7; x++) {
			System.out.println((int) (1 + Math.random() * 49));
		}

		System.out.println("Y el reintegro: ");
		for (int y = 1; y < 3; y++) {
			System.out.println((int) (1 + Math.random() * 9));
		}
	}
}
