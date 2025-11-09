/**
 * File utama program.
 * Program dijalankan dari class ini, lalu membuka GUIApp.
 */
public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new GUIApp().setVisible(true);
        });
    }
}
