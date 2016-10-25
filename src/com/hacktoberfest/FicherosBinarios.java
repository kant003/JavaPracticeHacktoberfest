package com.hacktoberfest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStreamReader;




public class FicherosBinarios {

	//Creamos o abrimos el archivo
	static File archivo = new File("FicheroBinario.dat");
	private static DataInputStream dis;


	public static void escribir(){
		

		try {
			//Abrimos la escritura binaria y con true dejamos seguir escribiendo cosas luego de acabar
			FileOutputStream fw = new FileOutputStream(archivo,true);
			//Abrimos el buffer para optimizar la escritura
			BufferedOutputStream bw = new BufferedOutputStream(fw);
			//Abrimos el data para tener opcion aescribir en varios estilos de datos
			DataOutputStream dat = new DataOutputStream(bw);
			//Abrimos el bufferedreader para leer el scanner
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			//Leemos el scanner y escribimos sus respectivos datos 
			System.out.println("Introduzca una nuevo codigo: ");
			int codigo = Integer.parseInt(br.readLine());
			dat.writeInt(codigo);
			
			System.out.println("Introduzca una nueva linea: ");
			String linea = br.readLine();
			dat.writeUTF(linea);

			//refrescamos y cerramos el data para que guarde los cambios
			dat.flush();
			dat.close();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		menu();	
	}


	public static void leer(){
		//Aqui abrimos o creamos el fichero de texto

			//Abrir el input para leer el archivo
			FileInputStream fr;
			try {
				fr = new FileInputStream(archivo);
			//optimizamos con un buffer y abrimos el data para acceder a diferentes tipos de datos
			BufferedInputStream br = new BufferedInputStream(fr);
			dis = new DataInputStream(br);

			
				if(archivo.exists()){
					try{
						
						try { 
							//con esto leemos todo el fichero, capturando la excepcion eof abajo
				            while(true){
				            	System.out.print(dis.readInt());
				            	System.out.print("     ");
				                System.out.println(dis.readUTF());
				            }
				        }catch (EOFException e) {
				           
				        } 
						}catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}




				}
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		menu();

	}	


	private static void buscar() {
		//Aqui abrimos o creamos el fichero de texto

		FileInputStream fr;
		try {
			fr = new FileInputStream(archivo);
		
		BufferedInputStream br = new BufferedInputStream(fr);
		DataInputStream dis = new DataInputStream(br);
		
		BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));

		int cod = 0;
		System.out.println("Introduzca el codico por el que desea buscar: ");
		try {
			cod=Integer.parseInt(bi.readLine());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			if(archivo.exists()){
				try{
					
					try {
						while(true){
							int codigo=dis.readInt();
							String nombre=dis.readUTF();
							if(cod==codigo){
								System.out.print(codigo);
								System.out.print("     ");
								System.out.println(nombre);
							}
						}
						
					}catch (EOFException e) {
						
					} 
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					dis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	menu();
	}	


	private static void borrar() {
		archivo.delete();
		menu();
	}



	private static void menu(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caso = 0;

		System.out.println("Que desea hacer: Leer(1), Escribir(2), Buscar(3), Editar(4), Borrar(5), Salir(6)");
		try {
			caso= Integer.parseInt(br.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		switch(caso){
		case 1:leer();
		break;

		case 2:escribir();
		break;

		case 3:buscar();
		break;

		//case 4:editar();
		//break;

		case 5:borrar();
		break;

		case 6:System.exit(0);
		}

	}


	public static void main(String[]args){

		menu();

	}

}

