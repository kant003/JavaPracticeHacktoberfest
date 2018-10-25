package testeoBBD2;

import java.util.ArrayList;

public class Granja {
	ArrayList<Cerdo> listaAnimales = new ArrayList<Cerdo>();
	public void add(Cerdo cerdo) {
		listaAnimales.add(cerdo);
		
	}
	public int getNumeroAnimales() {
		return listaAnimales.size();
		
	}

}
