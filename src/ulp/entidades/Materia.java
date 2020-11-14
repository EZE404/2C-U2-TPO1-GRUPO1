package ulp.entidades;

import java.util.Objects;

public class Materia implements Comparable{

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
        return id_materia + "-" + nombre_materia;
    }

//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 97 * hash + this.id_materia;
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Materia other = (Materia) obj;
//        if (this.id_materia != other.id_materia) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public int compareTo(Object ob){
    int idM=((Materia)ob).id_materia;
    return id_materia < idM ?-1 :(id_materia==idM ?0:1);
}

  
    
    
}
