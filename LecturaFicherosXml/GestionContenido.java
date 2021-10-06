package SAX;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class GestionContenido extends DefaultHandler {

	public GestionContenido() {
		super();
	}
	
	public void startDocument() {
		System.out.println("Principio de documento: ");
	}
	
	public void endDocument() {
		System.out.println("Final de documento: ");
	}
	
	public void startElement(final String url, final String nombre, final String nombrec, final Attributes atributo) {
		System.out.println("Comienza el elemento: ");
	}
	
	public void endElement(final String url, final String nombre, final String nombrec) {
		System.out.println("Termina el elemento: ");
	}

	public void characters(final char[] ch, final int inicio, final int longitud) {
		String car = new String(ch, inicio, longitud);
		car = car.replaceAll("[\t\n]", "");
		System.out.println("Valor: "+car);
	}


}