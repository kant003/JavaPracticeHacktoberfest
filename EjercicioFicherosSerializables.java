package ficheros.manejoFicheros;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import ficheros.objetos.MiObjectOutputStream;

public class EjercicioFicherosSerializables {
    static boolean flag = true;
    static File f = new File("Coches.list");
    static Scanner sc = new Scanner(System.in);

    private static void addDataNewFile() {
        FileOutputStream fos;
        ObjectOutputStream oos;
        String matricula, marca, modelo;
        int tamanoDeposito = 0;
        double precio = 0d;

        System.out.print("Matrícula: ");
        matricula = sc.next();
        sc.nextLine();

        System.out.print("Marca: ");
        marca = sc.next();
        sc.nextLine();

        System.out.print("Modelo: ");
        modelo = sc.next();
        sc.nextLine();

        System.out.print("Tamaño depósito: ");
        if (sc.hasNextInt())
            tamanoDeposito = sc.nextInt();

        System.out.print("Precio: ");
        if (sc.hasNextDouble())
            precio = sc.nextDouble();

        try {
            fos = new FileOutputStream(f, true);
            oos = new ObjectOutputStream(fos);

            Coche c = new Coche(matricula, marca, modelo, tamanoDeposito, precio);
            oos.writeObject(c);

            oos.close();
            fos.close();
        } catch (FileNotFoundException fnf) {
            System.err.println("El fichero no existe.");
            flag=false;
        } catch (IOException io) {
            System.err.println("Error de escritura.");
            io.printStackTrace();
            flag=false;
        }
    }

    public static void addDataExistentFile() {
        FileOutputStream fos;
        MiObjectOutputStream moos;
        String matricula, marca, modelo;
        int tamanoDeposito = 0;
        double precio = 0d;

        System.out.print("Matrícula: ");
        matricula = sc.next();
        sc.nextLine();

        System.out.print("Marca: ");
        marca = sc.next();
        sc.nextLine();

        System.out.print("Modelo: ");
        modelo = sc.next();
        sc.nextLine();

        System.out.print("Tamaño depósito: ");
        if (sc.hasNextInt())
            tamanoDeposito = sc.nextInt();

        System.out.print("Precio: ");
        if (sc.hasNextDouble())
            precio = sc.nextDouble();

        try {
            fos = new FileOutputStream(f, true);
            moos = new MiObjectOutputStream(fos);

            Coche c = new Coche(matricula, marca, modelo, tamanoDeposito, precio);
            moos.writeObject(c);

            moos.close();
            fos.close();
        } catch (FileNotFoundException fnf) {
            System.err.println("El fichero no existe.");
            flag=false;
        } catch (IOException io) {
            System.err.println("Error de escritura.");
            io.printStackTrace();
            flag=false;
        }

    }

    public static void list() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            while (true) {
                Coche p = (Coche) ois.readObject();
                System.out.println(p.toString());
            }

        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        } catch (FileNotFoundException fnf) {
            System.err.println("No se encuentra el fichero.");
            flag=false;
        } catch (EOFException eof) {
        } catch (IOException io) {
            System.err.println("Error de lectura.");
            io.printStackTrace();
            flag=false;
        } finally {
            try {
                ois.close();
                fis.close();
            } catch (IOException e) {
            } catch (NullPointerException np) {
            }
        }
    }

    private static void brandSearch(String brand) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            while (true) {
                Coche p = (Coche) ois.readObject();
                if (p.getMarca().equals(brand))
                    System.out.println(p.toString());
            }

        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        } catch (FileNotFoundException fnf) {
            System.err.println("No se encuentra el fichero.");
            flag=false;
        } catch (EOFException eof) {
        } catch (IOException io) {
            System.err.println("Error de lectura.");
            flag=false;
            io.printStackTrace();
        } finally {
            try {
                ois.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException np) {
            }
        }
    }

    public static void listWithIVA() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        double iva, total;

        try {
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            while (true) {
                Coche p = (Coche) ois.readObject();

                iva = p.getPrecio() * 0.21;
                total = iva + p.getPrecio();
                System.out.println(p.toString() + " ,IVA= " + iva + ", PrecioConIVA= " + total);
            }
        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        } catch (FileNotFoundException fnf) {
            System.err.println("No se encuentra el fichero.");
            flag=false;
        } catch (EOFException eof) {
        } catch (IOException io) {
            System.err.println("Error de lectura.");
            io.printStackTrace();
            flag=false;
        } finally {
            try {
                ois.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException np) {
            }
        }
    }

    public static void main(String[] args) {
        int opt = 0;

        while (flag) {
            opt = 0;
            System.out.println("\n======= Gestión de coches =======");
            System.out.println(
                    "1) Introducir nuevo coche\n2) Listar coches\n3) Buscar por marca\n4) Listar coches (con IVA)\n5) Salir");
            System.out.println("=================================\n");
            System.out.print("Introduce tu opción: ");
            if (sc.hasNextInt())
                opt = sc.nextInt();

            switch (opt) {
                case 1:
                    if (f.exists())
                        addDataExistentFile();
                    else
                        addDataNewFile();
                    break;
                case 2:
                    list();
                    break;
                case 3:
                    String brand;
                    System.out.print("Marca: ");
                    brand = sc.next();
                    brandSearch(brand);
                    break;
                case 4:
                    listWithIVA();
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.err.println("La opción introducida no es válida.");
            }
            sc.nextLine();
        }
        sc.close();
    }

}
