public class OrdenarBurbuja {
    public static void main(String[] args) {
        int[] numeros = {5, 3, 8, 4, 2, 7, 1, 6};

        System.out.println("Array original:");
        mostrarArray(numeros);

        // Algoritmo de la burbuja
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = 0; j < numeros.length - 1 - i; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    // Intercambiamos
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }

        System.out.println("\nArray ordenado:");
        mostrarArray(numeros);
    }

    // Método auxiliar para mostrar el array
    public static void mostrarArray(int[] array) {
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
