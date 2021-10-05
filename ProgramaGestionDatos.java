
import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Escribir un programa que solicite el nombre de un cliente, su teléfono, su
 * fecha de nacimiento, y si es hombre o mujer. Hay que guardar estos datos en
 * variables y después hay que mostrar un texto de saludo personalizado: (Sr.
 * Juan Perez, nacido en 2000-08-23)
 *
 * @author Pedro
 */
public class ProgramaGestionDatos {

  static String nombreCliente;
  static int telefono;
  static LocalDate fechaNacimiento;

  public static void main(String[] args) {
    solicitarDatosCliente();
    mostrarTextoDeSaludo();
  }

  private static void solicitarDatosCliente() {
    System.out.println("Se asignan los datos...");
    nombreCliente = "Juan Pérez";
    telefono = 1234587;
    fechaNacimiento = LocalDate.parse("2000-01-01");
  }

  private static void mostrarTextoDeSaludo() {
    System.out.println("Se muestran los datos...");
     System.out.println(nombreCliente);
     System.out.println(telefono);
     System.out.println(fechaNacimiento);
  }

}
