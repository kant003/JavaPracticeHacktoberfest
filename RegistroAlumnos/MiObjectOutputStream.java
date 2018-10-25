package Ejercicio2JuanJPuertas;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/* la clase MiObjectOuputStream quedaría con los siguientes métodos*/
public class MiObjectOutputStream extends ObjectOutputStream {

	//Constructor sin parámetros
	protected MiObjectOutputStream() throws IOException, SecurityException {
		super();

	}

	//Constructor que recibe como parámetro un objeto OutputStream
	public MiObjectOutputStream(OutputStream out) throws IOException {
		super(out);

	}

	/*redefinición del método que escribe la cabecera para que no haga
	nada en caso de que el fichero ya tenga datos
	 */
	protected void writeStreamHeader(){

	}

}
