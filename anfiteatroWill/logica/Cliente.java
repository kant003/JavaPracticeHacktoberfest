package logica;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private int id;
	private String dni;
	private String nombre;
	private String apellido;
	//private List<ticket> listaTickets;
	private List<ticket> listaTickets = new ArrayList<>();

	
	public Cliente() {
	
	}




	public Cliente(int id, String dni, String nombre, String apellido, List<ticket> listaTickets) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.listaTickets = listaTickets;
	}




	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}


	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}


	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	/**
	 * @return the listaTickets
	 */
	public List<ticket> getListaTickets() {
		return listaTickets;
	}




	/**
	 * @param listaTickets the listaTickets to set
	 */
	public void setListaTickets(List<ticket> listaTickets) {
		this.listaTickets = listaTickets;
	}




	@Override
	public String toString() {
		return "Cliente [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	
	
	
	
	
}
