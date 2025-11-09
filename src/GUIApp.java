import java.awt.*;
import javax.swing.*;

/**
 * Class utama yang berisi tampilan GUI untuk input dan tampilan data.
 * Menggunakan dua tombol: "Tambah Data" dan "Muat Data".
 */
public class GUIApp extends JFrame {
    private JTextField nameField, emailField;
    private JTextArea outputArea;
    private JButton insertButton, loadButton;

    public GUIApp() {
        setTitle("Program GUI dengan Thread dan Database");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel input (bagian atas)
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.add(new JLabel("Nama:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        insertButton = new JButton("Tambah Data");
        loadButton = new JButton("Muat Data");

        inputPanel.add(insertButton);
        inputPanel.add(loadButton);

        // Area output (bagian bawah)
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Event tombol Tambah Data
        insertButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();

            // Cek apakah field kosong
            if (name.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama dan Email harus diisi!");
                return;
            }

            // Jalankan thread untuk menyimpan data
            Thread insertThread = new Thread(new InsertTask(name, email));
            insertThread.start();
        });

        // Event tombol Muat Data
        loadButton.addActionListener(e -> {
            // Jalankan thread untuk menampilkan data
            Thread loadThread = new Thread(new LoadTask(outputArea));
            loadThread.start();
        });
    }
}
