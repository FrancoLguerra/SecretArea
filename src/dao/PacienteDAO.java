package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Paciente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
    private Connection connection;

    public PacienteDAO(Connection con) {
        this.connection = con;
    }

    public void insert(Paciente paciente) {
        String sql = "INSERT INTO pacientes (nombre, apellido, fecha_nacimiento, dni, frecuencia) VALUES (?, ?, ?, ?, ?)";
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
        String sql = "UPDATE pacientes SET nombre = ?, apellido = ?, fecha_nacimiento = ?, dni = ?, frecuencia = ? WHERE id = ?";
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
        String sql = "DELETE FROM pacientes WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, paciente.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM pacientes WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public Paciente select(int id) {
        String sql = "SELECT * FROM pacientes WHERE id = ?";
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
        String sql = "SELECT * FROM pacientes WHERE dni = ?";
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
        String sql = "SELECT * FROM pacientes WHERE nombre = ? AND apellido = ?";
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
    //obtengo todos los pacientes
    public List<Paciente> obtenerPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM pacientes";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(resultSet.getInt("id"));
                paciente.setNombre(resultSet.getString("nombre"));
                paciente.setApellido(resultSet.getString("apellido"));
                paciente.setFechaNacimiento(resultSet.getDate("fecha_nacimiento"));
                paciente.setDni(resultSet.getString("dni"));
                paciente.setFrecuencia(resultSet.getString("frecuencia"));
                pacientes.add(paciente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacientes;
    }


}
