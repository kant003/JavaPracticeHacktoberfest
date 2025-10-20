package Reisen;

public class planeta {
public enum plansisol{
	MERCURIO,
	VENUS,
	MARTE,
	JUPITER,
	URANO,
	NEPTUNO,
}
public enum DS{
	LUNES,
	MARTES,
	MIERCOLES,
	JUEVES,
	VIERNES,
	SABADO,
	DOMINGO,
	
}
public enum mes{
	ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO,
	AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE, DICIEMBRE,
}
private String nombre= null;
private int Cantsat=0;
private double masa=0;
private double volumen=0;
private int diametro=0;
private int disol=0;
public static long distsol=0;
public enum tipo{
	GASEOSO,
	TERRESTRE,
	ENANO
}
private tipo tipop;

private boolean obsr=false;

public planeta(String nombre, int cantsat, double masa, double volumen, int diam, int disol, tipo tipop,
		boolean obsr) {
	this.nombre = nombre;
	Cantsat = cantsat;
	this.masa = masa;
	this.volumen = volumen;
	this.diametro = diam;
	this.disol = disol;
	this.tipop = tipop;
	this.obsr = obsr;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public int getCantsat() {
	return Cantsat;
}

public void setCantsat(int cantsat) {
	Cantsat = cantsat;
}

public double getMasa() {
	return masa;
}

public void setMasa(double masa) {
	this.masa = masa;
}

public double getVolumen() {
	return volumen;
}

public void setVolumen(double volumen) {
	this.volumen = volumen;
}

public int getDiametro() {
	return diametro;
}

public void setDiametro(int diametro) {
	this.diametro = diametro;
}

public int getDisol() {
	return disol;
}

public void setDisol(int disol) {
	this.disol = disol;
}

public tipo getTipop() {
	return tipop;
}

public void setTipop(tipo tipop) {
	this.tipop = tipop;
}

public boolean isObsr() {
	return obsr;
}

public void setObsr(boolean obsr) {
	this.obsr = obsr;
}

@Override
public String toString() {
	return "planeta [nombre=" + nombre + ", Cantsat=" + Cantsat + ", masa=" + masa + ", volumen=" + volumen
			+ ", diametro=" + diametro + ", disol=" + disol + ", tipop=" + tipop + ", obsr=" + obsr + "]";
}

public double dens(){
	return this.masa/this.volumen;
}
public boolean extr() {
	boolean fuera=false;
	double aux=this.disol/distsol;
	if(aux<2.1)
		return fuera;
	if(aux>3.4) {
		fuera=true;
	}
		return fuera;
	
}






}
