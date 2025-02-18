package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Turno;
import model.Paciente;
import java.sql.ResultSet;
import java.util.Date;

public class TurnoDAO {

    private Connection connection;

    public TurnoDAO(Connection con) {
        this.connection = con;
    }

    public void insert(Turno turno) {
        String sql = "INSERT INTO turno (fecha, hora, id_paciente) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, new java.sql.Date(turno.getFecha().getTime()));
            statement.setString(2, turno.getHora());
            statement.setInt(3, turno.getPacienteId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Turno turno) {
        String sql = "UPDATE turno SET fecha = ?, hora = ?, id_paciente = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, new java.sql.Date(turno.getFecha().getTime()));
            statement.setString(2, turno.getHora());
            statement.setInt(3, turno.getPacienteId());
            statement.setInt(4, turno.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Turno turno) {
        String sql = "DELETE FROM turno WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, turno.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM turno WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void deleteByPacienteId(int pacienteId) {
        String sql = "DELETE FROM turno WHERE id_paciente = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, pacienteId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Turno select(Paciente paciente, Date fecha) {
        String sql = "SELECT * FROM turno WHERE id_paciente = ? AND fecha = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, paciente.getId());
            statement.setDate(2, new java.sql.Date(fecha.getTime()));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Turno turno = new Turno();
                turno.setId(resultSet.getInt("id"));
                turno.setPacienteId(resultSet.getInt("id_paciente"));
                turno.setFecha(resultSet.getDate("fecha"));
                turno.setHora(resultSet.getString("hora"));
                return turno;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // retorno todos los turnos del día
    public Turno select(Date fecha) {
        String sql = "SELECT * FROM turno WHERE fecha = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, new java.sql.Date(fecha.getTime()));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Turno turno = new Turno();
                turno.setId(resultSet.getInt("id"));
                turno.setPacienteId(resultSet.getInt("id_paciente"));
                turno.setFecha(resultSet.getDate("fecha"));
                turno.setHora(resultSet.getString("hora"));
                return turno;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }
}
