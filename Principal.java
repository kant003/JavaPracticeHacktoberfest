public class principal {
    public static void main (String [] args ) {
        String adios = "Adios mundo";
        System.out.println(adios);
        System.out.println(modificacion(adios));

    }

    public static String modificacion ( String hola ) {
        hola = "Hola mundo mejor";
        return hola;
    }
}
