package ulp.entidades;

public class Materia {

    private int id_materia;
    private String nombre_materia;

    public Materia() {
    }

    public Materia(String nombre_materia) {
        this.nombre_materia = nombre_materia;
    }

    public Materia(int id_materia, String nombre_materia) {
        this.id_materia = id_materia;
        this.nombre_materia = nombre_materia;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public String getNombre_materia() {
        return nombre_materia;
    }

    public void setNombre_materia(String nombre_materia) {
        this.nombre_materia = nombre_materia;
    }

    @Override
    public String toString() {
        return "Materia{" + "id_materia=" + id_materia + ", nombre_materia=" + nombre_materia + '}';
    }
    
    
}
