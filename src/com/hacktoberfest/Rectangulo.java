package com.hacktoberfest;
/*Pequeña clase Rectangulo que nos sirve como ejemplo de
 *creación de objetos*/

public class Rectangulo{
	private double base;
	private double altura;
	
	public Rectangulo(){}//Constructor vacío
	
	public Rectangulo(double base, double altura){//Constructor con los atributos del objeto
		super();
		this.base = base;
		this.altura = altura;
	}

	//Getters y setters que nos permiten darle valores a los parámetros, así como recogerlos
	public double getBase(){return base;}
	public void setBase(final double base) {this.base = base;}
	
	public double getAltura(){return altura;}
	public void setAltura(final double altura){this.altura = altura;}
	
	//Un pequeño método que nos comprueba que un lado es "posible"
	public boolean comprobarLado(final int lado){
		if(lado < 0){return true;}
		else{return false;}
	}
	
	//Getters del área y perímetro del rectángulo
	public double getAreaRectangulo(){return base*altura;}
	public double getPerimetroRectangulo(){return 2*base+2*altura;}
}

