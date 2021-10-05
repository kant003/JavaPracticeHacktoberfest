package ejerciciosInterfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio03 {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textEdad;
	private JLabel lblTexto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio03 window = new Ejercicio03();
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
	public Ejercicio03() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 269);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(15, 15, 5, 0);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		frame.getContentPane().add(lblNombre, gbc_lblNombre);
		
		textNombre = new JTextField();
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.insets = new Insets(15, 0, 5, 15);
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.gridx = 1;
		gbc_textNombre.gridy = 0;
		frame.getContentPane().add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 0;
		gbc_lblApellidos.gridy = 1;
		frame.getContentPane().add(lblApellidos, gbc_lblApellidos);
		
		textApellidos = new JTextField();
		GridBagConstraints gbc_textApellidos = new GridBagConstraints();
		gbc_textApellidos.insets = new Insets(0, 0, 5, 15);
		gbc_textApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textApellidos.gridx = 1;
		gbc_textApellidos.gridy = 1;
		frame.getContentPane().add(textApellidos, gbc_textApellidos);
		textApellidos.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad");
		GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.anchor = GridBagConstraints.EAST;
		gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdad.gridx = 0;
		gbc_lblEdad.gridy = 2;
		frame.getContentPane().add(lblEdad, gbc_lblEdad);
		
		textEdad = new JTextField();
		GridBagConstraints gbc_textEdad = new GridBagConstraints();
		gbc_textEdad.insets = new Insets(0, 0, 5, 15);
		gbc_textEdad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEdad.gridx = 1;
		gbc_textEdad.gridy = 2;
		frame.getContentPane().add(textEdad, gbc_textEdad);
		textEdad.setColumns(10);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int edad = Integer.parseInt(textEdad.getText());
				String nombre = textNombre.getText();
				String apellidos = textApellidos.getText();
				if(edad>=18) {
					JOptionPane.showMessageDialog(frame, "Bienvenido "+ nombre +" "+ apellidos, "Bienvenido,",JOptionPane.DEFAULT_OPTION);
				lblTexto.setText("Bienvenido " + nombre+" "+ apellidos);
				}else {
					JOptionPane.showMessageDialog(frame, "Lo sentimos no tienes la edad suficiente", "ERROR", JOptionPane.ERROR_MESSAGE);
					lblTexto.setText("Vuelve cuando seas mayor de edad" );
				}
				
			}
		});
		GridBagConstraints gbc_btnEntrar = new GridBagConstraints();
		gbc_btnEntrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnEntrar.gridx = 1;
		gbc_btnEntrar.gridy = 3;
		frame.getContentPane().add(btnEntrar, gbc_btnEntrar);
		
		lblTexto = new JLabel("");
		GridBagConstraints gbc_lblTexto = new GridBagConstraints();
		gbc_lblTexto.gridx = 1;
		gbc_lblTexto.gridy = 4;
		frame.getContentPane().add(lblTexto, gbc_lblTexto);
	}

}
