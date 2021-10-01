package Ejercicio02;

public class Persona {

	String nombre;
	int edad;
	String dni;
	char sexo;
	float peso;
	float altura;

	// CONSTRUCTORES

	public Persona() {
		super();
		this.nombre = "";
		this.edad = 0;
		this.sexo = 'H';
		this.peso = 0;
		this.altura = 0;
		generarDni();
	}

	public Persona(String nombre, int edad, char sexo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.peso = 0;
		this.altura = 0;
		generarDni();
	}

	public Persona(String nombre, int edad, char sexo, float peso, float altura) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = comprobarSexo(sexo);
		this.peso = peso;
		this.altura = altura;
		generarDni();
	}

	// METODOS

	public int calcularIMC() {
		float imc = peso / (altura / 2);
		if (imc < 20) {
			return -1;
		} else if ((imc > 20) && (imc < 25)) {
			return 0;
		} else {
			return 1;
		}
	}

	public boolean esMayorDeEdad() {
		if (edad >= 18) {
			return true;
		} else {
			return false;
		}
	}

	public char comprobarSexo(char sexo) {
		if ((sexo != 'H') && (sexo != 'M')) {
			return 'H';
		} else {
			return sexo;
		}
	}

	private void generarDni() {
		final int divisor = 23;

		// Generamos un número de 8 digitos
		int numDNI = ((int) Math.floor(Math.random() * (100000000 - 10000000) + 10000000));
		int res = numDNI - (numDNI / divisor * divisor);

		// Calculamos la letra del DNI
		char letraDNI = generaLetraDNI(res);

		// Pasamos el DNI a String
		this.dni = Integer.toString(numDNI) + letraDNI;
	}

	private char generaLetraDNI(int res) {
		char letras[] = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
				'L', 'C', 'K', 'E' };

		return letras[res];
	}

	// METODOS SET

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}
	// To String

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", dni=" + dni + ", sexo=" + sexo + ", peso=" + peso
				+ ", altura=" + altura + "]";
	}

}
