package test7;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import buscarLetras.UtilidadesFicheros;

public class Principal {

	private static String Extension_Resultados = ".res";
	
	public static void main(String[] args) throws IOException {

		String palabraBuscar	="rabo";
		String nombreFichero	="C:\\Users\\DAM2\\Desktop\\Pepe\\procesos\\nombres.txt";
		int numPalabra=0;

		ArrayList<String> lineas = UtilidadesFicheros.getLineasFichero(nombreFichero);
		
		for(String linea : lineas) {
			if(linea.contains(palabraBuscar)) {
				numPalabra++;
			}
		}
		
		PrintWriter pw;
		
		pw=UtilidadesFicheros.getPrintWriter(nombreFichero+Extension_Resultados);
		pw.println(nombreFichero + " : " + palabraBuscar + " : " + numPalabra);
		pw.close();
		System.out.println(numPalabra);
	}
}
