public class satelite {
    
    // atributos
	private double meridiano;
	private double paralelo;
	private double distancia_tierra;

	// constructor con todos los parametros
	satelite(double m, double p, double d) {
		meridiano = m;
		paralelo = p;
		distancia_tierra = d;
	}

	// constructor sin parametros
	satelite() {
		meridiano = paralelo = distancia_tierra = 0;
	}

	// metodos setters y getters

	public double getMeridiano() {
		return meridiano;
	}

	public void setMeridiano(double meridiano) {
		this.meridiano = meridiano;
	}

	public double getParalelo() {
		return paralelo;
	}

	public void setParalelo(double paralelo) {
		this.paralelo = paralelo;
	}

	public double getDistancia_tierra() {
		return distancia_tierra;
	}

	public void setDistancia_tierra(double distancia_tierra) {
		this.distancia_tierra = distancia_tierra;
	}

	public void setPosicion(double m, double p, double d) {

		meridiano = m;
		paralelo = p;
		distancia_tierra = d;
	}

	public void printPosicion() {
		System.out.println("El satélite se encuentra en el paralelo " + paralelo + " y en el meridiano " + meridiano
				+ " a una distancia de la tierra de " + distancia_tierra + " kilometros");

	}

	@Override
	public String toString() {
		return "satelite [meridiano=" + meridiano + ", paralelo=" + paralelo + ", distancia_tierra=" + distancia_tierra
				+ "]";
	}


}
