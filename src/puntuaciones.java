package ejemplos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class puntuaciones {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					puntuaciones window = new puntuaciones();
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
	public puntuaciones() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Puntuaci\u00F3n:");
		
		textField = new JTextField();
		textField.setColumns(8);
		
		JButton btnNewButton = new JButton("A\u00F1adir puntuaci\u00F3n");
		
		JLabel lblNewLabel_1 = new JLabel("Lista de puntuaciones:                            ");
		
		JList list = new JList();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(83)
					.addComponent(lblNewLabel)
					.addGap(64)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(btnNewButton))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(165)
					.addComponent(lblNewLabel_1))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(83)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton))
					.addGap(5)
					.addComponent(lblNewLabel_1)
					.addGap(5)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
