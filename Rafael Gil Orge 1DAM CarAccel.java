package Javacosas;

public class cocheAccel {

    class coche {

        // atributo
        private int velocidad;

        // contructor
        coche() {
            velocidad = 0;

        }
        /*
         * Añade a la clase coche los siguientes métodos: int getVelocidad(). Este
         * método devuelve la velocidad actual. uoid acelera(int mas). Este método
         * actualiza la velocidad a mas kilómetros más. void frenafint menos). Este
         * método actualiza la velocidad a menos kilómetros menos.
         */

        /* getter & setter */

        public int getVelocidad() {
            return velocidad;
        }

        public void setVelocidad(int velocidad) {
            this.velocidad = velocidad;
        }

        public void acelera(int mas) {
            if (velocidad + mas > 120)
                velocidad = 120;
                
                else
                // velocidad= velocidad + chop;
                velocidad += mas;

        }

        public void frena(int cant) {
            if (velocidad - cant < 0) {
                velocidad = 0;
            }

            else {
                velocidad -= cant;

            }
            

        }
    }
}





