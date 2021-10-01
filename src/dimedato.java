import java.util.Scanner;

public class dimedato {

	public static void main(String[] args) {

	String dato="La lengua se está moviendo todo el día. Se expande, se contrae, se aplana, se vuelve a contraer. Al final del día, lo más probable es que la lengua haya hecho varios miles de movimientos.";
	int boton;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Pulsa 5 para ver un dato curioso");
	boton = sc.nextInt();

	if(boton == 5){
	System.out.println(dato);
  	} else {
	System.out.println("No has pulsado 5");
  }
 }
}