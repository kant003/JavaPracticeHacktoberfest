package com.hacktoberfest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RandomImage {

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

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduzca la anchura de la imagen: ");
		int width = teclado.nextInt();
		System.out.print("Introduzca la altura de la imagen: ");
		int height = teclado.nextInt();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		image = setRandomPixels(image);

		JFrame frame = new JFrame();
		frame.setSize(width, height);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(new ImagePanel(image));
		frame.setVisible(true);
		
		teclado.close();
	}

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
