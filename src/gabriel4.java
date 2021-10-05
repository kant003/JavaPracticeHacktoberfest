package Ejercicios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.List;
import javax.swing.JTree;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import java.awt.Point;
import javax.swing.JSlider;

public class ComponentesEjemplo {

	private JFrame frame;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComponentesEjemplo window = new ComponentesEjemplo();
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
	public ComponentesEjemplo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 442, 511);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel pestana2 = new JPanel();
		tabbedPane.addTab("New tab", null, pestana2, null);
		
		JPanel pestana3 = new JPanel();
		tabbedPane.addTab("New tab", null, pestana3, null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Guardar");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cargar");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Salir");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); //Se sale
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Editar");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_2);
		
		ButtonGroup bg = new ButtonGroup();
		
		JPanel pestana1 = new JPanel();
		tabbedPane.addTab("Componentes", null, pestana1, null);
		pestana1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Casado");
		chckbxNewCheckBox.setSelected(true);
		pestana1.add(chckbxNewCheckBox);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		pestana1.add(rdbtnMasculino);
		
		JRadioButton rdbtnFemenino = new JRadioButton("Femenino");
		pestana1.add(rdbtnFemenino);
		bg.add(rdbtnFemenino);
		bg.add(rdbtnMasculino);
		
		JButton btnNewButton = new JButton("Encender");
		pestana1.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setRows(3);
		textArea.setColumns(20);
		pestana1.add(textArea);
		
		JEditorPane editorPane = new JEditorPane();
		pestana1.add(editorPane);
		
		JSpinner spinner = new JSpinner();
		pestana1.add(spinner);
		
		textField_1 = new JTextField();
		pestana1.add(textField_1);
		textField_1.setColumns(10);
		
		JTree tree = new JTree();
		pestana1.add(tree);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(50);
		progressBar.setLocation(new Point(10, 0));
		pestana1.add(progressBar);
		
		JSlider slider = new JSlider();
		pestana1.add(slider);
	}

}
