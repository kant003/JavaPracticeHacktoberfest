package Herencia2_Inmueble;

public class Casa_Urbana extends Casa{

	public Casa_Urbana(int id, int area, String direccion, int num_habitaciones, int num_baños, int pisos) {
		super(id, area, direccion, num_habitaciones, num_baños, pisos);
	}

//	TO STRING
	@Override
	public String toString() {
		return "Casa_Urbana [numeroPisos=" + numeroPisos + ", numeroHabitaciones=" + numeroHabitaciones
				+ ", numeroBanos=" + numeroBanos + ", id=" + id + ", area=" + area + ", direccion=" + direccion
				+ ", precioVenta=" + precioVenta + "]";
	}
	
	

}
