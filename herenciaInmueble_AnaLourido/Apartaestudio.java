package Herencia2_Inmueble;

public class Apartaestudio extends Apartamento{
	
	public static int VALOR_AREA = 1500;
	
	public Apartaestudio(int id, int area, String direccion, int num_habitaciones, int num_baños, int VALOR_AREA) {
		super(id, area, direccion, num_habitaciones, num_baños);
		this.VALOR_AREA = VALOR_AREA;
	}

//	SETTERS Y GETTERS
	public static int getVALOR_AREA() {
		return VALOR_AREA;
	}

	public static void setVALOR_AREA(int vALOR_AREA) {
		VALOR_AREA = vALOR_AREA;
	}

//	TO STRING
	@Override
	public String toString() {
		return "Apartaestudio [numeroHabitaciones=" + numeroHabitaciones + ", numeroBanos=" + numeroBanos + ", id=" + id
				+ ", area=" + area + ", direccion=" + direccion + ", precioVenta=" + precioVenta + "]";
	}
	
//	METODO
	public double calcularPrecioVenta() {
		return area*VALOR_AREA;
	}	

}
