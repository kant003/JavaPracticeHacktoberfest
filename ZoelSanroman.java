public class ZoelSanroman {
	public static void main(String[] args) {

		System.out.println("La primitiva es: ");
		for (int j = 1; j < 7; j++) {
			System.out.println((int) (1 + Math.random() * 49));
		}

		System.out.println("Y el reintegro: ");
		for (int j = 1; j < 3; j++) {
			System.out.println((int) (1 + Math.random() * 9));
		}
	}
}
