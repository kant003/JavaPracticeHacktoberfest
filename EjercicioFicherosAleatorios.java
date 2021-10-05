package manejoFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class EjercicioFicherosAleatorios {
	private static final int tamanoRegistro = 132;
	private static File f = new File("Libros.dat");
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int opt = 0;
		boolean flag = true;

		while (flag) {
			opt = 0;
			System.out.println("\n======= Gestión de librería =======");
			System.out.println("1) Altas\n2) Listado libros\n3) Consultas\n4) Modificaciones\n5) Salir");
			System.out.println("=================================\n");
			System.out.print("Introduce tu opción: ");
			if (sc.hasNextInt())
				opt = sc.nextInt();
			sc.nextLine();

			switch (opt) {
				case 1:
					insertRecord();
					break;
				case 2:
					listFile();
					break;
				case 3:
					boolean flag2 = true;
					while (flag2) {
						System.out.println("\n===== Consultas ======");
						System.out.println("1) Por código\n2) Por autor\n3) Salir");
						System.out.print("Introduce tu opción: ");
						if (sc.hasNextInt())
							opt = sc.nextInt();

						switch (opt) {
							case 1:
								codeSearch();
								break;
							case 2:
								sc.nextLine();
								authorSearch();
								break;
							case 3:
								flag2 = false;
								break;
							default:
								System.out.println("La opción introducida no es válida.");
						}
					}
					break;
				case 4:
					modifyRecord();
					break;
				case 5:
					flag = false;
					break;
				default:
					System.err.println("La opción introducida no es válida");
			}
		}
	}

	private static void insertRecord() {
		RandomAccessFile raf;

		int codigo = 0, precio = 0, cantidad = -1;
		String titulo, autor;

		char answer = 's';

		try {
			raf = new RandomAccessFile(f, "rw");

			while (answer == 's') {
				do {
					System.out.print("Código: ");
					if (sc.hasNextInt())
						codigo = sc.nextInt();
					sc.nextLine();
				} while (codigo < 1);

				System.out.print("Título: ");
				titulo = sc.nextLine();

				System.out.print("Autor: ");
				autor = sc.nextLine();

				do {
					System.out.print("Precio: ");
					if (sc.hasNextInt())
						precio = sc.nextInt();
					sc.nextLine();
				} while (precio <= 0);

				do {
					System.out.print("Cantidad (máx 10): ");
					if (sc.hasNextInt())
						cantidad = sc.nextInt();
					sc.nextLine();
				} while (cantidad < 0 || cantidad > 10);

				if (titulo.length() > 30) {
					titulo = titulo.substring(0, 30);
				} else {
					for (int i = titulo.length(); i <= 30; i++) {
						titulo += " ";
					}
				}
				if (autor.length() > 30) {
					autor = autor.substring(0, 30);
				} else {
					for (int i = autor.length(); i <= 30; i++) {
						autor += " ";
					}
				}

				raf.seek(codigo * tamanoRegistro);
				raf.writeInt(codigo);
				raf.writeUTF(titulo);
				raf.writeUTF(autor);
				raf.writeInt(precio);
				raf.writeInt(cantidad);

				System.out.print("\n¿Desea introducir más libros? S/N: ");
				answer = sc.next().toLowerCase().charAt(0);
				System.out.println();
			}
			raf.close();

		} catch (FileNotFoundException fnf) {
			System.err.println("No se encuentra fichero.");
		} catch (IOException io) {
			System.err.println("Error de escritura.");
			io.printStackTrace();
		}
	}

	private static void listFile() {
		RandomAccessFile raf;

		int codigo, precio, cantidad;
		String titulo, autor;

		try {
			raf = new RandomAccessFile(f, "r");

			long numRegistros = f.length() / tamanoRegistro;

			System.out.println("\nCódigo\t" + "Título                         " + "Autor                         "
					+ "Precio\t" + "Cantidad");
			System.out.println(
					"==========================================================================================");
			for (int i = 0; i <= numRegistros; i++) {
				raf.seek(i * tamanoRegistro);
				codigo = raf.readInt();
				titulo = raf.readUTF();
				autor = raf.readUTF();
				precio = raf.readInt();
				cantidad = raf.readInt();
				if (codigo != 0)
					System.out.println(codigo + "\t" + titulo + autor + "\t" + precio + "\t" + cantidad + "\t");

			}

			raf.close();
		} catch (FileNotFoundException fnf) {
			System.err.println("No se encuentra fichero.");
		} catch (IOException io) {
			System.err.println("Error de lectura");
			io.printStackTrace();
		}
	}

	private static void codeSearch() {
		RandomAccessFile raf;
		int codigo, code = 0, precio, cantidad;
		String titulo, autor;

		try {
			raf = new RandomAccessFile(f, "r");
			long numRegistros = f.length() / tamanoRegistro;

			do {
				do {
					System.out.print("Código (0 para salir): ");
					if (sc.hasNextInt())
						code = sc.nextInt();
					sc.nextLine();
				} while (code < 0);

				if (code > 0 && code <= numRegistros) {
					raf.seek(code * tamanoRegistro);
					codigo = raf.readInt();
					titulo = raf.readUTF();
					autor = raf.readUTF();
					precio = raf.readInt();
					cantidad = raf.readInt();

					if (codigo != 0) {
						System.out.println("\nCódigo\t" + "Título                         "
								+ "Autor                         " + "Precio\t" + "Cantidad");
						System.out.println(
								"==========================================================================================");
						System.out.println(
								codigo + "\t" + titulo + "\t" + autor + "\t" + precio + "\t" + cantidad + "\t");
					} else
						System.out.println("El código no existe.");
				} else
					System.out.println("El código no existe.");
			} while (code != 0);

			raf.close();
		} catch (FileNotFoundException fnf) {
			System.err.println("No se encuentra el fichero.");
		} catch (IOException io) {
			System.err.println("Error de lectura");
			io.printStackTrace();
		}

	}

	private static void authorSearch() {
		RandomAccessFile raf;
		int codigo, precio, cantidad;
		String titulo, autor, author;
		try {
			raf = new RandomAccessFile(f, "r");

			System.out.print("Autor: ");
			author = sc.nextLine();

			long numRegistros = f.length() / tamanoRegistro;

			System.out.println("\nCódigo\t" + "Título                         " + "Autor                         "
					+ "Precio\t" + "Cantidad");
			System.out.println(
					"==========================================================================================");
			for (int i = 0; i <= numRegistros; i++) {
				raf.seek(i * tamanoRegistro);
				codigo = raf.readInt();
				titulo = raf.readUTF();
				autor = raf.readUTF();
				precio = raf.readInt();
				cantidad = raf.readInt();
				if (codigo != 0 && (autor.trim()).equals(author))
					System.out.println(codigo + "\t" + titulo + "\t" + autor + "\t" + precio + "\t" + cantidad + "\t");
			}

			raf.close();

		} catch (FileNotFoundException fnf) {
			System.err.println("No se encuentra fichero para leer");
		} catch (IOException io) {
			System.err.println("Error de lectura.");
			io.printStackTrace();
		}
	}

	private static void modifyRecord() {
		RandomAccessFile raf;
		int code = 0, codigo, precio, cantidad;
		String titulo, autor;
		char respuesta;

		try {
			raf = new RandomAccessFile(f, "rw");
			long numRegistros = f.length() / tamanoRegistro;

			do {
				do {
					System.out.print("Código (0 para salir): ");
					if (sc.hasNextInt())
						code = sc.nextInt();
					sc.nextLine();
				} while (code < 0);

				if (code > 0 && code <= numRegistros) {
					raf.seek(code * tamanoRegistro);
					codigo = raf.readInt();
					titulo = raf.readUTF();
					autor = raf.readUTF();
					precio = raf.readInt();
					cantidad = raf.readInt();

					if (codigo != 0) {
						System.out.println("\nCódigo\t" + "Título                         "
								+ "Autor                         " + "Precio\t" + "Cantidad");
						System.out.println(
								"==========================================================================================");
						System.out.println(
								codigo + "\t" + titulo + "\t" + autor + "\t" + precio + "\t" + cantidad + "\t");
						System.out.print("¿Desea modificar los datos? S/N: ");
						respuesta = sc.next().toLowerCase().charAt(0);

						if (respuesta == 's') {

							sc.nextLine();
							System.out.print("Título: ");
							titulo = sc.nextLine();

							System.out.print("Autor: ");
							autor = sc.nextLine();

							do {
								System.out.print("Precio: ");
								if (sc.hasNextInt())
									precio = sc.nextInt();
								sc.nextLine();
							} while (precio <= 0);

							do {
								System.out.print("Cantidad (máx 10): ");
								if (sc.hasNextInt())
									cantidad = sc.nextInt();
								sc.nextLine();
							} while (cantidad < 0 || cantidad > 10);

							if (titulo.length() > 30) {
								titulo = titulo.substring(0, 30);
							} else {
								for (int i = titulo.length(); i <= 30; i++) {
									titulo += " ";
								}
							}
							if (autor.length() > 30) {
								autor = autor.substring(0, 30);
							} else {
								for (int i = autor.length(); i <= 30; i++) {
									autor += " ";
								}
							}

							raf.seek(code * tamanoRegistro);
							raf.writeInt(codigo);
							raf.writeUTF(titulo);
							raf.writeUTF(autor);
							raf.writeInt(precio);
							raf.writeInt(cantidad);
						}

					} else
						System.out.println("El código no existe.");
				} else
					System.out.println("El código no existe.");

			} while (code != 0);
			raf.close();

		} catch (FileNotFoundException fnf) {
			System.err.println("No se encuentra el fichero.");
		} catch (IOException io) {
			System.err.println("No se puede leer");
			io.printStackTrace();
		}
	}
}
