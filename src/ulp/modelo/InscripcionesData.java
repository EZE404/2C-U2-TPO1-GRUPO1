package ulp.modelo;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import ulp.entidades.Alumno;
import ulp.entidades.Inscripcion;
import ulp.entidades.Materia;

public class InscripcionesData {

    private Conexion conexion;
    private Connection c;

    public InscripcionesData(Conexion conexion) {
        this.conexion = conexion;
    }

    public void inscribir_alumno(Inscripcion inscripcion) {
        c = conexion.getConnection();

        String pre_instruccion = "INSERT INTO registro (id_alumno, id_materia, nota) VALUES (?, ?, ?);";
        try {
            // CREANDO PREPARED STATEMENT
            PreparedStatement instruccion = c.prepareStatement(pre_instruccion, Statement.RETURN_GENERATED_KEYS);
            // LLENANDO SIGNOS '?'
            instruccion.setInt(1, inscripcion.getAlumno().getId_alumno());
            instruccion.setInt(2, inscripcion.getMateria().getId_materia());
            instruccion.setDouble(3, inscripcion.getCalificacion());
            // EJECUTANDO Y GUARDANDO LLAVES GENERADAS
            int celAfectadas = instruccion.executeUpdate();
            ResultSet llaves = instruccion.getGeneratedKeys();
            // NOTIFICANDO OPERACION
            if (celAfectadas > 0) {
                System.out.println("Inscripción realizada");
            } else {
                System.out.println("No se pudo realizar inscripción");
            }
            // CARGANDO ID GENERADA EN TABLA AL ALUMNO EN JAVA
            if (llaves.next()) {
                inscripcion.getAlumno().setId_alumno(llaves.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(InscripcionesData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void desinscribir_alumno(int id) {
        c = conexion.getConnection();

        try {
            Statement statement = c.createStatement();
            int celAfectadas = statement.executeUpdate("DELETE FROM registro WHERE id_alumno=" + id + ";");

            if (celAfectadas > 0) {
                System.out.println("Inscripción eliminada");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo borrar inscripción");
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(InscripcionesData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void registrar_nota(int id_alumno, int id_materia, double nota) {
        c = conexion.getConnection();

        try {
            Statement statement = c.createStatement();
            statement.executeUpdate("UPDATE registro SET nota=" + nota + " WHERE id_alumno=" + id_alumno + " AND id_materia=" + id_materia + ";");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(InscripcionesData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    // ACÁ HAY QUE AGREGAR UN MÉTODO PARA VER LAS NOTAS DE UN ALUMNO
    // DEBERÍA DEVOLVER UNA COLECCIÓN, YA QUE NECESITAMOS LA MATERIA, Y SU CORRESPONDIENTE NOTA
    // SI DEVOLVEMOS ESTRICTAMENTE EL OBJETO MATERIA (Coleccion<Materia, nota>), HAY QUE SOBRESCRIBIR EL HASHCODE Y EL EQUALS PARA EVITAR REPETIR MATERIAS EN LA COLECCION
    // SALVO, SI DEVOLVEMOS SOLAMENTE EL NOMBRE DE LA MATERIA (Coleccion<nombre_materia, nota> NOS AHORRAMOS EL HASHCODE Y EL EQUALS, PERO PERDEMOS ACCESO A OTROS DATOS
    // AL NO TENER CONSTRUÍDO UN OBJETO MATERIA DENTRO DE JAVA, EN CASO DE QUERER CONSULTAR ID DE MATERIA, ETC.
    // PARECE LARGO ESTE MÉTODO, ASÍ QUE LO DEJO ANOTADO PARA DESPUÉS.
    public List<Alumno> alumnos_en_materia(int id_materia) {
        c = conexion.getConnection();
        List<Alumno> alumnos = new ArrayList<>();
        Alumno alumno;
        try {
            Statement statement = c.createStatement();
            ResultSet consulta;
            consulta = statement.executeQuery("SELECT id_alumno, nombre, apellido, dni, fecha_n, activo FROM registro, alumno, materia WHERE alumno.id_alumno=registro.id_alumno AND registro.id_materia=" + id_materia + ";");

            while (consulta.next()) {
                alumno = new Alumno();
                alumno.setId_alumno(consulta.getInt("id_alumno"));
                alumno.setNombre(consulta.getString("nombre"));
                alumno.setApellido(consulta.getString("apellido"));
                alumno.setDni(consulta.getString("dni"));
                alumno.setFecha_n(consulta.getDate("fecha_n").toLocalDate());
                alumno.setActivo(consulta.getBoolean("activo"));
                alumnos.add(alumno);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(InscripcionesData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return alumnos;
    }

    public List<Materia> materias_alumno(int id_alumno) {
        c = conexion.getConnection();
        Materia materia;
        List<Materia> materias = new ArrayList<>();

        try {
            Statement statement = c.createStatement();
            ResultSet consulta = statement.executeQuery("SELECT id_materia, nombre_materia FROM registro, materia WHERE registro.id_materia=materia.id_materia AND registro.id_alumno=" + id_alumno + ";");

            while (consulta.next()) {
                materia = new Materia();
                materia.setId_materia(consulta.getInt("id_materia"));
                materia.setNombre_materia(consulta.getString("nombre_materia"));
                materias.add(materia);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(InscripcionesData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return materias;
    }
    // faltan:
    // ver notas de un alumno

}
