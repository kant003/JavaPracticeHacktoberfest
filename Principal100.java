import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class Principal100 {

	private JFrame frame;
	private JCheckBox spinnerCheck;
	private JSpinner spinner;
	private JRadioButton opcionMasculino;
	private JRadioButton opcionFemenino;
	private JSlider slider;

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
		
		JSplitPane splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		splitPane.setRightComponent(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Alumnos", null, panel, null);
		
		spinnerCheck = new JCheckBox("Spinner Activado");
		spinnerCheck.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(slider==null) return;
				slider.setEnabled( spinnerCheck.isSelected() );
			}
		});
		spinnerCheck.setSelected(true);
		panel.add(spinnerCheck);
		
		opcionMasculino = new JRadioButton("Masculino");
		panel.add(opcionMasculino);
		
		opcionFemenino = new JRadioButton("Femenino");
		panel.add(opcionFemenino);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(5, 1, 10, 1));
		panel.add(spinner);
		
		slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int valor = slider.getValue();
				spinner.setValue(valor);
			}
		});
		
		slider.setValue(5);
		slider.setMinimum(1);
		slider.setMaximum(10);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		panel.add(slider);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Profesores", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Asignaturas", null, panel_2, null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Guardar");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Acerca De");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Version");
		mnNewMenu_1.add(mntmNewMenuItem_2);
	}

}
