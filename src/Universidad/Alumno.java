package Universidad;

import java.util.*;

public class Alumno {

    private String nombre;

    private String apellido;

    private String dni;

    private String legajo;

    private Set<Materia> materias = new HashSet<>();

    public Alumno(String nombre, String apellido, String dni, String legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.legajo = legajo;
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

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public void inscribir(Materia materia) {
    }

    public void desinscribir(Materia materia) {
    }

    public void verMaterias() {
    }

    public void registrarNota(Materia materia, double nota) {
    }
}
