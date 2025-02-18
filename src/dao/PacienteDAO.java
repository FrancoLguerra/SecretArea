package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Paciente;

public class PacienteDAO {
    private Connection connection;

    public PacienteDAO(Connection con) {
        this.connection = con;
    }

    public void insert(Paciente paciente) {
        String sql = "INSERT INTO paciente (nombre, apellido, fecha_nacimiento, dni, frecuencia) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, paciente.getNombre());
            statement.setString(2, paciente.getApellido());
            statement.setDate(3, new java.sql.Date(paciente.getFechaNacimiento().getTime()));
            statement.setString(4, paciente.getDni());
            statement.setString(5, paciente.getFrecuencia());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void update(Paciente paciente) {
        String sql = "UPDATE paciente SET nombre = ?, apellido = ?, fecha_nacimiento = ?, dni = ?, frecuencia = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, paciente.getNombre());
            statement.setString(2, paciente.getApellido());
            statement.setDate(3, new java.sql.Date(paciente.getFechaNacimiento().getTime()));
            statement.setString(4, paciente.getDni());
            statement.setString(5, paciente.getFrecuencia());
            statement.setInt(6, paciente.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void delete(Paciente paciente) {
        String sql = "DELETE FROM paciente WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, paciente.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM paciente WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public Paciente select(int id) {
        String sql = "SELECT * FROM paciente WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    public Paciente select(String dni) {
        String sql = "SELECT * FROM paciente WHERE dni = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, dni);
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    public Paciente select(String nombre, String apellido) {
        String sql = "SELECT * FROM paciente WHERE nombre = ? AND apellido = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.setString(2, apellido);
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    
}
