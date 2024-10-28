package Herencia2_Inmueble;

public class Casa_Independiente extends Casa_Urbana {

	public static int VALOR_AREA = 3000;

//	SETTERS Y GETTERS
	public Casa_Independiente(int id, int area, String direccion, int num_habitaciones, int num_baños, int pisos) {
		super(id, area, direccion, num_habitaciones, num_baños, pisos);
		this.VALOR_AREA = VALOR_AREA;
	}

	public static int getVALOR_AREA() {
		return VALOR_AREA;
	}

	public static void setVALOR_AREA(int vALOR_AREA) {
		VALOR_AREA = VALOR_AREA;
	}

//	TO STRING
	@Override
	public String toString() {
		return "Casa_Independiente [numeroPisos=" + numeroPisos + ", numeroHabitaciones=" + numeroHabitaciones
				+ ", numeroBanos=" + numeroBanos + ", id=" + id + ", area=" + area + ", direccion=" + direccion
				+ ", precioVenta=" + precioVenta + "]";
	}
	
//	METODO
	public double calcularPrecioVenta() {
		return area*VALOR_AREA;
	}	

}
