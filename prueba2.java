public class prueba2 {

	// atributos

	private double km; // kilometros recorridos
	private double litros; // litros consumidos
	private double vmed; // velocidad media
	private double pgas; // precio gasolina

	// constructor

	public prueba2(double km, double litros, double vmed, double pgas) {
		super();
		this.km = km;
		this.litros = litros;
		this.vmed = vmed;
		this.pgas = pgas;

		// getters y setters
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public double getLitros() {
		return litros;
	}

	public void setLitros(double litros) {
		this.litros = litros;
	}

	public double getVmed() {
		return vmed;
	}

	public void setVmed(double vmed) {
		this.vmed = vmed;
	}

	public double getPgas() {
		return pgas;
	}

	public void setPgas(double pgas) {
		this.pgas = pgas;
	}

	// metodos propios de la clase

	public double dimeTiempo() {
		return km / vmed;
	}

	public double consumoMedio() { // De 100km
		return litros / km * 100;
	}

	public double consumoEuros() {
		return km * pgas;

		/*
		 * double aux = this.consumoMedio(); return aux * pgas;
		 */
	}

	@Override
	public String toString() {
		return "prueba2 [km=" + km + ", litros=" + litros + ", vmed=" + vmed + ", pgas=" + pgas + "]";
	}

}
