public class JimmyCalderon7 {
    String marca;
    String modelo;
    int motor;

    enum tipoCombustible {
        GASOLINA, BIOETANOL, DIESEL, BIODIESEL, GASNATURAL
    }

    tipoCombustible Combustible; // la variable es combustible y acepta solo los valores del enum

    enum tipoAutomovil {
        CIUDAD, SUBCOMPACTO, COMPACTO, FAMILIAR, EJECUTIVO, SUV
    }

    tipoAutomovil coche; // la variable es coche y acepta solo los valores enum
    int puertas;
    int asientos;
    double velocidadMaxima;

    enum color {
        BLANCO, NEGRO, ROJO, NARANJA, AMARILLO, VERDE, AZUL, VIOLETA
    }

    color colorCoche;// la variable es colorCoche y aceota solo los valores enum

    double velocidadActual;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getMotor() {
        return motor;
    }

    public void setMotor(int motor) {
        this.motor = motor;
    }

    public tipoCombustible getCombustible() {
        return Combustible;
    }

    public void setCombustible(tipoCombustible combustible) {
        Combustible = combustible;
    }

    public tipoAutomovil getCoche() {
        return coche;
    }

    public void setCoche(tipoAutomovil coche) {
        this.coche = coche;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public color getColorCoche() {
        return colorCoche;
    }

    public void setColorCoche(color colorCoche) {
        this.colorCoche = colorCoche;
    }

    public double getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(double velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

public void acelerar (double valor){
    if (velocidadActual+valor>velocidadMaxima)
    System.out.println("No te da el carro chaval");
    else
    velocidadActual+=valor;
}

public void desacelerar (double valor){
    if(velocidadActual-valor<0)
    System.out.println("No puedes tener velocidad negativa");
    else
    velocidadActual-=valor;
}

public void frenar(){
    velocidadActual=0;
}

public double calcularTiempo(double kms){
    return kms/this.velocidadActual;
}

public Automovil(String marca, String modelo, int motor, Automovil.tipoCombustible combustible,
        Automovil.tipoAutomovil coche, int puertas, int asientos, double velocidadMaxima, Automovil.color colorCoche,
        double velocidadActual) {
    this.marca = marca;
    this.modelo = modelo;
    this.motor = motor;
    Combustible = combustible;
    this.coche = coche;
    this.puertas = puertas;
    this.asientos = asientos;
    this.velocidadMaxima = velocidadMaxima;
    this.colorCoche = colorCoche;
    this.velocidadActual = velocidadActual;
}//constructor con todos los atributos

@Override
public String toString() {
    return "Automovil [marca=" + marca + ", modelo=" + modelo + ", motor=" + motor + ", Combustible=" + Combustible
            + ", coche=" + coche + ", puertas=" + puertas + ", asientos=" + asientos + ", velocidadMaxima="
            + velocidadMaxima + ", colorCoche=" + colorCoche + ", velocidadActual=" + velocidadActual + "]";
}
 



    

}// Fin class
