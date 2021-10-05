import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Principal88 {

	private JFrame frame;
	private JTable table;
	private JPanel panel;
	private JButton add;
	private JButton delete;
	private JButton change;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		Object []  columnNames = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};
		Object [][] rowData = {
				{"Mate", "Ingles", "Ingles","Infor","Lengua"},
				{"Soci", "Ingles", "Lengua", "Mate", "Lengua"},
				{"Soci", "Mate", "Soci", "Mate", "Lengua"},
				{"Gim" , "Gim" , "Soci", "Mate", "Ingles"},
		};
		table = new JTable(rowData, columnNames);
		table.setModel(new DefaultTableModel(rowData, columnNames) );
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		add = new JButton("Add new row");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				Object [] rowData = {"Plastica", "Gim", "Soci", "Mate", "Lengua"};
				dtm.addRow(rowData);
			}
		});
		panel.add(add);
		
		delete = new JButton("Delete row");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				int filaSeleccionada = table.getSelectedRow();
				if(filaSeleccionada != -1) dtm.removeRow(filaSeleccionada);
			}
		});
		panel.add(delete);
		
		change = new JButton("Set to Gim");
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				int filaSeleccionada = table.getSelectedRow();
				int columSeleccionada = table.getSelectedColumn();
				if(filaSeleccionada != -1) {
					dtm.setValueAt("Gim", filaSeleccionada, columSeleccionada);
				}
			}
		});
		panel.add(change);
	}

}
