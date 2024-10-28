package Herencia2_Inmueble;

public class Oficina extends Inmueble_Local{
		
	public static int VALOR_AREA = 3500;
	protected boolean esGobierno;
	
	public Oficina(int id, int area, String direccion, tipo localizacion, boolean esGobierno) {
		super(id, area, direccion, localizacion);
		this.VALOR_AREA = VALOR_AREA;
		this.esGobierno = esGobierno;
	}

//	GETTERS Y SETTERS
	public double getVALOR_AREA() {
		return VALOR_AREA;
	}

	public boolean isEsGobierno() {
		return esGobierno;
	}

	public void setVALOR_AREA(int VALOR_AREA) {
		this.VALOR_AREA = VALOR_AREA;
	}

	public void setEsGobierno(boolean esGobierno) {
		this.esGobierno = esGobierno;
	}

//	TO STRING
	@Override
	public String toString() {
		return "Oficina [valorArea=" + VALOR_AREA + ", esGobierno=" + esGobierno + ", localizacion=" + localizacion
				+ ", id=" + id + ", area=" + area + ", direccion=" + direccion + ", precioVenta=" + precioVenta + "]";
	}
	
//	METODO
	public double calcularPrecioVenta() {
		return area*VALOR_AREA;
	}	

}
