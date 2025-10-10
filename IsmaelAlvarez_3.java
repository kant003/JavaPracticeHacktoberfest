public class IsmaelAlvarez_3 {

    public static void main(String[] args) throws InterruptedException {
	
		int numero = 1;
		
		do {
			System.out.println("el numero vale: " + numero);
			numero++;
			Thread.sleep(3000);
		}
		
		while (numero <= 10); { //bucle que cuenta hasta 10
		
		System.out.println("fin");
	    }
    }
}
