package examen01A;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;


import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Hashtable;

public class Examen01A {

	private JFrame frame;
	static Hashtable<Integer, Articulo> contenedor = new Hashtable<Integer, Articulo>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Examen01A window = new Examen01A();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Examen01A() {
		loadData();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnInsertarArtculos = new JButton("Insertar Art\u00EDculos");
		btnInsertarArtculos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				altas();
			}
		});
		btnInsertarArtculos.setBounds(10, 11, 130, 56);
		frame.getContentPane().add(btnInsertarArtculos);
		
		JButton btnListarArtculos = new JButton("Listar Art\u00EDculos");
		btnListarArtculos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(frame, "El listado saldrá por consola");

				listar();
			}
		});
		btnListarArtculos.setBounds(294, 11, 130, 56);
		frame.getContentPane().add(btnListarArtculos);
		
		JButton btnArtculosAComprar = new JButton("Art\u00EDculos a comprar");
		btnArtculosAComprar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(frame, "El listado saldrá por consola");

				outofstock();
			}
		});
		btnArtculosAComprar.setBounds(10, 178, 130, 73);
		frame.getContentPane().add(btnArtculosAComprar);
		
		JButton btnGuardarYSalir = new JButton("Guardar y Salir");
		btnGuardarYSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				savenex();
			}
		});
		btnGuardarYSalir.setBounds(150, 78, 274, 173);
		frame.getContentPane().add(btnGuardarYSalir);
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

	}
	private void altas(){
		
		int codigo=Integer.parseInt(JOptionPane.showInputDialog("Introduzca el código del artículo"));
		if (checkCodigo(codigo)) {
			JOptionPane.showMessageDialog(frame, "El código ya está en el sistema");
			System.out.println("Código DUPLICADO");
		} else {
		String descripcion = JOptionPane.showInputDialog("Introduzca la descripción del artículo");
		double pvp = Double.parseDouble(JOptionPane.showInputDialog("Introduzca el PVP"));
		int stock= Integer.parseInt(JOptionPane.showInputDialog("Introduzca el stock"));
		int stockMinimo = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el stock mínimo"));
		Articulo a = new Articulo (descripcion,pvp,stock,stockMinimo);
		contenedor.put(codigo, a);
		}
	}
	private boolean checkCodigo(int codigo){
		return contenedor.containsKey(codigo);

	}
	public void listar(){
		Enumeration<Integer> enumeration = contenedor.keys();

		while (enumeration.hasMoreElements()) {
			int k = enumeration.nextElement();
			double pvp = contenedor.get(k).getPvp();
			int stock = contenedor.get(k).getStock();
			double total = pvp*stock;
			System.out.println("Código: "+k + "\nDescripción: " + contenedor.get(k).getDescripcion()+
					", stock: "+stock+", PVP: "+pvp+", "+", Total: "+total+"\n");
		}
	}
	public void outofstock(){
		Enumeration<Integer> enumeration = contenedor.keys();
		int contador=0;

		while (enumeration.hasMoreElements()) {
			int k = enumeration.nextElement();
			int stock = contenedor.get(k).getStock();
			int stockminimo = contenedor.get(k).getStockMinimo();
			int necesitamos = stockminimo-stock;
			if (stock<stockminimo){
				contador++;
				System.out.println("Hay que comprar por lo menos "+necesitamos+" unidad/es de "+contenedor.get(k).getDescripcion());
			}
		}
		if(contador==0){
			System.out.println("Toda la mercancía tiene stock suficiente");
		}
	}
	private void savenex(){
		 FileOutputStream fs;
		 ObjectOutputStream	os=null;
		try {
			fs = new FileOutputStream("Articulos.dat",true);
				os = new ObjectOutputStream(fs);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		Enumeration<Integer> enumeration = contenedor.keys();

		while (enumeration.hasMoreElements()) {
			int k = enumeration.nextElement();
			try {
				os.writeInt(k);
				os.writeObject(contenedor.get(k));

				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.exit(0);
	}
	public void loadData() {
		ObjectInputStream os=null;
		try {
			FileInputStream fs = new FileInputStream("Articulos.dat");
			os = new ObjectInputStream(fs);
			// solo recupera un objeto
			// os debe realizar un casting al tipo original
			while(true){ 
				int codigo = os.readInt();
				Articulo a = (Articulo) os.readObject();
				//System.out.println(codigo+" " +a);
				contenedor.put(codigo, a);
				}
			
		} catch (ClassNotFoundException cnf) {
			System.out.println("Error la clase");
		} catch (FileNotFoundException fnfe) {
			System.out.println("Fichero no encontrado, escribiendo un nuevo fichero");
		} catch (IOException ioe) {
			System.out.println();
		} finally{
			//try {
				//os.close();
			//} catch (IOException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
			//}
		}
	}
}
