package SAX;

import java.io.IOException;

import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Ejemplo {

	public static void main(String[] args) {
		
		try {
			XMLReader lectorXML = XMLReaderFactory.createXMLReader();
			
			GestionContenido gestor = new GestionContenido();
			
			lectorXML.setContentHandler((ContentHandler) gestor);
			
			InputSource fichero = new InputSource("archivo1.xml"); 
			
			
			lectorXML.parse(fichero);
	
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
