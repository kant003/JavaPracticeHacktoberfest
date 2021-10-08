package ficheros.manejoFicheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class EjercicioFicherosBinarios {

    private static int[] randomNumbers(int length) {
        int[] output = new int[length];

        for (int i = 0; i < length; i++) {
            output[i] = (int) (Math.random() * 100);
        }

        return output;
    }

    private static void writeFile(String filePath, int length) {
        FileOutputStream fos;
        DataOutputStream dos;
        int[] numbers;

        try {
            fos = new FileOutputStream(filePath, true);
            dos = new DataOutputStream(fos);

            numbers = randomNumbers(length);

            for (int i : numbers) {
                dos.writeInt(i);
            }

            dos.close();
            fos.close();
        } catch (FileNotFoundException fnfe) {
            System.err.println("No se encuentra el archivo");
        } catch (IOException ioe) {
            System.err.println("Error de escritura.");
            ioe.printStackTrace();
        }

    }

    private static void readFile(String filePath) {
        FileInputStream fis;
        DataInputStream dis;

        try {
            fis = new FileInputStream(filePath);
            dis = new DataInputStream(fis);

            while (true) {
                System.out.print(dis.readInt() + " ");
            }

        } catch (FileNotFoundException fnf) {
            System.err.println("No se encuentra el archivo");
        } catch (EOFException eof) {
        } catch (IOException io) {
            System.err.println("Error de lectura.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filePath;
        int nums = 0;

        System.out.print("Introduce la ruta al archivo en el que quieras escribir: ");
        filePath = sc.next();
        sc.nextLine();

        System.out.print("Introduce la cantidad de números aleatorios que quieres generar: ");
        if (sc.hasNextInt())
            nums = sc.nextInt();
        else
            System.err.println("El dato introducido no es válido");

        writeFile(filePath, nums);

        readFile(filePath);

        sc.close();

    }
}
