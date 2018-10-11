package Ejercicio2JuanJPuertas;

import java.io.Serializable;

public class Alumno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private int notaAccesoDatos;
	private int notaInterFaces;
	private int notaMultimedia;
	private int notaServicios;
	private int notaSistemaGestion;
	private int notaEmpresa;
	
	
	
	public Alumno() {
		super();
	}
	public Alumno(String nombre, int notaAccesoDatos, int notaInterFaces, int notaMultimedia, int notaServicios,
			int notaSistemaGestion, int notaEmpresa) {
		super();
		this.nombre = nombre;
		this.notaAccesoDatos = notaAccesoDatos;
		this.notaInterFaces = notaInterFaces;
		this.notaMultimedia = notaMultimedia;
		this.notaServicios = notaServicios;
		this.notaSistemaGestion = notaSistemaGestion;
		this.notaEmpresa = notaEmpresa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNotaAccesoDatos() {
		return notaAccesoDatos;
	}
	public void setNotaAccesoDatos(int notaAccesoDatos) {
		this.notaAccesoDatos = notaAccesoDatos;
	}
	public int getNotaInterFaces() {
		return notaInterFaces;
	}
	public void setNotaInterFaces(int notaInterFaces) {
		this.notaInterFaces = notaInterFaces;
	}
	public int getNotaMultimedia() {
		return notaMultimedia;
	}
	public void setNotaMultimedia(int notaMultimedia) {
		this.notaMultimedia = notaMultimedia;
	}
	public int getNotaServicios() {
		return notaServicios;
	}
	public void setNotaServicios(int notaServicios) {
		this.notaServicios = notaServicios;
	}
	public int getNotaSistemaGestion() {
		return notaSistemaGestion;
	}
	public void setNotaSistemaGestion(int notaSistemaGestion) {
		this.notaSistemaGestion = notaSistemaGestion;
	}
	public int getNotaEmpresa() {
		return notaEmpresa;
	}
	public void setNotaEmpresa(int notaEmpresa) {
		this.notaEmpresa = notaEmpresa;
	}
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", notaAccesoDatos=" + notaAccesoDatos + ", notaInterFaces="
				+ notaInterFaces + ", notaMultimedia=" + notaMultimedia + ", notaServicios=" + notaServicios
				+ ", notaSistemaGestion=" + notaSistemaGestion + ", notaEmpresa=" + notaEmpresa + "]";
	}
	
	public Float notaMedia() {
		return (float) (notaAccesoDatos+notaInterFaces+notaMultimedia+notaServicios+notaSistemaGestion+notaEmpresa)/6;
	}
	
}
