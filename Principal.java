public principal {
    public static void main (String [] args ) {
        String adios = "Adios mundo";
        System.out.println(adios);
        modificacion(adios);
        System.out.println(adios);

    }

    public void modificacion ( String hola ) {
        hola = "Hola mundo mejor";
    }
}