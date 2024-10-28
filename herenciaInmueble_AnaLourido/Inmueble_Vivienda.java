package Herencia2_Inmueble;

public class Inmueble_Vivienda extends Inmueble{
	
	protected int numeroHabitaciones;
	protected int numeroBanos;
	
	public Inmueble_Vivienda(int id, int area, String direccion, int num_habitaciones, int num_baños) {
		super(id, area, direccion);
		this.numeroHabitaciones = num_habitaciones;
		this.numeroBanos = num_baños;
	}
	
//	GETTERS Y SETTERS
	public int getNum_habitaciones() {
		return numeroHabitaciones;
	}

	public int getNum_baños() {
		return numeroBanos;
	}

	public void setNum_habitaciones(int numeroHabitaciones) {
		this.numeroHabitaciones = numeroHabitaciones;
	}

	public void setNum_baños(int numeroBanos) {
		this.numeroBanos = numeroBanos;
	}

	@Override
	public String toString() {
		return "Inmueble_Vivienda [numeroHabitaciones=" + numeroHabitaciones + ", numeroBanos=" + numeroBanos + ", id="
				+ id + ", area=" + area + ", direccion=" + direccion + "]";
	}

}
