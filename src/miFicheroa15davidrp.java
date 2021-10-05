package interfaz2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtAge;
	private JList list;

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
		RefrescarLista();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, "panel_a");
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		list = new JList();
		list.setModel(new DefaultListModel<Cliente>());
		
		scrollPane.setViewportView(list);
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_1.add(panel, BorderLayout.NORTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setIcon(new ImageIcon(Principal.class.getResource("/interfaz2/icono.png")));
		panel.add(btnAdd);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, "panel_b");
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblName = new JLabel("Nombre");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(5, 20, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		panel_2.add(lblName, gbc_lblName);
		
		txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 0);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 1;
		panel_2.add(txtName, gbc_txtName);
		txtName.setColumns(10);
		
		JLabel lblAge = new JLabel("Edad");
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.fill = GridBagConstraints.VERTICAL;
		gbc_lblAge.insets = new Insets(5, 20, 5, 5);
		gbc_lblAge.gridx = 0;
		gbc_lblAge.gridy = 2;
		panel_2.add(lblAge, gbc_lblAge);
		
		txtAge = new JTextField();
		GridBagConstraints gbc_txtAge = new GridBagConstraints();
		gbc_txtAge.insets = new Insets(0, 0, 5, 0);
		gbc_txtAge.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAge.gridx = 1;
		gbc_txtAge.gridy = 2;
		panel_2.add(txtAge, gbc_txtAge);
		txtAge.setColumns(10);
		
		JLabel lblActivo = new JLabel("Activo");
		lblActivo.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblActivo = new GridBagConstraints();
		gbc_lblActivo.fill = GridBagConstraints.BOTH;
		gbc_lblActivo.insets = new Insets(5, 20, 5, 5);
		gbc_lblActivo.gridx = 0;
		gbc_lblActivo.gridy = 3;
		panel_2.add(lblActivo, gbc_lblActivo);
		
		JToggleButton btnActivo = new JToggleButton("New toggle button");
		GridBagConstraints gbc_btnActivo = new GridBagConstraints();
		gbc_btnActivo.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnActivo.insets = new Insets(0, 0, 5, 0);
		gbc_btnActivo.gridx = 1;
		gbc_btnActivo.gridy = 3;
		panel_2.add(btnActivo, gbc_btnActivo);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 4;
		panel_2.add(panel_3, gbc_panel_3);
		
		JButton btnSave = new JButton("Guardar");
		panel_3.add(btnSave);
		
		JButton btnComeBack = new JButton("Volver");
		panel_3.add(btnComeBack);
		
		//////////////////////////eventos/////////////////////////////

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl= (CardLayout) frame.getContentPane().getLayout();
				cl.show(frame.getContentPane(), "panel_b");
			}
		});
		

		btnComeBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtName.setText("");
				txtAge.setText("");
				
				CardLayout cl= (CardLayout) frame.getContentPane().getLayout();
				cl.show(frame.getContentPane(), "panel_a");
			}
		});
	}

	/////////////////////////otros metodos////////////////////////////
	
	
	private void RefrescarLista() {
		try {
			ArrayList <Cliente> listaCliente = ServicioCliente.GetAll();

			DefaultListModel<Cliente> dlm= (DefaultListModel<Cliente>) list.getModel();
			dlm.clear();
			for(Cliente c : listaCliente) {
				dlm.addElement(c);
			}
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frame, "Error al refrescar", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}
