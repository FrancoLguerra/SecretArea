package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Turno;
import model.Paciente;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;


public class TurnoDAO {

    private Connection connection;

    public TurnoDAO(Connection con) {
        this.connection = con;
    }

    public void insert(Turno turno) {
        String sql = "INSERT INTO turnos (fecha, hora, paciente_id) VALUES (?, ?, ?)";
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
        String sql = "UPDATE turnos SET fecha = ?, hora = ?, paciente_id = ? WHERE id = ?";
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
        String sql = "DELETE FROM turnos WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, turno.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM turnos WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void deleteByPacienteId(int pacienteId) {
        String sql = "DELETE FROM turnos WHERE paciente_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, pacienteId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Turno select(Paciente paciente, Date fecha) {
        String sql = "SELECT * FROM turnos WHERE paciente_id = ? AND fecha = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, paciente.getId());
            statement.setDate(2, new java.sql.Date(fecha.getTime()));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Turno turno = new Turno();
                turno.setId(resultSet.getInt("id"));
                turno.setPacienteId(resultSet.getInt("paciente_id"));
                turno.setFecha(resultSet.getDate("fecha"));
                turno.setHora(resultSet.getString("hora"));
                return turno;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // obtengo todos los turnos de una fecha
    public List<Turno> select(Date fecha) {
        List<Turno> turnos = new ArrayList<>();
        String sql = "SELECT * FROM turnos WHERE fecha = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, new java.sql.Date(fecha.getTime()));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Turno turno = new Turno();
                turno.setId(resultSet.getInt("id"));
                turno.setPacienteId(resultSet.getInt("paciente_id"));
                turno.setFecha(resultSet.getDate("fecha"));
                turno.setHora(resultSet.getString("hora"));
                turnos.add(turno);
            }
            return turnos;
        } catch (SQLException e) {
            e.printStackTrace();
}
        return null;
    }
}
