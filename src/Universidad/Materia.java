package Universidad;

import java.util.*;

public class Materia {

    private Set<Alumno> alumnos = new HashSet<>();

    private String nombre;

    private String id_materia;

    public Materia(String nombre, String id_materia) {
        this.nombre = nombre;
        this.id_materia = id_materia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId_materia() {
        return id_materia;
    }

    public void setId_materia(String id_materia) {
        this.id_materia = id_materia;
    }

    public void verAlumnos() {
    }
}
