
import java.util.Scanner;

public class ejercicio101 {

    public static int calcularEsquinas(int[][] m) {
        int sumaEsquinas = 0;
        sumaEsquinas += m[0][0];
        sumaEsquinas += m[0][m.length-1];
        sumaEsquinas += m[m.length-1][0];
        sumaEsquinas += m[m.length-1][m.length-1];
        return sumaEsquinas;
    }

    public static int calcularCm(int[][] m) {
        int cm = 0;
        for (int i = 0; i < m.length; i++) {
            cm += m[0][i];
        }
        return cm;
    }

    public static int calcularFila(int[][] m, int n) {
        int sumaFila = 0;
        for (int i = 0; i < m.length; i++) {
            sumaFila += m[n][i];
        }
        return sumaFila;
    }

    public static boolean calcularDiagonales(int[][] m, int cm) {
        int diagonalPrincipal  = 0;
        int diagonalSecundaria = 0;
        for (int i = m.length-1, j = 0; i >= 0; i--, j++) {
            diagonalPrincipal  += m[i][j];
            diagonalSecundaria += m[j][j];
        }
        return (diagonalPrincipal == cm &&
                diagonalSecundaria == cm);
    }

    public static int calcularColumna(int[][] m, int n) {
        int sumaColumna = 0;
        for (int i = 0; i < m.length; i++) {
            sumaColumna += m[i][n];
        }
        return sumaColumna;
    }

    public static int calcularCasillasMitad(int[][] m) {
        int mitad = 0;
        if (m.length % 2 != 0) {
            mitad += m[0][m.length/2]; // arriba
            mitad += m[m.length/2][0]; // izq
            mitad += m[m.length-1][m.length/2]; // abajo
            mitad += m[m.length/2][m.length-1]; // der
        }
        else {
            mitad += m[0][m.length/2]; // arriba
            mitad += m[0][(m.length/2)-1];

            mitad += m[m.length/2][0]; // izq
            mitad += m[(m.length/2)-1][0];

            mitad += m[m.length-1][m.length/2]; // abajo
            mitad += m[m.length-1][(m.length/2)-1];

            mitad += m[m.length/2][m.length-1]; // der
            mitad += m[(m.length/2)-1][m.length-1];
        }
        return mitad;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n, cm, cm2;
        int[][] m;
        int[] test;
        boolean diabolico, esoterico;

        while (true) {

            n = s.nextInt();
            if (n == 0) break;

            m = new int[n][n];
            test   = new int[n*n];

            diabolico = true;
            esoterico = true;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int numero = s.nextInt();
                    m[i][j] = numero;
                    if (numero > (n*n) || test[numero-1] == 1)
                        esoterico = false;
                    else if (numero <= (n*n))
                        test[numero-1] = 1;
                }
            }

            cm  = calcularCm( m );
            cm2 = (cm * 4) / n;

            for (int i = 0; i < m.length; i++) {
                if (calcularFila(m, i) != cm) {
                    diabolico = false;
                    break;
                }
                if (calcularColumna(m, i) != cm) {
                    diabolico = false;
                    break;
                }
            }

            if (diabolico && !calcularDiagonales(m, cm))
                diabolico = false;

            if (diabolico && esoterico) {
                if (calcularEsquinas(m) != cm2)
                    diabolico = false;

                int mitad = calcularCasillasMitad( m );
                if (n % 2 != 0 && mitad != cm2)
                    esoterico = false;
                else if (n % 2 == 0) {
                    if (mitad != (cm2 * 2))
                        esoterico = false;
                }

                if (n % 2 != 0 && esoterico) {
                    if (m[m.length/2][m.length/2] * 4 != cm2)
                        esoterico = false;
                }
                else if (esoterico) {
                    int centro = 0;
                    centro += m[m.length/2][m.length/2];
                    centro += m[m.length/2][(m.length/2)-1];
                    centro += m[(m.length/2)-1][m.length/2];
                    centro += m[(m.length/2)-1][(m.length/2)-1];
                    if (centro != cm2)
                        esoterico = false;
                }
            }

            if (diabolico && esoterico) {
                System.out.println("ESOTERICO");
            }
            else if (diabolico) {
                System.out.println("DIABOLICO");
            }
            else {
                System.out.println("NO");
            }

        }

    }

}