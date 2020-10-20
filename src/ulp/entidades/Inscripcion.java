package ulp.entidades;

public class Inscripcion {

    private int id_inscripcion;
    private Alumno alumno;
    private Materia materia;
    private double calificacion;

    public Inscripcion() {
    }

    public Inscripcion(Alumno alumno, Materia materia, double calificacion) {
        this.alumno = alumno;
        this.materia = materia;
        this.calificacion = calificacion;
    }

    public Inscripcion(int id_inscripcion, Alumno alumno, Materia materia, double calificacion) {
        this.id_inscripcion = id_inscripcion;
        this.alumno = alumno;
        this.materia = materia;
        this.calificacion = calificacion;
    }

    public int getId_inscripcion() {
        return id_inscripcion;
    }

    public void setId_inscripcion(int id_inscripcion) {
        this.id_inscripcion = id_inscripcion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "id_inscripcion=" + id_inscripcion + ", alumno=" + alumno + ", materia=" + materia + ", calificacion=" + calificacion + '}';
    }

}
