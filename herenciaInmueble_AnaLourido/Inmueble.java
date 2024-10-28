package Herencia2_Inmueble;

public class Inmueble {

	protected int id;
	protected int area;
	protected String direccion;
	protected double precioVenta = 0d; // NO LO VEO, va a depender del tipo de inmueble que sea

//	CONSTRUCTOR
	public Inmueble(int id, int area, String direccion) {
		super();
		this.id = id;
		this.area = area;
		this.direccion = direccion;
	}

	// GETTERS Y SETTERS
	public int getId() {
		return id;
	}

	public int getArea() {
		return area;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

//	TO STRING 
	@Override
	public String toString() {
		return "Inmueble [id=" + id + ", area=" + area + ", direccion=" + direccion + ", precioVenta=" + precioVenta
				+ "]";
	}

//	METODOS

	public double calcularPrecioVenta() {
		return 0d;
	}

}
