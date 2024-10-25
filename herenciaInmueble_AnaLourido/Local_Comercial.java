package Herencia2_Inmueble;

public class Local_Comercial extends Inmueble_Local{
		
	protected static int VALOR_AREA = 3000;
	
	protected String centroComercial;
	
	public Local_Comercial(int id, int area, String direccion, tipo localizacion, 
			String centroComercial) {
		super(id, area, direccion, localizacion);
		this.VALOR_AREA = VALOR_AREA;
		this.centroComercial = centroComercial;
	}

//	GETTERS Y SETTERS
	public double getVALOR_AREA() {
		return VALOR_AREA;
	}

	public String getCentroComercial() {
		return centroComercial;
	}

	public void setVALOR_AREA(int VALOR_AREA) {
		this.VALOR_AREA = VALOR_AREA;
	}

	public void setCentroComercial(String centroComercial) {
		this.centroComercial = centroComercial;
	}

// 	TO STRING
	@Override
	public String toString() {
		return "Local_Comercial [valorArea=" + VALOR_AREA + ", centroComercial=" + centroComercial + ", localizacion="
				+ localizacion + ", id=" + id + ", area=" + area + ", direccion=" + direccion + ", precioVenta="
				+ precioVenta + "]";
	}
	
//	METODO
	public double calcularPrecioVenta() {
		return area*VALOR_AREA;
	}
	
	

}
