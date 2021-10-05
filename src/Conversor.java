package com.cebem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
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
		frame.setResizable(false);
		frame.setBounds(100, 100, 369, 140);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		texto = new JTextField();
		texto.setHorizontalAlignment(SwingConstants.LEFT);
		texto.setBounds(10, 11, 333, 39);
		frame.getContentPane().add(texto);
		texto.setColumns(10);
		
		JButton convertir = new JButton("Convertir");
		convertir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// ver lo que hay escrito en la caja de texto
				String t = texto.getText(); 
				
				// pasar texto a mayusculas
				String textoMayus = t.toUpperCase();
				
				// escribit el texto convertido en la caja de texto
				texto.setText(textoMayus);
			}
		});
		convertir.setBounds(235, 61, 108, 29);
		frame.getContentPane().add(convertir);
	}
}
