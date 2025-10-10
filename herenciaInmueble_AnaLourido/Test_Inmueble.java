package Herencia2_Inmueble;

import java.util.ArrayList;

import Herencia1_Libro.Libro;
import Herencia2_Inmueble.Inmueble_Local.tipo;

public class Test_Inmueble {
	
	public static int generaArea() {
		return (int) (30 + Math.random() * 120);
	}
	
	public static void main(String[] args) {
		
		ArrayList<Inmueble> col = new ArrayList<>();
		
		Inmueble casa1 = new Casa_Rural(1, generaArea(), "Calle Uno, Nº1", 4, 3, 2, 34, 333);
		col.add(casa1);
		
		Inmueble apartamento1 = new Apartamento_Familiar(45, generaArea(), "Calle Dos, nº2", 4, 2, 456);
		col.add(apartamento1);
		
		Inmueble apartamento2 = new Apartaestudio(2, generaArea(), "Calle Rosalia, Nº2", 1, 1, 3);
		col.add(apartamento2);
		
		Inmueble casa2 = new Casa_ConjuntoCerrado(54, generaArea(), "Calle Tres, Nº3", 4, 1, 4, 567, 1, false);
		col.add(casa2);
		
		Inmueble casa3 = new Casa_Independiente(6, generaArea(), "Calle Cuatro, Nº4", 4, 2, 1);
		col.add(casa3);
		
		Inmueble local1 = new Local_Comercial(7, generaArea(), "Calle Cinco, Nº5", tipo.INTERNO, "Travesia");
		col.add(local1);
		
		Inmueble oficina1 = new Oficina(55, generaArea(), "Calle Seis, Nº6", tipo.CALLE, true);
		col.add(oficina1);
		
		double precio = 0d;
		
		for(Inmueble c : col) {
			System.out.println("\n"+c.toString());
			double p = c.calcularPrecioVenta();
			System.out.println("Pecio :"+p+" €");
			precio+=p;
		}
		
		System.out.println("\n--------------TIKECT DE INMUEBLE--------------");
		System.out.println("\n Precio de todos = "+ precio+" €");
		System.out.println("\n IVA (21%) "+ 0.21*precio+" €");
		System.out.println();
		System.out.println("\n	PAGO FINAL "+1.21*precio+" €");
		System.out.println("\n----------------------------------------------");
		
	}

}
