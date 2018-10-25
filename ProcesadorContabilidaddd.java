package Ejercicio6;

import java.io.EOFException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ProcesadorContabilidad {

	public static void main(String[] args) throws IOException {
		
		//fichero a tratar
		String nombreFichero = args[0];
		//fichero de resultado
		String nombreFicheroResultado = args[1];
		
		ArrayList<String> cantidades;
		long total = 0;
		
		try {
			// Extraemos las cantidades
			cantidades = UtilidadesFicheros.getLineasFichero(nombreFichero);
			
			
			// Y las sumamos una por una
			for (String lineaCantidad : cantidades) {
				long cantidad = Long.parseLong(lineaCantidad);
				total = total + cantidad;
				// fin del for que recorre las cantidades
				
				
			}
			// Almacenamos el total en un fichero
			PrintWriter pw;
			pw = UtilidadesFicheros.getPrintWriter(nombreFicheroResultado);
			//ESCRIBO EL TOTAL EN UN FICHERO DE RESULTADOS
			pw.println(total);
			pw.close();
		} // fin del try
		catch (EOFException eofe) {
			System.err.println("FINAL DEL FICHERO " + nombreFichero);
			
		}
		catch (IOException e) {
			System.err.println("No se pudo procesar el fichero " + nombreFichero);
			e.printStackTrace();
		}
		// fin del main
	}

}
