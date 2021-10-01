import java.awt.Color;
/**
 * Consiste en un objeto llamado coche en el que tiene unas ciertas caracteristicas y acciones.
 * @author Cora
 *
 */
class Coche{
	
//ATRIBUTOS
/**
 * La velocidad en la que este el coche en ese momento	
 */
float velocidad;
/**
 * 	
 */
int np;
/**
 * El color del coche 	
 */
Color c;

//MÉTODOS
/**
 * Establece unos valores por defecto a todos sus atributos
 */

Coche(){
	velocidad=0;
	np=4;
	c=Color.RED;
}
/**
 * Establecer valores a los atributos del coche
 * @param velocidad establece la velocidad del coche
 * @param np establece el np del coche
 * @param c establece el color del coche
 */
Coche(float velocidad, int np, Color c){
	this.velocidad=velocidad;
	this.np=np;
	this.c=c;
}
/**
 * Devuelve la velocidad del coche
 * @return la velocidad del coche
 */
public float getVelocidad() {
	return velocidad;
}

/**
 * Devuelve el np del coche
 * @return el np del coche
 */
public int getNp() {
	return np;
}
/**
 * Establece el np del coche
 * @return el np del coche
 */
public void setNp(int np) {
	this.np = np;
}
/**
 * Devuelve el color del coche
 * @return el color del coche
 */
public Color getC() {
	return c;
}
/**
 * Establece el np del coche
 * @return el np del coche
 */
public void setC(Color c) {
	this.c = c;
}

/**
 * Establece una nueva velocidad al coche 
 * @param nuevaVel la nueva velocidad introducida
 */
public void acelerar(float nuevaVel) {
velocidad = nuevaVel;
}
/**
 * Indica si esta en movimiento
 * @return true si la velocidad es mayor a 0 y false en caso contrario
 */
public boolean moviendose() {
return velocidad > 0;
}
/**
 * Establece la velocidad en 0
 */
public void pararCoche() {
velocidad=0;
}

}
