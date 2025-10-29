import javax.swing.SwingUtilities;

public class Test {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PiscinaPendeja f = new PiscinaPendeja();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}