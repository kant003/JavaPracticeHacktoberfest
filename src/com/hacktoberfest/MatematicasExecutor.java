
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MatematicasExecutor {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = (ExecutorService) Executors.newFixedThreadPool(4);
		for (int i = 0; i < 200; i++) {
			int inicio = (i) * 1000;
			int fin = inicio + 1000;
			Primos calculaPrimos = new Primos(inicio, fin);
			System.out.println(inicio + "--" + fin);
			executor.execute(calculaPrimos);
		}
		executor.shutdown();
	}
}

class Primos implements Runnable {
	private int inicio, fin;

	public Primos(int inicio, int fin) {
		this.inicio = inicio;
		this.fin = fin;
	}

	public void run() {
		int aux;
		for (int numAnalizar = inicio; numAnalizar < fin; numAnalizar++) {
			boolean esPrimo = true;
			for (int cont = 2; cont < numAnalizar; cont++) {
				aux = numAnalizar % cont;
				if (aux == 0) {
					cont = numAnalizar;
					esPrimo = false;
				}
			}
			if (esPrimo)
				System.out.println(numAnalizar + " es numero primo.");
		}
	}
}