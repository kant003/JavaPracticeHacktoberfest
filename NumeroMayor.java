public class NumeroMayor {
    public static void main(String[] args) {
        // Definimos un array de números
        int[] numeros = {5, 8, 12, 3, 9, 21, 7};

        // Inicializamos el mayor con el primer elemento
        int mayor = numeros[0];

        // Recorremos el array
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > mayor) {
                mayor = numeros[i]; // actualizamos si encontramos uno mayor
            }
        }

        // Mostramos el resultado
        System.out.println("El número mayor es: " + mayor);
    }
}
