package com.hacktoberfest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Inicio de clase
public class RandomImage {

	// Componentes entorno gráfico
	private static JFrame frame;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JButton btnNewButton;

	// Clase estática ImagePanel para pintar la imagen sobre el frame
	private static class ImagePanel extends JPanel {
		private BufferedImage image;

		public ImagePanel(BufferedImage image) {
			this.image = image;
			repaint();
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
	}

	// Inicio main
	public static void main(String[] args) {

		// Establecer entorno gráfico inicial
		// Frame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		frame.getContentPane().setLayout(gridBagLayout);

		// JLabel anchura
		JLabel lblAnchura = new JLabel("Anchura:");
		GridBagConstraints gbc_lblAnchura = new GridBagConstraints();
		gbc_lblAnchura.anchor = GridBagConstraints.EAST;
		gbc_lblAnchura.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnchura.gridx = 1;
		gbc_lblAnchura.gridy = 0;
		frame.getContentPane().add(lblAnchura, gbc_lblAnchura);

		// textField anchura
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);

		// JLabel altura
		JLabel lblAltura = new JLabel("Altura:");
		GridBagConstraints gbc_lblAltura = new GridBagConstraints();
		gbc_lblAltura.anchor = GridBagConstraints.EAST;
		gbc_lblAltura.insets = new Insets(0, 0, 5, 5);
		gbc_lblAltura.gridx = 1;
		gbc_lblAltura.gridy = 1;
		frame.getContentPane().add(lblAltura, gbc_lblAltura);

		// textField altura
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 1;
		frame.getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		// JButton crear imagen
		btnNewButton = new JButton("Crear imagen");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Llama al método crearImagen() para crear la imagen con los datos que se le pasan en los textFields
				crearImagen();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 3;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);

		frame.setSize(250, 150);
		frame.setVisible(true);
	}

	// Crear la imagen con los datos que se le pasan en los textFields, eliminando los componentes anteriores y mostrando la imagen
	private static void crearImagen() {
		int width = Integer.parseInt(textField.getText());
		int height = Integer.parseInt(textField_1.getText());

		frame.getContentPane().removeAll();
		frame.getContentPane().setLayout(new BorderLayout());

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		image = setRandomPixels(image);
		frame.getContentPane().add(new ImagePanel(image));

		frame.setSize(width, height);

		frame.setVisible(true);
		
		// Guarda el fichero como .jpg
		File outputfile = new File("image.jpg");
		try {
			ImageIO.write(image, "jpg", outputfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Coge la imagen y le pone color aleatorio de 8bits a cada pixel
	private static BufferedImage setRandomPixels(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				int red = (int) (Math.random() * 256);
				int green = (int) (Math.random() * 256);
				int blue = (int) (Math.random() * 256);
				Color color = new Color(red, blue, green);
				image.setRGB(w, h, color.getRGB());
			}
		}
		return image;
	}
}
