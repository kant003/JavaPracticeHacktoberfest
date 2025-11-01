class Piscina {
    private int nivel;
    public final int MAX_NIVEL;

    public Piscina(int max) {
        if (max < 0) max = 0;
        MAX_NIVEL = max;
    }

    public int getNivel() {
        return nivel;
    }

    public void vaciar(int cantidad) throws Exception {
        if (nivel - cantidad < 0) {
            throw new Exception("Error: No se puede vaciar más agua de la que hay en la piscina.");
        }
        nivel -= cantidad;
    }

    public void llenar(int cantidad) throws Exception {
        if (nivel + cantidad > MAX_NIVEL) {
            throw new Exception("Error: No se puede superar la capacidad máxima de la piscina.");
        }
        nivel += cantidad;
    }

    public void vaciarTodo() {
        nivel = 0;
    }

    public void llenarTodo() {
        nivel = MAX_NIVEL;
    }
}
