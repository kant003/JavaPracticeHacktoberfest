
public class tempexec {
	
	public static void main(String[] args){
	
		long tiempoInicio = System.currentTimeMillis();
	
	ejecutaProceso1(); 
	// aqui llama al método que quiere calcular el tiempo de ejecución
	
	long totalTiempo = System.currentTimeMillis() - tiempoInicio;
	System.out.println("El tiempo de demora es :" + totalTiempo + " miliseg");
	}
	

static void ejecutaProceso1()
	{
	for (int i = 0; i < 100000000; i++) // en i < 1000 se le puede colocar un valor mayor
	{
	String cad = " Esto es ";
	cad += " una ";
	cad += " prueba ";
	System.out.println(" " + cad); // es por si se quiere imprimir lo que hay pero no es necesario
	}
}
}
