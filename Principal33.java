import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal33 {

	private JFrame frame;
	private JTextField num1;
	private JTextField num2;
	private JTextField num3;
	private JTextField num4;
	private JComboBox operacion;
	private JLabel resultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
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
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("N\u00FAmero 1");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		num1 = new JTextField();
		GridBagConstraints gbc_num1 = new GridBagConstraints();
		gbc_num1.insets = new Insets(0, 0, 5, 0);
		gbc_num1.fill = GridBagConstraints.HORIZONTAL;
		gbc_num1.gridx = 1;
		gbc_num1.gridy = 0;
		frame.getContentPane().add(num1, gbc_num1);
		num1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("N\u00FAmero 2");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		num2 = new JTextField();
		GridBagConstraints gbc_num2 = new GridBagConstraints();
		gbc_num2.insets = new Insets(0, 0, 5, 0);
		gbc_num2.fill = GridBagConstraints.HORIZONTAL;
		gbc_num2.gridx = 1;
		gbc_num2.gridy = 1;
		frame.getContentPane().add(num2, gbc_num2);
		num2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00FAmero 3");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		num3 = new JTextField();
		GridBagConstraints gbc_num3 = new GridBagConstraints();
		gbc_num3.insets = new Insets(0, 0, 5, 0);
		gbc_num3.fill = GridBagConstraints.HORIZONTAL;
		gbc_num3.gridx = 1;
		gbc_num3.gridy = 2;
		frame.getContentPane().add(num3, gbc_num3);
		num3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("N\u00FAmero 4");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		frame.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		num4 = new JTextField();
		GridBagConstraints gbc_num4 = new GridBagConstraints();
		gbc_num4.insets = new Insets(0, 0, 5, 0);
		gbc_num4.fill = GridBagConstraints.HORIZONTAL;
		gbc_num4.gridx = 1;
		gbc_num4.gridy = 3;
		frame.getContentPane().add(num4, gbc_num4);
		num4.setColumns(10);
		
		operacion = new JComboBox();
		operacion.setModel(new DefaultComboBoxModel(new String[] {"SUMAR", "RESTAR", "MULTI", "DIVID"}));
		GridBagConstraints gbc_operacion = new GridBagConstraints();
		gbc_operacion.insets = new Insets(0, 0, 5, 5);
		gbc_operacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_operacion.gridx = 0;
		gbc_operacion.gridy = 4;
		frame.getContentPane().add(operacion, gbc_operacion);
		
		JButton calcular = new JButton("Calcular");
		calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float n1 = Float.parseFloat( num1.getText() );
				float n2 = Float.parseFloat( num2.getText() );
				float n3 = Float.parseFloat( num3.getText() );
				float n4 = Float.parseFloat( num4.getText() );
				float r = 0;
				int indice = operacion.getSelectedIndex();
				switch(indice) {
					case 0: r = n1+n2+n3+n4; break;
					case 1: r = n1-n2-n3-n4; break;
					case 2: r = n1*n2*n3*n4; break;
					case 3: r = n1/n2/n3/n4; break;
					default: r = 0;
				}
				
				resultado.setText( r + "" );
			}
		});
		GridBagConstraints gbc_calcular = new GridBagConstraints();
		gbc_calcular.insets = new Insets(0, 0, 5, 5);
		gbc_calcular.gridx = 0;
		gbc_calcular.gridy = 5;
		frame.getContentPane().add(calcular, gbc_calcular);
		
		JButton limpiar = new JButton("Limpiar");
		limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1.setText("");
				num2.setText("");
				num3.setText("");
				num4.setText("");
				resultado.setText("0");
				
			}
		});
		GridBagConstraints gbc_limpiar = new GridBagConstraints();
		gbc_limpiar.insets = new Insets(0, 0, 5, 0);
		gbc_limpiar.gridx = 1;
		gbc_limpiar.gridy = 5;
		frame.getContentPane().add(limpiar, gbc_limpiar);
		
		resultado = new JLabel("0");
		GridBagConstraints gbc_resultado = new GridBagConstraints();
		gbc_resultado.anchor = GridBagConstraints.WEST;
		gbc_resultado.insets = new Insets(0, 0, 0, 5);
		gbc_resultado.gridx = 0;
		gbc_resultado.gridy = 6;
		frame.getContentPane().add(resultado, gbc_resultado);
	}

}
