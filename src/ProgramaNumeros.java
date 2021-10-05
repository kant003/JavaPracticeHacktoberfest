/**
 *
 * @author Pedro
 */
public class ProgramaNumeros {
    
    static int x; // una variable de clase (se inicializa por defecto a cero)
    
    public static void main(String[] args) {
        int n=8; // una variable local sin asignar (no tiene valor)
        n = 6;
        x=1043246464;
        short y = 78;
        y = (short) x;
        System.out.println(y);
        System.out.println( (double) x / n );
        long z = 10432464646555L;
        
        int cociente = 7 / 2;
        int resto = 7 % 2;
        System.out.println(resto);
        // Solicitamos un número por teclado 
        // y quiero normalizarlo al rango [1..8]
        System.out.println("Escribe un número entero:" );
        System.out.println();
        int numero = leerEntero();
        int numeroNormalizado = (numero % 8)+1;
        double resultado = Math.pow(9, 5);
        System.out.println(numeroNormalizado);
    }
    public static int leerEntero() {
        return new java.util.Scanner(System.in).nextInt();
    }
}
