import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Ejercicio4GuartarTxt {

	private JFrame frame;
	private JTextField Ruta;
	private JLabel mensaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio4GuartarTxt window = new Ejercicio4GuartarTxt();
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
	public Ejercicio4GuartarTxt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 132);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Ruta del fichero:");
		
		Ruta = new JTextField();
		Ruta.setColumns(20);
		
		JButton btnSeleccionar = new JButton("Seleccionar Fichero");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jfc = new JFileChooser(); //nuevo objeto jfc
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY); //selecciono el ficheros only
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("Ficheros de texto","txt","Markdown","md");
				jfc.setFileFilter(filtro); //Tipos de ficheros permitidos
				int resultado = jfc.showDialog(frame, null);
				if(resultado==JFileChooser.APPROVE_OPTION) {
					File fichero = jfc.getSelectedFile();
					String contenido = null;
					try {
						contenido = Fichero.leerFichero(fichero);
					} catch (IOException e) {
						mensaje.setText("ERROR");
					}
					contenido = contenido.toUpperCase();
					try {
						Fichero.guardarFichero(fichero, contenido);
					} catch (IOException e) {
						mensaje.setText("ERROR");
					}
					JOptionPane.showMessageDialog(frame, "Fichero convertido correctamente");
				} else if (resultado==JFileChooser.CANCEL_OPTION) {
					mensaje.setText("");
				} else if(resultado==JFileChooser.ERROR_OPTION) {
					mensaje.setText("fvck");
				}
			}
		});
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(Ruta);
		frame.getContentPane().add(btnSeleccionar);
		
		mensaje = new JLabel("-");
		frame.getContentPane().add(mensaje);
	}
}
