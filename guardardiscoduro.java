package ejemplos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class guardardiscoduro {

	private JFrame frame;
	private JTextField ruta;
	private JLabel mensaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guardardiscoduro window = new guardardiscoduro();
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
	public guardardiscoduro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Ruta fichero: ");
		frame.getContentPane().add(lblNewLabel);
		
		ruta = new JTextField();
		frame.getContentPane().add(ruta);
		ruta.setColumns(20);
		
		JButton boton = new JButton("Seleccionar");
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Mostrar una ventana de seleccion de fichero
				JFileChooser jfc=new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("ficheros de texto", "TXT", "txt", "md");
				jfc.setFileFilter(filtro);
				int resultado = jfc.showOpenDialog(frame);
				
				if(resultado==JFileChooser.APPROVE_OPTION) {
					File fichero = jfc.getSelectedFile();
					String contenido="";
					try {
						contenido = guardardiscordurofichero.leerfichero(fichero);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					contenido=contenido.toUpperCase();
					try {
						guardardiscordurofichero.guardarFichero(fichero, contenido);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					mensaje.setText("Fichero convertido");
					JOptionPane.showMessageDialog(null, "Fichero convertido correctamente");
					}else if(resultado==JFileChooser.CANCEL_OPTION){
					
				}else if(resultado==JFileChooser.ERROR_OPTION) {
					
				}
				}
		});
		frame.getContentPane().add(boton);
		
		mensaje = new JLabel(" ");
		frame.getContentPane().add(mensaje);
	}

}
