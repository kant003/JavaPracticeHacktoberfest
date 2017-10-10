package com.hacktoberfest;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class Conversor extends JFrame {

	/**
	 * conversor sh0wn3d
	 */
	private static final long serialVersionUID = 1L;

	public static void main (String [] args){
		Conversor frame = new Conversor();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	JPanel panelDecimal;
	JPanel panelBotones;
	JPanel panelHexadecimal;
	JPanel panelBinario;
	JLabel labelDecimal;
	JTextField fieldDecimal;
	JButton botonDecimal;
	JButton botonHexadecimal;
	JButton botonBinario;
	JLabel labelHexadecimal;
	JTextField fieldHexadecimal;
	JLabel labelBinario;
	JTextField fieldBinario;

	public Conversor()
	{
		panelDecimal = new JPanel();
		panelHexadecimal = new JPanel();
		panelBinario = new JPanel();
		panelBotones = new JPanel();
		labelDecimal = new JLabel("Decimal: ");
		fieldDecimal = new JTextField();
		labelHexadecimal = new JLabel("Hexadecimal: ");
		fieldHexadecimal = new JTextField();
		labelBinario = new JLabel("Binario: ");
		fieldBinario = new JTextField();
		botonDecimal = new JButton("Desde Decimal");
		botonHexadecimal = new JButton("Desde Hexadecimal");
		botonBinario = new JButton("Desde Binario");


		panelDecimal.setLayout(new BoxLayout(panelDecimal, BoxLayout.Y_AXIS));
		panelDecimal.add(labelDecimal);
		panelDecimal.add(fieldDecimal);


		panelHexadecimal.setLayout(new BoxLayout(panelHexadecimal, BoxLayout.Y_AXIS));
		panelHexadecimal.add(labelHexadecimal);
		panelHexadecimal.add(fieldHexadecimal);

		panelBinario.setLayout(new BoxLayout(panelBinario, BoxLayout.Y_AXIS));
		panelBinario.add(labelBinario);
		panelBinario.add(fieldBinario);

		botonDecimal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				//Pasar de Decimal a Hexadecimal
				String numeroDecimal = fieldDecimal.getText();
				int decimal = Integer.parseInt(numeroDecimal,10);
				String stringHexa = Integer.toString(decimal,16);
				fieldHexadecimal.setText(stringHexa);

				//Pasar de Decimal a Binario
				String numeroDecimal2 = fieldDecimal.getText();
				int decimal2 = Integer.parseInt(numeroDecimal2,10);
				String stringBinario = Integer.toString(decimal2,2);
				fieldBinario.setText(stringBinario);

			}
		});

		botonHexadecimal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Pasar de Hexadecimal a Decimal
				String numeroHexadecimal = fieldHexadecimal.getText();
				int hexadecimal = Integer.parseInt(numeroHexadecimal,16);
				String stringDecimal = Integer.toString(hexadecimal,10);
				fieldDecimal.setText(stringDecimal);

				//Pasar de Hexadecimal a Binario
				String numeroHexadecimal2 = fieldHexadecimal.getText();
				int hexadecimal2 = Integer.parseInt(numeroHexadecimal2,16);
				String stringBinario = Integer.toString(hexadecimal2,2);
				fieldBinario.setText(stringBinario);

			}
		});

		botonBinario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Pasar de Binario a Decimal
				String numeroBinario = fieldBinario.getText();
				int binario = Integer.parseInt(numeroBinario,2);
				String stringDecimal = Integer.toString(binario,10);
				fieldDecimal.setText(stringDecimal);

				//Pasar de Binario a Hexadecimal
				String numeroBinario2 = fieldBinario.getText();
				int binario2 = Integer.parseInt(numeroBinario2,2);
				String stringHexadecimal = Integer.toString(binario2,16);
				fieldHexadecimal.setText(stringHexadecimal);
			}
		});
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
		panelBotones.add(botonDecimal);
		panelBotones.add(botonHexadecimal);
		panelBotones.add(botonBinario);

		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(panelDecimal);
		getContentPane().add(panelHexadecimal);
		getContentPane().add(panelBinario);
		getContentPane().add(panelBotones);






	}

}
