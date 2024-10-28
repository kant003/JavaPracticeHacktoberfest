package Herencia2_Inmueble;

public class Casa_Rural extends Casa{

	public static int VALOR_AREA = 1500;
	protected float distanciaCabecera ;
	protected float altitud ;
	
	public Casa_Rural(int id, int area, String direccion, int num_habitaciones, int num_baños, int pisos,
			float distanciaCabecera, float altitud) {
		super(id, area, direccion, num_habitaciones, num_baños, pisos);
		this.VALOR_AREA = VALOR_AREA;
		this.distanciaCabecera = distanciaCabecera;
		this.altitud = altitud;
	}

//	GETTERS Y SETTERS
	public static int getVALOR_AREA() {
		return VALOR_AREA;
	}

	public float getDistanciaCabecera() {
		return distanciaCabecera;
	}

	public float getAltitud() {
		return altitud;
	}

	public static void setVALOR_AREA(int vALOR_AREA) {
		VALOR_AREA = vALOR_AREA;
	}

	public void setDistanciaCabecera(float distanciaCabecera) {
		this.distanciaCabecera = distanciaCabecera;
	}

	public void setAltitud(float altitud) {
		this.altitud = altitud;
	}

//	TO STRING
	@Override
	public String toString() {
		return "Casa_Rural [distanciaCabecera=" + distanciaCabecera + ", altitud=" + altitud + ", numeroPisos="
				+ numeroPisos + ", numeroHabitaciones=" + numeroHabitaciones + ", numeroBanos=" + numeroBanos + ", id="
				+ id + ", area=" + area + ", direccion=" + direccion + ", precioVenta=" + precioVenta + "]";
	}
	
	
//	METODO
	public double calcularPrecioVenta() {
		return area*VALOR_AREA;
	}	
	
}
