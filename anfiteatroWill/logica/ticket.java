package logica;

import java.util.Date;

public class ticket {

	private int numero;
	private int fila;
	private int columna;
	private double precio;
	private Date fechaCompra;
	private Date fechaValidez;
	
	
	
	public ticket() {
		
	}

	public ticket(int numero, int fila, int columna, double precio, Date fechaCompra, Date fechaValidez) {
		this.numero = numero;
		this.fila = fila;
		this.columna = columna;
		this.precio = precio;
		this.fechaCompra = fechaCompra;
		this.fechaValidez = fechaValidez;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the fla
	 */
	public int getFila() {
		return fila;
	}

	/**
	 * @param fla the fla to set
	 */
	public void setFila(int fla) {
		this.fila = fla;
	}

	/**
	 * @return the columna
	 */
	public int getColumna() {
		return columna;
	}

	/**
	 * @param columna the columna to set
	 */
	public void setColumna(int columna) {
		this.columna = columna;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return the fechaCompra
	 */
	public Date getFechaCompra() {
		return fechaCompra;
	}

	/**
	 * @param fechaCompra the fechaCompra to set
	 */
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	/**
	 * @return the fechaValidez
	 */
	public Date getFechaValidez() {
		return fechaValidez;
	}

	/**
	 * @param fechaValidez the fechaValidez to set
	 */
	public void setFechaValidez(Date fechaValidez) {
		this.fechaValidez = fechaValidez;
	}

	@Override
	public String toString() {
		return "ticket [numero=" + numero + ", fila=" + fila + ", columna=" + columna + ", precio=" + precio
				+ ", fechaCompra=" + fechaCompra + ", fechaValidez=" + fechaValidez + "]";
	}
	
	
	
	
	
	
	
}
