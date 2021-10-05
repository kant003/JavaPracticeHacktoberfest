package enunciado01;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class enunciado01 {

	public static void main(String[] args )throws IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Pon un nombre para la carpeta: ");
		String nombreparalacarpeta=sc.next();
		
		File carpeta =new File("C:\\Users\\Equipo\\ejemplosficheros\\ejemplos\\"+nombreparalacarpeta);
		
		carpeta.mkdir();
		File f1= new File(carpeta,"Ejemplo1.txt");
		File f2= new File(carpeta,"Ejemplo2.txt");
		
		System.out.print("-------------------");
	
		System.out.print("-------------------");
		
	try {
			f1.createNewFile();
			f2.createNewFile();
			} catch (IOException e) {
			e.printStackTrace();
			}
		
			System.out.print("Pon un nombre para un fichero: ");
			if(f2.renameTo(new File(carpeta, sc.next())))

			System.out.println("El primer fichero ha cambiado de nombre");
			else
			System.out.println("No se ha podido cambiar de nombre");
			
			
			 f1.delete();
			 String[] lista=carpeta.list();
			System.out.println("Fin del programa");
			}
			}