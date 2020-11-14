package ulp.entidades;

import java.time.LocalDate;

public class Alumno {

    private int id_alumno;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fecha_n;
    private boolean activo;

    public Alumno() {
    }

    public Alumno(String nombre, String apellido, String dni, LocalDate fecha_n, boolean activo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_n = fecha_n;
        this.activo = activo;
        this.dni = dni;
    }

    public Alumno(int id_alumno, String nombre, String apellido, String dni, LocalDate fecha_n, boolean activo) {
        this.id_alumno = id_alumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_n = fecha_n;
        this.activo = activo;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFecha_n() {
        return fecha_n;
    }

    public void setFecha_n(LocalDate fecha_n) {
        this.fecha_n = fecha_n;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return nombre +"  " + apellido ;
    }

//    @Override
//    public String toString() {
//        return ("Alumno"+this.nombre+" "+this.apellido);
//    }
    
}
