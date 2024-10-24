public class coche {

    private String modelo;
    private String marca;
    private int numeroRuedas;
    private int numeroPuertas;
    private int velociadInicial = 0;

    public coche(String modelo, String marca, int numeroRuedas, int numeroPuertas) {

        this.modelo = modelo;
        this.marca = marca;
        this.numeroRuedas = numeroRuedas;
        this.numeroPuertas = numeroPuertas;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getNumeroRuedas() {
        return numeroRuedas;
    }

    public void setNumeroRuedas(int numeroRuedas) {
        this.numeroRuedas = numeroRuedas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public int getVelociadInicial() {
        return velociadInicial;
    }

    public void setVelociadInicial(int velociadInicial) {
        this.velociadInicial = velociadInicial;
    }

    @Override
    public String toString() {
        return "coche [modelo=" + modelo + ", marca=" + marca + ", numeroRuedas=" + numeroRuedas + ", numeroPuertas="
                + numeroPuertas + ", velociadInicial=" + velociadInicial + "]";
    }

    public void acelerar(int incrementoVelocidad) {
        if(velociadInicial == 0) {
            System.out.println("El coche está en reposo. Iniciando el coche y acelerando...");
        }
        velociadInicial += incrementoVelocidad;
        System.out.println("La velocidad del coche ahora es: " + velociadInicial + " km/h");
    }

    public static void main(String[] args) {

        coche coche1 = new coche("Amarok", "Volkswagen", 4, 4);
        System.out.println(coche1);

        coche1.acelerar(100);
    }
    
}
