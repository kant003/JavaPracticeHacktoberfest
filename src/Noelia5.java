import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Conversor {

	private JFrame frame;
	private JTextField texto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor window = new Conversor();
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
	public Conversor() {
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
		
		texto = new JTextField();
		texto.setBounds(40, 34, 100, 20);
		frame.getContentPane().add(texto);
		texto.setColumns(10);
		
		JButton convertir = new JButton("CONVERTIR");
		convertir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Ver lo que hay escrito en la caja de texto
				texto.getText();
				//Pasar el texto a mayusculas
				
				//Escribir ese texto convertido en la caja de texto
			}
		});
		convertir.setBackground(Color.LIGHT_GRAY);
		convertir.setBounds(37, 102, 103, 23);
		frame.getContentPane().add(convertir);
	}
}
