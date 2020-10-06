class NumeroCompuesto
{
    static boolean esCompuesto(int n)
    {
        // Casos especiales
        if (n == 1)
            System.out.println("Falso");

        if (n == 3)
            System.out.println("Falso");

        // Esto se verifica para que podamos omitir
        // los cinco números intermedios en el bucle inferior
        if (n % 2 == 0 || n % 3 == 0) return true;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return true;

        return false;
    }

    public static void main(String args[])
    {
        System.out.println(esCompuesto(28) ?
                "Sí, ¡El número es un número compuesto!" : "No es compuesto, es primo");

        System.out.println(esCompuesto(19) ?
                "Sí, ¡El número es un número compuesto!" : "No es compuesto, es primo");
    }
}