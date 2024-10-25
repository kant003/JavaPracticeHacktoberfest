import java.util.Scanner;

public class Propuesto11 {

    private double chocos = 0;
    private double papas = 0;
    private int clientes = 0;

    public Propuesto11(double chocos, double papas) {
        this.chocos = chocos;
        this.papas = papas;
    }

    public Propuesto11() {
        this.chocos = 0;
        this.papas = 0;
    }

    public double getChocos() {
        return chocos;
    }

    public void setChocos(double chocos) {
        this.chocos = chocos;
    }

    public double getPapas() {
        return papas;
    }

    public void setPapas(double papas) {
        this.papas = papas;
    }

    public int pedirClientes() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el número de clientes: ");
        this.clientes = sc.nextInt();
        return clientes;
    }

    public void pedirProductos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la cantidad de papas: ");
        this.papas = sc.nextDouble();
        System.out.println("Introduce la cantidad de chocos: ");
        this.chocos = sc.nextDouble();
    }

    public double personasAlimentar() {
        boolean a = true;
        do {
            if (papas >= 1 && chocos >= 0.5) {
                this.clientes += 3;
                this.papas -= 1;
                this.chocos -= 0.5;
            } else if (papas < 1 || chocos < 0.5) {
                a = false;
            } else {
                System.out.println("Error");
                a = false;
            }
        } while (a == true);
        return this.clientes;
    }
}
