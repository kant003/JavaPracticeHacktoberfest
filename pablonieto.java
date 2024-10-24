public class pablonieto {
      // Enumerado para el tipo de planeta
      public enum TipoPlaneta {
        GASEOSO, TERRESTRE, ENANO
    }

    // Atributos
    private String nombre = null;
    private int cantidadSatelites = 0;
    private double masa = 0.0; // en kilogramos
    private double volumen = 0.0; // en kilómetros cúbicos
    private int diametro = 0; // en kilómetros
    private int distanciaMediaSol = 0; // en millones de kilómetros
    private TipoPlaneta tipoPlaneta = TipoPlaneta.TERRESTRE;
    private boolean observableSimpleVista = false;

    // Constructor por defecto
    public Planeta() {}

    // Constructor completo
    public Planeta(String nombre, int cantidadSatelites, double masa, double volumen, int diametro, int distanciaMediaSol, TipoPlaneta tipoPlaneta, boolean observableSimpleVista) {
        this.nombre = nombre;
        this.cantidadSatelites = cantidadSatelites;
        this.masa = masa;
        this.volumen = volumen;
        this.diametro = diametro;
        this.distanciaMediaSol = distanciaMediaSol;
        this.tipoPlaneta = tipoPlaneta;
        this.observableSimpleVista = observableSimpleVista;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadSatelites() {
        return cantidadSatelites;
    }

    public void setCantidadSatelites(int cantidadSatelites) {
        this.cantidadSatelites = cantidadSatelites;
    }

    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    public int getDistanciaMediaSol() {
        return distanciaMediaSol;
    }

    public void setDistanciaMediaSol(int distanciaMediaSol) {
        this.distanciaMediaSol = distanciaMediaSol;
    }

    public TipoPlaneta getTipoPlaneta() {
        return tipoPlaneta;
    }

    public void setTipoPlaneta(TipoPlaneta tipoPlaneta) {
        this.tipoPlaneta = tipoPlaneta;
    }

    public boolean isObservableSimpleVista() {
        return observableSimpleVista;
    }

    public void setObservableSimpleVista(boolean observableSimpleVista) {
        this.observableSimpleVista = observableSimpleVista;
    }

    // Método para calcular la densidad (masa / volumen)
    public double calcularDensidad() {
        if (volumen != 0) {
            return masa / volumen;
        }
        return 0;
    }

    // Método para determinar si es un planeta exterior
    public boolean esPlanetaExterior() {
        // Convertir la distancia media al Sol en kilómetros
        double distanciaEnKm = distanciaMediaSol * 1_000_000;
        double distanciaEnUA = distanciaEnKm / 149_597_870; // Convertir a Unidades Astronómicas (UA)
        return distanciaEnUA > 3.4; // Más allá del cinturón de asteroides
    }

    // Método toString
    @Override
    public String toString() {
        return "Planeta: " + nombre + "\n" +
               "Satelites: " + cantidadSatelites + "\n" +
               "Masa: " + masa + " kg\n" +
               "Volumen: " + volumen + " km³\n" +
               "Diametro: " + diametro + " km\n" +
               "Distancia al Sol: " + distanciaMediaSol + " millones de km\n" +
               "Tipo: " + tipoPlaneta + "\n" +
               "Observable a simple vista: " + observableSimpleVista;
    }

}
}
