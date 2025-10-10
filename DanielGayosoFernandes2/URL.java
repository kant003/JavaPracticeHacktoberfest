package org.example;

import java.io.*;
import java.net.*;

public class URL {
    public static void main(String[] args) {
        try {
            // Crear el objeto URL con la dirección del recurso en el servidor
            URL url = new URL("http://localhost/vernombre.php");

            // Abrir la conexión con la URL
            URLConnection conexion = url.openConnection();

            // Permitir enviar datos por la conexión(modo POST)
            conexion.setDoOutput(true);

            String cadena = "nombre=Maria Jesus&apellidos=Ramos Martin";

            //ESCRIBIR EN LA URL
            // Abrir un flujo de salida para enviar los datos VOY A ESCRIBIR
            PrintWriter output = new PrintWriter(
                    conexion.getOutputStream());
            output.write(cadena);
            output.close(); //cerrar flujo de salida

            //LEER DE LA URL
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conexion.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            reader.close(); //cerrar flujo

        } catch (MalformedURLException me) {
            System.err.println("MalformedURLException: " + me);
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe);
        }
    } //main
} //Ejemplo2urlCon