package ulp.modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import ulp.entidades.Inscripcion;

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
    
    // faltan:
    // ver todas las inscripciones
    // ver notas de un alumno
    // eliminar inscripcion

}
