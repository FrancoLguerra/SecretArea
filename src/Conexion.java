import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://mysql-secretarea.alwaysdata.net:3306/secretarea_db";  // Reemplaza con el host de AlwaysData y tu base de datos
    private static final String USUARIO = "400223";  // Reemplaza con tu usuario de AlwaysData
    private static final String CONTRASEÑA = "Biel2812.";  // Reemplaza con tu contraseña de AlwaysData

    public static Connection conectar() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("✅ Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.err.println("⛔ Error: No se encontró el driver de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("⛔ Error de conexión a la base de datos.");
            e.printStackTrace();
        }
        return conexion;
    }

    public static void main(String[] args) {
        conectar();
    }
}
