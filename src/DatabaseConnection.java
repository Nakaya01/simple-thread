import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class ini berfungsi untuk membuat koneksi ke database MySQL.
 * File ini digunakan oleh semua kelas lain yang butuh akses ke database.
 */

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/thread_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try {
            // Memuat driver JDBC MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver ditemukan!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC tidak ditemukan!");
            e.printStackTrace();
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
