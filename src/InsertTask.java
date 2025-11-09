import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class ini menjalankan tugas (task) untuk menambahkan data ke database
 * menggunakan thread terpisah agar GUI tidak hang.
 */

public class InsertTask implements Runnable {
    private String name;
    private String email;

    public InsertTask(String name, String email) {
        this.name = name;
        this.email = email;
    }
    // Method yang dijalankan oleh thread
    @Override
    public void run() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Perintah SQL untuk menambah data
            String query = "INSERT INTO users (name, email) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            // Mengisi parameter query
            ps.setString(1, name);
            ps.setString(2, email);
            // Menjalankan query
            ps.executeUpdate();
            System.out.println("Data ditambahkan: " + name + " - " + email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
