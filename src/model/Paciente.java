package model;

import java.util.Date;

public class Paciente {
    private int id;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String dni;
    private String frecuencia;

    public Paciente() {
    }

    public Paciente(String nombre, String apellido, Date fechaNacimiento, String dni, String frecuencia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.frecuencia = frecuencia;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
  
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public Date getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getFrecuencia() { return frecuencia; }
    public void setFrecuencia(String frecuencia) { this.frecuencia = frecuencia; }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", dni='" + dni + '\'' +
                ", frecuencia='" + frecuencia + '\'' +
                '}';
}
}
