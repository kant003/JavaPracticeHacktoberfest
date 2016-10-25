package com.hacktoberfest;
import java.io.*;
import java.util.Scanner;
 
//Realiza un programa en JAVA en el quemuestres un menú que te permita 3
//opciones:
//1. Volcado de un array con los 100 primeros números pares a un fichero de texto. El
//nombre del fichero lo elegirá el usuario.
//2. Mostrar por pantalla el contenido del fichero de texto creado.
//3. Salir del Programa.

public class Ejercicio02Tema08 {
    static String nombre;
 
    public static void mostrarMenu() {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        do {
 
        System.out.println("1.- Crear fichero");
        System.out.println("2.- Mostrar Fichero");
        System.out.println("3.- Salir");
 
        opcion = teclado.nextInt();
 
        switch (opcion){
            case 1 : {
                crearFichero();
                break;
            }
            case 2 : {
                mostrarFichero();
                break;
            }
            case 3 : {
                System.out.println("Gracias por usar el Programa");
                break;
            }
            default:{
                System.out.println("Opcion no Valida");
            }
        }
 
        } while (opcion != 3);
    }
 
    public static String elegirNombre() {
        Scanner teclado = new Scanner(System.in);
 
 
        System.out.println("Introduce el nombre del Archivo");
        nombre = teclado.nextLine();
        return nombre;
 
    }
    public static String devolverNombre() {
        return nombre;
    }
 
    public static void crearFichero() {
 
        FileWriter fw = null;
        try {
            fw = new FileWriter(elegirNombre() + ".txt");
            PrintWriter pw = new PrintWriter(fw);
            escribirFicheo(pw);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void escribirFicheo(PrintWriter pw) throws Exception{
        for (int i = 0; i < 100; i++) {
 
            if (i % 2 == 0 ) {
                pw.println(i);
            }
 
        }
    }
 
    public static void mostrarFichero() {
        FileReader fr = null;
        try {
            File fichero = new File(devolverNombre()+ ".txt");
            fr = new  FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            leerFichero(br);
        } catch (Exception e) {
            System.out.println(e.getMessage());
 
        }finally{
 
                if (fr != null) {
                    try {
                        fr.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
 
                }
 
            }
 
    }
    public static void leerFichero(BufferedReader br)throws Exception{
        String linea;
        linea = br.readLine();
        while (linea != null) {
            System.out.println(linea);
            linea = br.readLine();
        }
    }
    public static void main(String[] args) {
        mostrarMenu();
    }
 
}