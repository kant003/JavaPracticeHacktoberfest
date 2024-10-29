package Tema2;
//Este es mi cambio4
public class coche {

    private int velocidad;
    //Constructor
    public coche() {
        velocidad = 0;
    }

    public coche(int velocidad){
        super();
        this.velocidad = velocidad;
    }
    
    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    //limite 120
    public void acelera(int chop){
        
        if (velocidad+chop>120) {
            velocidad = 120;
        }
        else{
            velocidad+=chop;
        }
    }

    public void frena(int cant){
        
        if (velocidad-cant<0) {
            velocidad=0;
        }
        else{
            velocidad-=cant;    
        }
    }

    public static void main(String[] args) {

    }

    @Override
    public String toString() {
        return "Coche [velocidad=" + velocidad + "]";
    }


    


}
