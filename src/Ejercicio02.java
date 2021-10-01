package ejerciciosInterfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio02 {

	private JFrame frame;
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	private JTextField text4;
	private JComboBox<String> comboBox;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnCalcular;
	private JButton btnLimpiar;
	private JLabel lblResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio02 window = new Ejercicio02();
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
	public Ejercicio02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 302, 273);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNum1 = new JLabel("Numero 1");
		GridBagConstraints gbc_lblNum1 = new GridBagConstraints();
		gbc_lblNum1.anchor = GridBagConstraints.EAST;
		gbc_lblNum1.insets = new Insets(15, 15, 5, 5);
		gbc_lblNum1.gridx = 0;
		gbc_lblNum1.gridy = 0;
		frame.getContentPane().add(lblNum1, gbc_lblNum1);
		
		text1 = new JTextField();
		GridBagConstraints gbc_text1 = new GridBagConstraints();
		gbc_text1.anchor = GridBagConstraints.EAST;
		gbc_text1.insets = new Insets(15, 0, 5, 15);
		gbc_text1.gridx = 1;
		gbc_text1.gridy = 0;
		frame.getContentPane().add(text1, gbc_text1);
		text1.setColumns(10);
		
		JLabel lblNum2 = new JLabel("Numero 2");
		GridBagConstraints gbc_lblNum2 = new GridBagConstraints();
		gbc_lblNum2.anchor = GridBagConstraints.EAST;
		gbc_lblNum2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNum2.gridx = 0;
		gbc_lblNum2.gridy = 1;
		frame.getContentPane().add(lblNum2, gbc_lblNum2);
		
		text2 = new JTextField();
		GridBagConstraints gbc_text2 = new GridBagConstraints();
		gbc_text2.anchor = GridBagConstraints.EAST;
		gbc_text2.insets = new Insets(0, 0, 5, 15);
		gbc_text2.gridx = 1;
		gbc_text2.gridy = 1;
		frame.getContentPane().add(text2, gbc_text2);
		text2.setColumns(10);
		
		JLabel lblNum3 = new JLabel("Numero 3");
		GridBagConstraints gbc_lblNum3 = new GridBagConstraints();
		gbc_lblNum3.anchor = GridBagConstraints.EAST;
		gbc_lblNum3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNum3.gridx = 0;
		gbc_lblNum3.gridy = 2;
		frame.getContentPane().add(lblNum3, gbc_lblNum3);
		
		text3 = new JTextField();
		GridBagConstraints gbc_text3 = new GridBagConstraints();
		gbc_text3.anchor = GridBagConstraints.EAST;
		gbc_text3.insets = new Insets(0, 0, 5, 15);
		gbc_text3.gridx = 1;
		gbc_text3.gridy = 2;
		frame.getContentPane().add(text3, gbc_text3);
		text3.setColumns(10);
		
		JLabel lblNum4 = new JLabel("Numero 4");
		GridBagConstraints gbc_lblNum4 = new GridBagConstraints();
		gbc_lblNum4.anchor = GridBagConstraints.EAST;
		gbc_lblNum4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNum4.gridx = 0;
		gbc_lblNum4.gridy = 3;
		frame.getContentPane().add(lblNum4, gbc_lblNum4);
		
		text4 = new JTextField();
		GridBagConstraints gbc_text4 = new GridBagConstraints();
		gbc_text4.anchor = GridBagConstraints.EAST;
		gbc_text4.insets = new Insets(0, 0, 5, 15);
		gbc_text4.gridx = 1;
		gbc_text4.gridy = 3;
		frame.getContentPane().add(text4, gbc_text4);
		text4.setColumns(10);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"SUMAR", "RESTAR", "MULTIPLICAR", "DIVIDIR"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(15, 0, 5, 15);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 4;
		frame.getContentPane().add(comboBox, gbc_comboBox);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 5;
		frame.getContentPane().add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnCalcular = new JButton("CALCULAR");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String numero1 = text1.getText();
				String numero2 = text2.getText();
				String numero3 = text3.getText();
				String numero4 = text4.getText();
			
				try {
					// convertimos a numero
					float n1 = Float.parseFloat(numero1);
					float n2 = Float.parseFloat(numero2);
					float n3 = Float.parseFloat(numero3);
					float n4 = Float.parseFloat(numero4);
					float r = 0;
					// realizamos el la suma
				if(comboBox.getSelectedIndex()==0) {
					 r = n1 + n2 + n3 + n4;
				}
				if(comboBox.getSelectedIndex()==1) {
					r = n1-n2-n3-n4;
				}
				if(comboBox.getSelectedIndex()==2) {
					r = n1*n2*n3*n4;
				}
				if(comboBox.getSelectedIndex()==3) {
					r = n1/n2/n3/n4;
				}
					// escribimos el resultado
					lblResultado.setText(r + "");
				} catch (NumberFormatException ex) {
					lblResultado.setText("ERROR");
					JOptionPane.showMessageDialog(frame, "No se puede realizar el calculo", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

			
			}
		});
		panel_1.add(btnCalcular);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblResultado.setText("-");
				text1.setText("");
				text2.setText("");
				text3.setText("");
				text4.setText("");

			
			
			
			}
		});
		panel_1.add(btnLimpiar);
		
		lblResultado = new JLabel("-");
		panel.add(lblResultado, BorderLayout.WEST);
	}

}
