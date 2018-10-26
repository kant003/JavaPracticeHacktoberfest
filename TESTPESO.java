
public class TESTPESO {

		public static void main(String[] args) {
			
			Peso argentino = new Peso(6.347f, 'K');
			
			System.out.println("en kilos: "+ argentino.getPeso('K'));
			System.out.println("en gramos: "+argentino.getPeso('G'));
			System.out.println("en libras: "+argentino.getPeso('L'));
			
			// Creo un objeto de 5312 gramos
			Peso dominicano = new Peso(5312f,'G');
			
			// Veo las conversiones de dicho objeto
			System.out.println("en kilos: "+ dominicano.getPeso('K'));
			System.out.println("en gramos: "+ dominicano.getPeso('G'));
			System.out.println("en libras: "+ dominicano.getPeso('L'));
			
			// Creo un objeto de 10 libras
			Peso mexicano = new Peso(10.0f,'L');
			
			// Veo las conversiones de dicho objeto
			System.out.println("en kilos: "+ mexicano.getPeso('K'));
			System.out.println("en gramos: "+ mexicano.getPeso('G'));
			System.out.println("en libras: "+ mexicano.getPeso('L'));
			
		}
}
