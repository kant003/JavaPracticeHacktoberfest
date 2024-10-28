package Herencia2_Inmueble;

public class Casa extends Inmueble_Vivienda{
	
	protected int numeroPisos;
	
	public Casa(int id, int area, String direccion, int num_habitaciones, int num_baños, int pisos) {
		super(id, area, direccion, num_habitaciones, num_baños);
		this.numeroPisos = pisos;
	}

//	GETTERS Y SETTERS
	public int getNumeropisos() {
		return numeroPisos;
	}

	public void setNumeropisos(int numeroPisos) {
		this.numeroPisos = numeroPisos;
	}
	
//	TO STRING

	@Override
	public String toString() {
		return "Casa [numeroPisos=" + numeroPisos + ", numeroHabitaciones=" + numeroHabitaciones + ", numeroBanos="
				+ numeroBanos + ", id=" + id + ", area=" + area + ", direccion=" + direccion + ", precioVenta="
				+ precioVenta + "]";
	}
	
	

}
