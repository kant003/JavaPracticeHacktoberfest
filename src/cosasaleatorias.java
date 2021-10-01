package interfaz3ConTesteo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana1 {

	private JFrame frame;
	private JTextField txtNum;
	private JLabel lblRes;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana1 window = new Ventana1();
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
	public Ventana1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 267, 182);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		label = new JLabel(" ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		frame.getContentPane().add(label, gbc_label);
		
		JLabel lblNumero = new JLabel("Numero");
		GridBagConstraints gbc_lblNumero = new GridBagConstraints();
		gbc_lblNumero.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumero.gridx = 1;
		gbc_lblNumero.gridy = 1;
		frame.getContentPane().add(lblNumero, gbc_lblNumero);
		
		txtNum = new JTextField();
		GridBagConstraints gbc_txtNum = new GridBagConstraints();
		gbc_txtNum.insets = new Insets(0, 0, 5, 5);
		gbc_txtNum.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNum.gridx = 2;
		gbc_txtNum.gridy = 1;
		frame.getContentPane().add(txtNum, gbc_txtNum);
		txtNum.setColumns(10);
		
		JButton btnCuadrado = new JButton("Cuadrado");
		GridBagConstraints gbc_btnCuadrado = new GridBagConstraints();
		gbc_btnCuadrado.insets = new Insets(0, 0, 5, 5);
		gbc_btnCuadrado.gridx = 2;
		gbc_btnCuadrado.gridy = 2;
		frame.getContentPane().add(btnCuadrado, gbc_btnCuadrado);
		
		lblRes = new JLabel(" ");
		GridBagConstraints gbc_lblRes = new GridBagConstraints();
		gbc_lblRes.insets = new Insets(0, 0, 0, 5);
		gbc_lblRes.gridx = 2;
		gbc_lblRes.gridy = 3;
		frame.getContentPane().add(lblRes, gbc_lblRes);
		
		//////////////////////////////////////////////////////////////eventos

		btnCuadrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int num = Integer.parseInt(txtNum.getText());
				int res = num * num;
				lblRes.setText("Resultado  = "+res);
				
			}
		});
	}

}
