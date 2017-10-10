package Ejercicio5;

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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

public class Ejercicio5 {
	private static int codigo=0;
	static Hashtable<Integer, Medicamentos> contenedor = new Hashtable<Integer, Medicamentos>();

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio5 window = new Ejercicio5();
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
	public Ejercicio5() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		loadData();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAltas = new JButton("Altas");
		btnAltas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				altas();
			}
		});
		btnAltas.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnAltas);
		
		JButton btnModificaciones = new JButton("Modificaciones");
		btnModificaciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modificaciones();
			}
		});
		btnModificaciones.setBounds(301, 11, 123, 23);
		frame.getContentPane().add(btnModificaciones);
		
		JButton btnConsultas = new JButton("Consultas");
		btnConsultas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				consultas();
			}
		});
		btnConsultas.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnConsultas);
		
		JButton btnListados = new JButton("Listados");
		btnListados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listado();
			}
		});
		btnListados.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnListados);
		
		JButton btnGuardarYSalir = new JButton("Guardar y Salir");
		btnGuardarYSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				saveandexit();
			}
		});
		btnGuardarYSalir.setBounds(152, 103, 112, 50);
		frame.getContentPane().add(btnGuardarYSalir);
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

	}
	public static void altas(){
		codigo++;
		String nombre = JOptionPane.showInputDialog("Introduzca el nombre del medicamento");
		String lote = JOptionPane.showInputDialog("Introduzca el Lote");
		String caducidad = JOptionPane.showInputDialog("Introduzca la fecha de caducidad (dd/MM/yyyy");
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date caduci = null;
		try {
			caduci = df.parse(caducidad);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double precio = Double.parseDouble(JOptionPane.showInputDialog("Introduzca el precio"));
		double iva= Double.parseDouble(JOptionPane.showInputDialog("Introduzca el IVA XX%"));
		String laboratorio = JOptionPane.showInputDialog("Introduzca el laboratorio");
		Medicamentos M = new Medicamentos(nombre,lote,caduci,precio,iva,laboratorio);
		
		contenedor.put(codigo, M);
		
	}
	public static void listado(){
		Enumeration<Integer> enumeration = contenedor.keys();
		while (enumeration.hasMoreElements()) {
			int k = enumeration.nextElement();
			double price = contenedor.get(k).getPrecio();
			double iva = 1+contenedor.get(k).getIVA()/100;
			double importe = price*iva;
			System.out.println(k +" "+ contenedor.get(k)+" "+importe);
		}
	}
	private void consultas() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el código del medicamento"));
		if (contenedor.containsKey(id)) {
			String result = ""+contenedor.get(id);
			JOptionPane.showMessageDialog(frame, result);
		}
	}
	
	private void saveandexit(){
		 FileOutputStream fs;
		 ObjectOutputStream	os=null;
		try {
			fs = new FileOutputStream("Farmacia.dat",true);
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
				os.writeObject(k);
				os.writeObject(contenedor.get(k));

				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.exit(0);
	}
	public void modificaciones(){
		int id = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el código del medicamento a modificar"));
		if (contenedor.containsKey(id)) {
			String nombre = JOptionPane.showInputDialog("Introduzca el nombre del medicamento");
			String lote = JOptionPane.showInputDialog("Introduzca el Lote");
			String caducidad = JOptionPane.showInputDialog("Introduzca la fecha de caducidad (dd/MM/yyyy");
	        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date caduci = null;
			try {
				caduci = df.parse(caducidad);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			double precio = Double.parseDouble(JOptionPane.showInputDialog("Introduzca el precio"));
			double iva= Double.parseDouble(JOptionPane.showInputDialog("Introduzca el IVA XX%"));
			String laboratorio = JOptionPane.showInputDialog("Introduzca el laboratorio");
			Medicamentos M = new Medicamentos(nombre,lote,caduci,precio,iva,laboratorio);
			
			contenedor.put(id, M);
			
		}
	}
	public void loadData() {
		ObjectInputStream os=null;
		try {
			FileInputStream fs = new FileInputStream("Farmacia.dat");
			os = new ObjectInputStream(fs);
			// solo recupera un objeto
			// os debe realizar un casting al tipo original
			while(true){ 
				int codigo = (Integer) os.readObject();
				Medicamentos p = (Medicamentos) os.readObject();
				//System.out.println(dni+" " +p);
				contenedor.put(codigo, p);
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
