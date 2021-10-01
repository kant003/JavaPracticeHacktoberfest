
public class Peso {

	float peso;
	// Para convertir de libras a kg ( dividir entre 2,205 )
	// Para convertir de gramos a kg ( dividir entre 1000 )

	// CONSTRUCTOR. Se le pasa un valor float y una medida
	// Devuelve un float con el peso SIEMPRE EN KILOS
	Peso(float p, char m) {
		this.peso = pesoEnKilogramos(p, m);
	}

	// CONVIERTE cq valor y medida a un valor float en KILOS
	public float pesoEnKilogramos(float p, char m) {

		switch (m) {

		case 'K':
			return p;

		case 'G':
			return p / 1000;

		case 'L':
			return p * 0.453f;

		case 'N':

		case 'O':

		case 'P':

		case 'Q':

		default:
			return 0f;
		}
	}

	// Este metodo devuelve el peso en la medida que se solicite
	public float getPeso(char m) {

		switch (m) {

		case 'K':
			return peso;
		case 'G':
			return getGramos();
		case 'L':
			return getLibras();
		case 'N':
			return getLingotes();
		case 'O':
			return getOnzas();
		case 'P':
			return getPeniques();
		case 'Q':
			return getQuintales();
		default:
			return 0f;
		}

	}

	// Conversiones de kilos a gramos y libras y viceversa

	public float getGramos() {
		return peso * 1000;
	}

	public float getLibras() {
		return peso / 0.453f;
	}

	public float getOnzas() {
		return peso * 0.028f;
	}

	public float getLingotes() {
		return peso / 14.59f;
	}

	public float getPeniques() {
		return peso / 0.00155f;
	}

	public float getQuintales() {
		return peso / 43.3f;
	}
}
