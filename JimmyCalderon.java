public class JimmyCalderon {

    // ENUM
    public enum TipoPlaneta {
        GASEOSO,
        TERRESTRE,
        ENANO,
        
    }// Fin Enum
     // Constante

    public long distanciaSol = 149597870;
    // atributos

    private String nombre;
    private int cantidadSatelites;
    private double masa;
    private double volumen;
    private int diametro;
    private int distancia;
    private boolean vistadePlaneta;
    private TipoPlaneta tipo;

    // constructor por defecto

    public PlanetaTarea() {
        this.nombre = " ";
        this.cantidadSatelites = 0;
        this.masa = 0;
        this.volumen = 0;
        this.diametro = 0;
        this.distancia = 0;
        this.vistadePlaneta = false;
        this.tipo = null;

    }

    // constructor con parametros
    public PlanetaTarea(String nombre, int cantidadSatelites, double masa, double volumen, int diametro, int distancia,
            boolean vistadePlaneta, PlanetaTarea.TipoPlaneta tipo) {
        this.nombre = nombre;
        this.cantidadSatelites = cantidadSatelites;
        this.masa = masa;
        this.volumen = volumen;
        this.diametro = diametro;
        this.distancia = distancia;
        this.vistadePlaneta = vistadePlaneta;
        this.tipo = tipo;
    }

    // Getters and Setters
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

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public boolean isVistadePlaneta() {
        return vistadePlaneta;
    }

    public void setVistadePlaneta(boolean vista) {
        this.vistadePlaneta = vista;
    }

    public TipoPlaneta getTipo() {
        return tipo;
    }

    public void setTipo(TipoPlaneta tipo) {
        this.tipo = tipo;
    }

    // Calcular densidad
    public double CalcularDensidad() {
        return masa / volumen;
    }

    // Calcular si es planeta exterior o interior
    public boolean esPlanetaExteriorOInterior() {
        double distanciaExterior = (this.distancia * 100000000) / distanciaSol;

            return distanciaExterior > 3.4;
    }

    @Override
    public String toString() {
        return "PlanetaTarea [nombre=" + nombre + ", cantidadSatelites=" + cantidadSatelites + ", masa=" + masa
                + ", volumen=" + volumen + ", diametro=" + diametro + ", distancia=" + distancia + ", vistadePlaneta="
                + vistadePlaneta + ", tipo=" + tipo + "]";
    }// toString

}// Fin Class
