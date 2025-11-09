import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTextArea;

/**
 * C:ass ini digunakan untuk menampilkan semua data dari tabel users.
 * Prosesnya juga dijalankan di thread terpisah agar GUI tidak membeku.
 */

public class LoadTask implements Runnable {
    private JTextArea textArea;

    public LoadTask(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void run() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            // Jalankan query SELECT
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            StringBuilder sb = new StringBuilder();
            // Loop untuk menampilkan hasil
            while (rs.next()) {
                sb.append("ID: ").append(rs.getInt("id"))
                  .append(" | Nama: ").append(rs.getString("name"))
                  .append(" | Email: ").append(rs.getString("email"))
                  .append("\n");
            }
            // Menampilkan hasil ke area teks
            textArea.setText(sb.toString());
        } catch (Exception e) {
            textArea.setText("Gagal memuat data: " + e.getMessage());
        }
    }
}
