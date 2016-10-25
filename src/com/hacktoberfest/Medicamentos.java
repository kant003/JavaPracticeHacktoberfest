package Ejercicio5;
import java.io.Serializable;
import java.util.Date;
public class Medicamentos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nombre;
	String lote;
	Date caducidad;
	double precio;
	double IVA;
	String laboratorio;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public Date getCaducidad() {
		return caducidad;
	}
	public void setCaducidad(Date caducidad) {
		this.caducidad = caducidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getIVA() {
		return IVA;
	}
	public void setIVA(double iVA) {
		IVA = iVA;
	}
	public String getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
	public Medicamentos(String nombre, String lote, Date caducidad, double precio, double iVA, String laboratorio) {
		super();
		this.nombre = nombre;
		this.lote = lote;
		this.caducidad = caducidad;
		this.precio = precio;
		IVA = iVA;
		this.laboratorio = laboratorio;
	}
	public Medicamentos() {
		super();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombre+" "+lote+" "+caducidad.getDay()+"/"+caducidad.getMonth()+"/"+caducidad.getYear()+" "+precio+" "+IVA+" "+laboratorio;
	}
}
