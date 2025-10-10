public class RestauranteIsrael {
    package Tema2;

    import java.util.Scanner;
    
        //atributos
        double papas;
        double chocos; //double porque son atributos enteros
        public static int dimeClientes(double p, double c) {
            int Clientes=0;
            //cálculos
            /*mientras haya mas o igual a un kilo de patatas YYY mas o igual de medio kilo de chocos
             * haz: num+=3;
             * 	patatas-=1;
             * chocos-=0.5*/
            while((p>=1) && (c>=0.5)) {
                //Clientes aumentaron en 3
                Clientes+=3;
                //patatas quito 1 kilo
                p-=1;
                //chocos quito 1/2 kilo
                c-=0.5;
            }//vuelvo a mirar
            return Clientes; /*cualquier "public static int/double" 
            te requiere que devuelvas con "return" cualquier dato que pidas*/
        }
        
        public static void main(String[] args) {
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Cuanto hay de patatas: ");
            double patatas=sc.nextDouble();
            System.out.println("Cuanto hay de chocos: ");
            double chocos=sc.nextDouble();
            
            System.out.println("podemos dar de comer a: "+dimeClientes(patatas, chocos));
            
                    
        }
        
        
        
        
    }
       

