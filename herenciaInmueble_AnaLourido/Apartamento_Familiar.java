package Herencia2_Inmueble;

public class Apartamento_Familiar extends Apartamento{
	
	public static int  VALOR_AREA = 2000;
	protected int valorAdministracion;
	
	public Apartamento_Familiar(int id, int area, String direccion, int num_habitaciones, int num_baños, int valorAdministracion) {
		super(id, area, direccion, num_habitaciones, num_baños);
		this.VALOR_AREA = VALOR_AREA;
		this.valorAdministracion = valorAdministracion;
	}
	
//	GETTERS Y SETTERS
	public int getVALOR_AREA() {
		return VALOR_AREA;
	}

	public int getValorAdministracion() {
		return valorAdministracion;
	}

	public void setVALOR_AREA(int VALOR_AREA) {
		this.VALOR_AREA = VALOR_AREA;
	}

	public void setValorAdministracion(int valorAdministracion) {
		this.valorAdministracion = valorAdministracion;
	}
	
//	TO STRING
	@Override
	public String toString() {
		return "Apartamento_Familiar [valorAdministracion=" + valorAdministracion + ", numeroHabitaciones="
				+ numeroHabitaciones + ", numeroBanos=" + numeroBanos + ", id=" + id + ", area=" + area + ", direccion="
				+ direccion + ", precioVenta=" + precioVenta + "]";
	}

//	METODO
	public double calcularPrecioVenta() {
		return area*VALOR_AREA;
	}	
	
}
