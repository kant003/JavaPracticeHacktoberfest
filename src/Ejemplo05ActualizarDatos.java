package ejemplo01DB4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

// El siguiente ejemplo modifica la ciudad de Isabel a Cádiz y luego visualiza sus datos:
public class Ejemplo05ActualizarDatos {

	final static String BDPersona = "D:\\Ciclos Formativos\\CSDAMultiplataforma\\AccesoDatosActual"
			+ "\\UD02BD4o\\BDPersonas.yap";


	public static void main(String[] args) {
		ObjectContainer db =
				Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPersona);
		//Recuperar todos los objetos con nombre Isabel
		
		Persona per = new Persona("Isabel", null);
		ObjectSet <Persona> resul = db.queryByExample(per);
		if(resul.size() == 0)
			System.out.println("No existe Isabel");
		else{
			Persona existe = (Persona) resul.next();
			existe.setCiudad("Cádiz");
			//escribimos en la base de datos
			db.store(existe); //ciudad modificada
			// consultar los datos
			resul = db.queryByExample(per);
			existe = resul.next();
			System.out.println("Nombre: "+existe.getNombre() +"\tCiudad: "
					+existe.getCiudad());
		}// fin else
		//cerrar la base de datos
		db.close();
	}// fin main
}


