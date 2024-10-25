package Herencia2_Inmueble;

public class Apartamento extends Inmueble_Vivienda{
	
	public Apartamento(int id, int area, String direccion, int num_habitaciones, int num_baños) {
		super(id, area, direccion, num_habitaciones, num_baños);
		
	}

	@Override
	public String toString() {
		return "Apartamento [numeroHabitaciones=" + numeroHabitaciones + ", numeroBanos=" + numeroBanos + ", id=" + id
				+ ", area=" + area + ", direccion=" + direccion + ", precioVenta=" + precioVenta + "]";
	}
	
	
}
