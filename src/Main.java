import java.sql.SQLException;
import java.util.Date;

import model.Paciente;
import model.Turno;
import dao.PacienteDAO;
import dao.TurnoDAO;

public class Main {
    
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        Conexion.conectar();
        try {
            // Obtener una instancia del DAO para Paciente
            PacienteDAO pacienteDAO = Conexion.getPacienteDAO();
            
            // Crear un nuevo paciente y agregarlo a la base de datos
         //   Paciente nuevoPaciente = new Paciente( "Franco", "Guerra", new Date(1990-01-01), "381922225", "M");
           // pacienteDAO.insert(nuevoPaciente);
            //System.out.println("Paciente agregado con éxito");

            // Obtener todos los pacientes
            System.out.println("Lista de pacientes:");
            pacienteDAO.obtenerPacientes().forEach(System.out::println);

            // Obtener una instancia del DAO para Turno
            TurnoDAO turnoDAO = Conexion.getTurnoDAO();
            
            // Crear un nuevo turno y agregarlo a la base de datos
           Turno nuevoTurno = new Turno(4, new Date(2025-10-20), "12:00");
            //turnoDAO.insert(nuevoTurno);
            //System.out.println("Turno agregado con éxito");

            // Obtener todos los turnos
            System.out.println("Lista de turnos:");
            turnoDAO.select(nuevoTurno.getFecha()).forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

