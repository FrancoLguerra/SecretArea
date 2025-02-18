package model;
import java.util.Date;

public class Turno {
    private int id;
    private int pacienteId;
    private Date fecha;
    private String hora;

    public Turno() {
    }
    public Turno(int pacienteId, Date fecha, String hora) {
        this.pacienteId = pacienteId;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() { return id; }

    public int getPacienteId() { return pacienteId; }
    public void setPacienteId(int pacienteId) { this.pacienteId = pacienteId; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", pacienteId=" + pacienteId +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                '}';
    }
}
