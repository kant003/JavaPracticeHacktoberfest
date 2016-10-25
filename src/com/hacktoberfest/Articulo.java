package examen01A;

import java.io.Serializable;

public class Articulo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String descripcion;
	double pvp;
	int stock;
	int stockMinimo;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPvp() {
		return pvp;
	}

	public void setPvp(double pvp) {
		this.pvp = pvp;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public Articulo() {
		super();
	}

	public Articulo(String descripcion, double pvp, int stock, int stockMinimo) {
		super();
		this.descripcion = descripcion;
		this.pvp = pvp;
		this.stock = stock;
		this.stockMinimo = stockMinimo;
	}

	@Override
	public String toString() {
		return "descripción: " + descripcion + ", pvp= " + pvp + ", stock= " + stock + ", stockMinimo= " + stockMinimo;
	}

}
