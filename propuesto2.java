package Reisen;

public class propuesto2 {
int numero;

propuesto2(int num){
	this.numero=num;
}

public int getNumero() {
	return numero;
}

public void setNumero(int numero) {
	this.numero = numero;
}

@Override
public String toString() {
	return "propuesto2 [numero=" + numero + "]";
}
public int doble() {
return 2*this.numero;

}
public int triple() {
return 3*this.numero;
}
public int cuad() {
return 2*doble();
}

public void aniade(int tremendo) {
	this.numero+=tremendo;
}
public void resta(int parametro) {
	this.numero-=parametro;
}


}
