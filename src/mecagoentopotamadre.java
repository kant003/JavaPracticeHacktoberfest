package interfaz2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ServicioCliente {
	
	
	private static void MostrarResponse(HttpResponse response) throws UnsupportedOperationException, IOException {
		InputStream is = response.getEntity().getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String linea="";
		while ((linea = br.readLine()) != null){
			System.out.println(linea);
		}
	}
	
	

	public static String GetAutenticToken(String email, String passwd){

		
		return null;
	}

	public static ArrayList<Cliente> GetAll() throws ClientProtocolException, IOException{
		
		HttpClient hc= HttpClientBuilder.create().build();
		HttpGet get = new HttpGet("https://clientes-44922.firebaseio.com/Clientes.json");
		HttpResponse resp = hc.execute(get);
		
		//MostrarResponse(resp);
		
		InputStreamReader reader= new InputStreamReader(resp.getEntity().getContent());
		Gson gson = new Gson();
		Type clientesType = new TypeToken <HashMap<String, Cliente>>(){}.getType();
		HashMap<String, Cliente> datos =  gson.fromJson(reader, clientesType);
		ArrayList <Cliente> listaClientes = new ArrayList<Cliente>();
		
		for(Entry<String, Cliente> entry:datos.entrySet()) {
			String clave = entry.getKey();
			Cliente cliente = entry.getValue();
			cliente.Id=clave;
			listaClientes.add(cliente);
		}
		
		
		return listaClientes;
	}
	
	

	public static int GetById(String idCliente){

		
		return 0;
	}
	
	

	public static int AddCliente(Cliente cliente){

		
		return 0;
	}
	
	

	public static int Delete(String idCliente){

		
		return 0;
	}
	
	

	public static int Update(String idCliente, Cliente nuevoCliente){

		
		return 0;
	}
}
