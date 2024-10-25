package Herencia2_Inmueble;

public class Casa_ConjuntoCerrado extends Casa_Urbana{
	
	public static int VALOR_AREA = 2500;
	protected float valorAdministracion ;
	protected double tienePiscina;
	protected boolean tieneCamposDeportivos;
	
	public Casa_ConjuntoCerrado(int id, int area, String direccion, int num_habitaciones, int num_baños, int pisos,
			float valorAdministracion, double tienePiscina, boolean tieneCamposDeportivos) {
		super(id, area, direccion, num_habitaciones, num_baños, pisos);
		this.VALOR_AREA = VALOR_AREA;
		this.valorAdministracion = valorAdministracion;
		this.tienePiscina = tienePiscina;
		this.tieneCamposDeportivos = tieneCamposDeportivos;
	}

//	GETTERS Y SETTERS
	public static int getVALOR_AREA() {
		return VALOR_AREA;
	}

	public float getValorAdministracion() {
		return valorAdministracion;
	}

	public double getTienePiscina() {
		return tienePiscina;
	}

	public boolean isTieneCamposDeportivos() {
		return tieneCamposDeportivos;
	}

	public static void setVALOR_AREA(int vALOR_AREA) {
		VALOR_AREA = vALOR_AREA;
	}

	public void setValorAdministracion(float valorAdministracion) {
		this.valorAdministracion = valorAdministracion;
	}

	public void setTienePiscina(double tienePiscina) {
		this.tienePiscina = tienePiscina;
	}

	public void setTieneCamposDeportivos(boolean tieneCamposDeportivos) {
		this.tieneCamposDeportivos = tieneCamposDeportivos;
	}

//	TO STRING
	@Override
	public String toString() {
		return "Casa_ConjuntoCerrado [valorAdministracion=" + valorAdministracion + ", tienePiscina=" + tienePiscina
				+ ", tieneCamposDeportivos=" + tieneCamposDeportivos + ", numeroPisos=" + numeroPisos
				+ ", numeroHabitaciones=" + numeroHabitaciones + ", numeroBanos=" + numeroBanos + ", id=" + id
				+ ", area=" + area + ", direccion=" + direccion + ", precioVenta=" + precioVenta + "]";
	}
	
//	METODO
	public double calcularPrecioVenta() {
		return area*VALOR_AREA;
	}	

}
