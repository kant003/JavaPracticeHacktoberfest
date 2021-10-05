
public class RestaNumeros
{
    public static void main( String[] args )
    {
        int n1, n2, resta;

        Scanner teclado = new Scanner( System.in );

        System.out.print( "Introduzca primer número: " );
        n1 = teclado.nextInt();

        System.out.print( "Introduzca segundo número: " );
        n2 = teclado.nextInt();

        suma = n1 - n2;

        System.out.println( "La suma de " + n1 + " menos " + n2 + " es " + resta + "." );
    }
}