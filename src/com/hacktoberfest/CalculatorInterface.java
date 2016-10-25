package com.hacktoberfest;


import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CalculatorInterface {

	private JFrame frame;
	private JTextField n2;
	private JTextField n1;
	private JLabel resultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorInterface window = new CalculatorInterface();
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
	public CalculatorInterface() {
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

		n1 = new JTextField();
		frame.getContentPane().add(n1);
		n1.setColumns(10);

		n2 = new JTextField();
		frame.getContentPane().add(n2);
		n2.setColumns(10);

		JButton sumar = new JButton("Sumar");
		sumar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String t1 = n1.getText();
				String t2 = n2.getText();
				int num1 = Integer.parseInt(t1);
				int num2 = Integer.parseInt(t2);
				int res = num1 + num2;
				String resul = String.valueOf(res);
				resultado.setText(resul);
			}
		});
		frame.getContentPane().add(sumar);

		resultado = new JLabel("RESULTADO");
		frame.getContentPane().add(resultado);
	}

	public JTextField getN1() {
		return n1;
	}

	public JTextField getN2() {
		return n2;
	}

	public JLabel getResultado() {
		return resultado;
	}
}
