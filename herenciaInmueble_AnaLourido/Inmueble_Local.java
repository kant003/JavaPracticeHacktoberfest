package Herencia2_Inmueble;

public class Inmueble_Local extends Inmueble {

	public enum tipo {
		INTERNO, CALLE
	}

	protected tipo localizacion;

	public Inmueble_Local(int id, int area, String direccion, tipo localizacion) {
		super(id, area, direccion);
		this.localizacion = localizacion;
	}

//	SETTERS Y GETTERS
	public tipo getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(tipo localizacion) {
		this.localizacion = localizacion;
	}

//	TO STRING
	@Override
	public String toString() {
		return "Inmueble_Local [localizacion=" + localizacion + ", id=" + id + ", area=" + area + ", direccion="
				+ direccion + ", precioVenta=" + precioVenta + "]";
	}

}
