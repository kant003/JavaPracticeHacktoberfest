// Clase Producto (ejemplo simplificado)
public class Producto {
    private int id;
    private String nombre;
    // ... otros atributos
}

// Clase Inventario
public class Inventario {
    private ArrayList<Producto> productos;

    public void añadirProducto(Producto p) {
        productos.add(p);
    }
    // ... otros métodos
}

// Clase principal para la aplicación de consola
public class GestionInventario {
    public static void main(String[] args) {
        Inventario miInventario = new Inventario();
        // ... lógica de la consola
    }
}