import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ejercicio04 {

	private JFrame frame;
	private JTextField ruta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ejercicio04 window = new ejercicio04();
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
	public ejercicio04() {
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
		
		JLabel lblNewLabel = new JLabel("Ruta Fichero");
		lblNewLabel.setBounds(10, 9, 62, 14);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(lblNewLabel);
		
		ruta = new JTextField();
		ruta.setBounds(82, 6, 221, 20);
		ruta.setText("");
		frame.getContentPane().add(ruta);
		ruta.setColumns(10);
		
		JButton btnGuardar = new JButton("New button");
		btnGuardar.setBounds(302, 5, 89, 23);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("fichero de texto","txt", "TXT","md");
				jfc.setFileFilter(filtro);
				int resultado =  jfc.showOpenDialog(frame);
				
				if (resultado ==JFileChooser.APPROVE_OPTION) {
					File fichero = jfc.getSelectedFile();
					String contenido = null;
					try {
						contenido = Fichero.leerFichero(fichero);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					contenido = contenido.toUpperCase();
					try {
						Fichero.guardarFichero(fichero, contenido);
					} catch (IOException e1) {
						
					}
					
					
				}else if(resultado ==JFileChooser.CANCEL_OPTION){
					
				}else if(resultado ==JFileChooser.ERROR_OPTION){
					
				}
			}
			
		});
		frame.getContentPane().add(btnGuardar);
	}

}
