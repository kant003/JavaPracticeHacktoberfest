package Javacosas;

public class Persona {
    // atributos
    private String nombre;

    private String apellido;

    private String dni;

    private int ano;

    // constructor por defecto
    Persona() {
        this.nombre = "";
        this.apellido = "";
        this.dni = "";
        this.ano = 0;

    }

    // Constructor con todos los parámetros
    public Persona(String nombre, String apellido, String dni, int ano) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.ano = ano;
    }

    // Métdos: Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    // To string
    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", ano=" + ano + "]";
    }

}
