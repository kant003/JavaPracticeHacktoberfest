package com.hacktoberfest;
/*Segundo ejemplo de creación de objetos, esta vez con un triángulo */

public class Triangulo {
	private double base;
	private double altura;
	
	public Triangulo(){super();}
	
	public double getBase(){return base;}
	public void setBase(final double base){this.base = base;}
	
	public double getAltura(){return altura;}
	public void setAltura(final double altura){this.altura = altura;}
	
	public boolean comprobarLado(final int lado){
		if(lado < 0){return true;}
		else{return false;}
	}
	
	public double getAreaTriangulo(){return base * altura /2;}
	
}
