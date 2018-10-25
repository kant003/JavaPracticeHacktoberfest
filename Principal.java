package com.cebem.src;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Principal {

	private JFrame frame;
	private JTextField txtNumero;
	private JButton btnCalcular;
	private JLabel lblEsPerfecto;
	private JLabel lblListaDivisores;
	private JLabel lblEntre;
	private JLabel lblListaDivisoresResultado;
	private JLabel lblEntreResultado;

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
		frame.setResizable(false);
		frame.setBounds(100, 100, 424, 251);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 137, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewNum = new JLabel("Introduce un N\u00FAmero");
		GridBagConstraints gbc_lblNewNum = new GridBagConstraints();
		gbc_lblNewNum.insets = new Insets(20, 10, 10, 5);
		gbc_lblNewNum.anchor = GridBagConstraints.EAST;
		gbc_lblNewNum.gridx = 0;
		gbc_lblNewNum.gridy = 0;
		frame.getContentPane().add(lblNewNum, gbc_lblNewNum);
		
		txtNumero = new JTextField();
		GridBagConstraints gbc_txtNumero = new GridBagConstraints();
		gbc_txtNumero.insets = new Insets(20, 0, 10, 5);
		gbc_txtNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumero.gridx = 1;
		gbc_txtNumero.gridy = 0;
		frame.getContentPane().add(txtNumero, gbc_txtNumero);
		txtNumero.setColumns(10);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				NumeroPerfectoUtil util = new NumeroPerfectoUtil();
				String texto = txtNumero.getText();
				int numero = Integer.parseInt(texto);
				boolean esPerfecto = util.isPerfect(numero);
				if(esPerfecto) {
					lblEsPerfecto.setText(numero + " es perfecto");
				}else {
					lblEsPerfecto.setText(numero + " no es perfecto");
				}
				
				//Calcular lista de divisores
				ArrayList<Integer> listaDivisores = util.getDivisores(numero);
				lblListaDivisores.setText("Los divisores de " + numero +" son");
				lblListaDivisoresResultado.setText(listaDivisores.toString());
				
				//Calcular la lista de nº perfecto
				
				
				Thread hilo = new Thread(new Runnable() {

					@Override
					public void run() {
						btnCalcular.setEnabled(false);
					ArrayList<Integer> listaPerfectos = util.getFirstPerfects(numero);	
					lblEntre.setText("Los nº perfectos entre 0 y " + numero+ " son:");
					lblEntreResultado.setText(listaPerfectos.toString());
					btnCalcular.setEnabled(true);
						
					}
					
				});
				hilo.start();

			}
		});
		GridBagConstraints gbc_btnCalcular = new GridBagConstraints();
		gbc_btnCalcular.insets = new Insets(20, 10, 5, 20);
		gbc_btnCalcular.gridx = 2;
		gbc_btnCalcular.gridy = 0;
		frame.getContentPane().add(btnCalcular, gbc_btnCalcular);
		
		lblEsPerfecto = new JLabel("? es un numero perfecto");
		GridBagConstraints gbc_lblEsPerfecto = new GridBagConstraints();
		gbc_lblEsPerfecto.anchor = GridBagConstraints.EAST;
		gbc_lblEsPerfecto.insets = new Insets(10, 10, 10, 5);
		gbc_lblEsPerfecto.gridx = 0;
		gbc_lblEsPerfecto.gridy = 1;
		frame.getContentPane().add(lblEsPerfecto, gbc_lblEsPerfecto);
		
		lblListaDivisores = new JLabel("Los divisores de ? son");
		GridBagConstraints gbc_lblListaDivisores = new GridBagConstraints();
		gbc_lblListaDivisores.anchor = GridBagConstraints.EAST;
		gbc_lblListaDivisores.insets = new Insets(10, 10, 10, 5);
		gbc_lblListaDivisores.gridx = 0;
		gbc_lblListaDivisores.gridy = 2;
		frame.getContentPane().add(lblListaDivisores, gbc_lblListaDivisores);
		
		lblListaDivisoresResultado = new JLabel("-");
		GridBagConstraints gbc_lblListaDivisoresResultado = new GridBagConstraints();
		gbc_lblListaDivisoresResultado.anchor = GridBagConstraints.WEST;
		gbc_lblListaDivisoresResultado.insets = new Insets(0, 0, 5, 5);
		gbc_lblListaDivisoresResultado.gridx = 1;
		gbc_lblListaDivisoresResultado.gridy = 2;
		frame.getContentPane().add(lblListaDivisoresResultado, gbc_lblListaDivisoresResultado);
		
		lblEntre = new JLabel("Los numeros perfectos entre 0 y ?");
		GridBagConstraints gbc_lblEntre = new GridBagConstraints();
		gbc_lblEntre.anchor = GridBagConstraints.EAST;
		gbc_lblEntre.insets = new Insets(10, 10, 10, 5);
		gbc_lblEntre.gridx = 0;
		gbc_lblEntre.gridy = 3;
		frame.getContentPane().add(lblEntre, gbc_lblEntre);
		
		lblEntreResultado = new JLabel("-");
		GridBagConstraints gbc_lblEntreResultado = new GridBagConstraints();
		gbc_lblEntreResultado.anchor = GridBagConstraints.WEST;
		gbc_lblEntreResultado.insets = new Insets(0, 0, 0, 5);
		gbc_lblEntreResultado.gridx = 1;
		gbc_lblEntreResultado.gridy = 3;
		frame.getContentPane().add(lblEntreResultado, gbc_lblEntreResultado);
	}

}
