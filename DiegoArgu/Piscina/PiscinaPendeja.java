import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;

public class PiscinaPendeja extends JFrame {

    private final Random random = new Random();

    private final JComboBox<String> capacidadCombo;
    private final JTextArea areaTexto;

    private final JPanel panelPruebas;
    private final JButton llenar, vaciar, llenarTodo, vaciarTodo;
    private final JSlider slider;

    private Piscina piscina;
    private int capacidad;

    public PiscinaPendeja() {
        super("Ejercicio De la ****** piscina");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(720, 420));

        JPanel general = new JPanel(new GridBagLayout());
        general.setBorder(BorderFactory.createEmptyBorder(16, 16, 8, 16));
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(4, 4, 4, 4);
        gc.gridy = 0;

        JLabel titulo = new JLabel("Capacidad de la **** Piscina en m3:");
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD));
        titulo.setForeground(new Color(180, 20, 20));

        String[] capacidades = { "1.0", "1.1", "1.2", "1.3", "1.4", "1.5" };
        capacidadCombo = new JComboBox<>(capacidades);
        capacidadCombo.setPreferredSize(new Dimension(80, 25));

        JButton probarBtn = new JButton("Probar Piscina");
        probarBtn.addActionListener(e -> probarPiscina());

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.WEST;
        general.add(titulo, gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.CENTER;
        general.add(capacidadCombo, gc);
        gc.gridx = 2;
        gc.anchor = GridBagConstraints.EAST;
        general.add(probarBtn, gc);

        JPanel botones = new JPanel(new GridBagLayout());
        GridBagConstraints gbcBtns = new GridBagConstraints();
        gbcBtns.insets = new Insets(6, 16, 6, 16);

        llenar = new JButton("Llenar");
        llenar.setBackground(new Color(0, 170, 0));
        llenar.setForeground(Color.WHITE);
        llenar.addActionListener(e -> operarPiscina(true));

        llenarTodo = new JButton("Llenar del todo");
        llenarTodo.setBackground(new Color(0, 170, 0));
        llenarTodo.setForeground(Color.WHITE);
        llenarTodo.addActionListener(e -> llenarTodoAction());

        vaciar = new JButton("Vaciar");
        vaciar.setBackground(new Color(200, 60, 60));
        vaciar.setForeground(Color.WHITE);
        vaciar.addActionListener(e -> operarPiscina(false));

        vaciarTodo = new JButton("Vaciar del todo");
        vaciarTodo.setBackground(new Color(200, 60, 60));
        vaciarTodo.setForeground(Color.WHITE);
        vaciarTodo.addActionListener(e -> vaciarTodoAction());

        gbcBtns.gridx = 0;
        botones.add(llenarTodo, gbcBtns);
        gbcBtns.gridx = 1;
        botones.add(llenar, gbcBtns);
        gbcBtns.gridx = 3;
        botones.add(vaciar, gbcBtns);
        gbcBtns.gridx = 4;
        botones.add(vaciarTodo, gbcBtns);

        slider = new JSlider();
        slider.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        areaTexto.setRows(10);
        JScrollPane scroll = new JScrollPane(areaTexto);
        scroll.setPreferredSize(new Dimension(100, 220));
        scroll.setMinimumSize(new Dimension(100, 180));
        scroll.setBorder(BorderFactory.createEmptyBorder(0, 16, 16, 16));

        panelPruebas = new JPanel(new BorderLayout());
        panelPruebas.add(botones, BorderLayout.NORTH);
        panelPruebas.add(slider, BorderLayout.CENTER);
        panelPruebas.add(scroll, BorderLayout.SOUTH);
        panelPruebas.setVisible(false);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(general, BorderLayout.NORTH);
        getContentPane().add(panelPruebas, BorderLayout.CENTER);
    }

    private void probarPiscina() {
        areaTexto.setText("");

        double capacidadM3 = Double.parseDouble((String) capacidadCombo.getSelectedItem()); 
        capacidad = (int) Math.round(capacidadM3 * 1000);

        log(String.format("Capacidad seleccionada: %.1f m³ = %d litros", capacidadM3, capacidad));

        piscina = new Piscina(capacidad);

        slider.setMinimum(0);
        slider.setMaximum(capacidad);
        slider.setMajorTickSpacing(100);
        slider.setMinorTickSpacing(10);
        slider.setValue(0);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setEnabled(false);

        panelPruebas.setVisible(true);
        log("Piscina Vacía: 0");
    }

    private void operarPiscina(boolean llenar) {
        if (piscina == null)
            return;
        int litros = 1 + random.nextInt(500);
        try {
            if (llenar) {
                piscina.llenar(litros);
                int nivelLitros = piscina.getNivel();
                log("Se llenó " + litros + " la piscina");
                log("La piscina tiene ahora: " + nivelLitros + " litros");
                log("--------------------------------------------");
            } else {
                piscina.vaciar(litros);
                int nivelLitros = piscina.getNivel();
                log("Se vaciaron " + litros + " de la piscina");
                log("La piscina tiene ahora: " + nivelLitros + " litros");
                log("--------------------------------------------");
            }
        } catch (Exception ex) {
            log("-----------------------ERROR---------------------");
            log(ex.getMessage());
            log("--------------------------------------------");
        }
        actualizarIndicadores();
    }

    private void llenarTodoAction() {
        if (piscina == null)
            return;
        piscina.llenarTodo();
        actualizarIndicadores();
        log("-----------------------LLENADA---------------------");
        log("Se llenó la piscina del todo");
        log("--------------------------------------------");
    }

    private void vaciarTodoAction() {
        if (piscina == null)
            return;
        piscina.vaciarTodo();
        actualizarIndicadores();
        log("-----------------------VACIADA---------------------");
        log("Se vació la piscina del todo");
        log("--------------------------------------------");
    }

    private void actualizarIndicadores() {
        if (piscina == null)
            return;
        int nivelLitros = piscina.getNivel();
        slider.setValue(nivelLitros);
    }

    private void log(String msg) {
        areaTexto.append(msg);
        areaTexto.append("\n");
    }
}
