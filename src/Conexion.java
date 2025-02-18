import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import dao.PacienteDAO;
import dao.TurnoDAO;

public class Conexion {
    private static final String URL = "jdbc:mysql://mysql-secretarea.alwaysdata.net:3306/secretarea_db";  // Reemplaza con el host de AlwaysData y tu base de datos
    private static final String USUARIO = "400223";  // Reemplaza con tu usuario de AlwaysData
    private static final String CONTRASEÑA = System.getenv("DB_SECRETAREA_PASSWORD");  // Reemplaza con tu contraseña de AlwaysData  

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

    public static PacienteDAO getPacienteDAO() throws SQLException {
        return new PacienteDAO(conectar());
    }

    public static TurnoDAO getTurnoDAO() throws SQLException {
        return new TurnoDAO(conectar());
    }

    public static void main(String[] args) {
        conectar();
    }
}
