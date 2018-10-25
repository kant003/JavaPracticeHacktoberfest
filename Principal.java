package tablasMovedizas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frame;
	private JTextField textNombre;
	private JTable table;

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
		rellenarTablaPorDefecto();
		
		
	}

	private void rellenarTablaPorDefecto() {
	DefaultTableModel dtm =(DefaultTableModel) table.getModel();
		dtm.addColumn("Nombre");
		dtm.addColumn("Puntuacion");
		
		Object[] datos = {"David","10"};
		dtm.addRow(datos);


	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JPanel panelForm = new JPanel();
		splitPane.setLeftComponent(panelForm);
		GridBagLayout gbl_panelForm = new GridBagLayout();
		gbl_panelForm.columnWidths = new int[]{0, 0};
		gbl_panelForm.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panelForm.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelForm.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelForm.setLayout(gbl_panelForm);
		
		JLabel label = new JLabel("Nombre");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panelForm.add(label, gbc_label);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textNombre.gridx = 0;
		gbc_textNombre.gridy = 1;
		panelForm.add(textNombre, gbc_textNombre);
		
		JLabel label_1 = new JLabel("Puntuacion");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 2;
		panelForm.add(label_1, gbc_label_1);
		
		JSpinner spinner = new JSpinner();
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 0);
		gbc_spinner.gridx = 0;
		gbc_spinner.gridy = 3;
		panelForm.add(spinner, gbc_spinner);
		
		JButton button = new JButton("A\u00D1ADIR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel dtm =(DefaultTableModel) table.getModel();
				Object[] datos = {textNombre.getText(), spinner.getValue().toString()};
				dtm.addRow(datos);
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 0;
		gbc_button.gridy = 4;
		panelForm.add(button, gbc_button);
		
		JButton btnMedia = new JButton("MEDIA");
		btnMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(frame, "La media total de puntuacion es " + calcularMedia());
				
				
			}
		});
		
		
		
		GridBagConstraints gbc_btnMedia = new GridBagConstraints();
		gbc_btnMedia.gridx = 0;
		gbc_btnMedia.gridy = 5;
		panelForm.add(btnMedia, gbc_btnMedia);
		
		JPanel panelTabla = new JPanel();
		splitPane.setRightComponent(panelTabla);
		panelTabla.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelTabla.add(scrollPane);
		
		table = new JTable();
		//poner esto siempre
		table.setModel(new DefaultTableModel());
		
		scrollPane.setViewportView(table);
	}
	public float calcularMedia() {
		float media;
		float suma = 0;
		DefaultTableModel dtm =(DefaultTableModel) table.getModel();
		for(int i = 0; i<dtm.getRowCount();i++) {
			Object valorCelda  = dtm.getValueAt(i, 1);
			float puntuacion = Float.parseFloat( (String) valorCelda);
			suma +=puntuacion;
		}
		return media = suma/dtm.getRowCount();
	}
}
