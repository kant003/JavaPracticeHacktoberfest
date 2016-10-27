package com.hacktoberfest;

public class felipe {
	private char color;
	private int edad;
	
	
	public void setedad (int e) {edad=e;}
	public void printedad() {System.out.println(edad);}
	public void setcolor (char c) {color=c;}
	public void printcolor(){
			switch (color){
			case 'v': System.out.println("verde");break;
			case 'a': System.out.println("amarillo");break;
			case 'g': System.out.println("gris");break;
			case 'n': System.out.println("negro");break;
			case 'b': System.out.println("blanco");break;
			default: System.out.println("Color no establecido");break;
			}
	}
	public int getedad(){
		return edad;
	}
	public char getcolor(){
		return color;
	}
}
