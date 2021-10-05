package ejercicios.ej6;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Principal {
	private static final long tamanhoRegistro = 90;

	public static void main(final String[] args) {

		try {

			File fichero = new File ("C:\\Users\\DAM2\\Desktop\\Bea\\Libros.txt");
			String libro, autor, cantidad, precio;
			int clave = 1;
			long posicion = 0;

			RandomAccessFile raf = new RandomAccessFile(fichero, "rw");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			DOMImplementation implementacion = db.getDOMImplementation();
			Document documento = implementacion.createDocument(null, "Libros", null);
			documento.setXmlVersion("1.0");


			for(;;){
				raf.seek(posicion);
				libro=raf.readUTF();
				autor=raf.readUTF();
				cantidad=raf.readUTF();
				precio=raf.readUTF();


				if(clave > 0){

					Element raiz = documento.createElement("Libro");
					documento.getDocumentElement().appendChild(raiz);
					CrearElemento("clave", Integer.toString(clave),raiz,documento);
					CrearElemento("Libro", libro,raiz,documento);
					CrearElemento("Autor", autor,raiz,documento);
					CrearElemento("Cantidad", cantidad,raiz,documento);
					CrearElemento("Precio", precio,raiz,documento);
					
					clave++;
				}
				posicion = posicion+tamanhoRegistro;

				if(raf.getFilePointer() == raf.length())	
					break;
			}
			
			
			Source fuente = new DOMSource(documento);
			Result resultado = new StreamResult(new java.io.File("C:\\Users\\DAM2\\Desktop\\Bea\\Libros.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(fuente, resultado);
			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ParserConfigurationException e) {
			e.printStackTrace();
		}catch(TransformerException e) {
			e.printStackTrace();
		}finally {
			System.out.println("Terminado");
		}
	}

	static void CrearElemento(final String datoPersona, final String valor, final Element raiz, final Document documento){
		Element elemento = documento.createElement(datoPersona);
		Text texto = documento.createTextNode(valor);
		raiz.appendChild(elemento);
		elemento.appendChild(texto);
	}
}
