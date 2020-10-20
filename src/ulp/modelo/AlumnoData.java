package ulp.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ulp.entidades.Alumno;

public class AlumnoData {

    private Conexion conexion;
    private Connection c;

    public AlumnoData(Conexion conexion) {
        this.conexion = conexion;
    }

    public void guardar_alumno(Alumno alumno) {
        c = conexion.getConnection();
        String pre_instruccion;
        pre_instruccion = "INSERT INTO alumno (nombre, apellido, dni, fecha_n, activo) VALUES(?, ?, ?, ?, ?);";

        try {
            // CREANDO VARIABLE DE SENTENCIA PREPARADA
            PreparedStatement instruccion;
            instruccion = c.prepareStatement(pre_instruccion, Statement.RETURN_GENERATED_KEYS);
            // LLENANDO SIGNOS '?' DEL STRING DE LA VARIABLE 'pre_instruccion'
            instruccion.setString(1, alumno.getNombre()); //el '1' indica que va en el primer signo '?' de la variable 'pre_instruccion'
            instruccion.setString(2, alumno.getApellido());
            instruccion.setString(3, alumno.getDni());
            instruccion.setDate(4, Date.valueOf(alumno.getFecha_n()));
            instruccion.setBoolean(5, alumno.isActivo());
            // ENVIANDO LA SENTENCIA SQL PREPARADA EN LA VARIABLE 'instruccion'
            instruccion.executeUpdate();
            // OBTENIENDO LLAVE PRIMARIA GENERADA 'id_alumno' EN UN RESULTSET
            ResultSet resultado = instruccion.getGeneratedKeys();
            // GUARDANDO EL "id_alumno" EN LA INSTANCIA DE ALUMNO
            if (resultado.next()) {
                alumno.setId_alumno(resultado.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "No pudo obtener id");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar Alumno");
        } finally {
            try {
                // CERRANDO CONEXION
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public Alumno buscar_alumno(int id) {
        c = conexion.getConnection();
        Alumno alumno = null;
        String pre_instruccion = "SELECT * FROM alumno WHERE id_alumno=?";

        try {
            // CREANDO VARIABLE DE SENTENCIA PREPARADA
            PreparedStatement instruccion;
            instruccion = c.prepareStatement(pre_instruccion);
            // LLENANDO SIGNOS '?' DEL STRING DE LA VARIABLE 'pre_instruccion'
            instruccion.setInt(1, id);
            // ENVIANDO LA SENTENCIA SQL PREPARADA EN LA VARIABLE 'instruccion' Y GUARDANDO CONSULTA
            ResultSet consulta = instruccion.executeQuery();
            // CREANDO INSTANCIA DE ALUMNO DESDE CONSULTA SQL
            if (consulta.next()) {
                alumno = new Alumno();
                alumno.setId_alumno(consulta.getInt("id_alumno"));
                alumno.setNombre(consulta.getString("nombre"));
                alumno.setApellido(consulta.getString("apellido"));
                alumno.setDni(consulta.getString("dni"));
                alumno.setFecha_n(consulta.getDate("fecha_n").toLocalDate());
                alumno.setActivo(consulta.getBoolean("activo"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar Alumno, " + ex);
        } finally {
            try {
                // CERRANDO CONEXION
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return alumno;
    }

    public void borrar_alumno(int id) {
        c = conexion.getConnection();
        String pre_instruccion = "DELETE FROM alumno WHERE id_alumno=?";

        try {
            // CREANDO INSTRUCCION PREPARADA
            PreparedStatement instruccion = c.prepareStatement(pre_instruccion);
            // LLENANDO SIGNO '?' DE LA VARIABLE 'pre_instruccion' CON EL id
            instruccion.setInt(1, id);
            // EJECUTANDO INSTRUCCION SQL EN VARIABLE 'instruccion' Y OBTENIENDO CANT TUPLAS AFECTADAS
            int celAfectadas = instruccion.executeUpdate();
            // NOTIFICANDO SI HUBO CAMBIOS EN LA TABLA
            if (celAfectadas > 0) {
                System.out.println("Alumno Borrado");
            } else {
                System.out.println("El Registro con id " + id + " que pretende borrar no existe!!");
            }
        } catch (SQLException e) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                // CERRANDO CONEXION
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void modificar_alumno(Alumno alumno) {
        c = conexion.getConnection();
        try {
            // CREANDO PRE INSTRUCCION
            String pre_instruccion = "UPDATE alumno SET nombre=?, fecha_n=?, activo=? WHERE id_alumno=?";
            // LLENANDO '?' DE LA PRE INSTRUCCION
            PreparedStatement instruccion = c.prepareStatement(pre_instruccion);
            instruccion.setString(1, alumno.getNombre());
            instruccion.setDate(2, Date.valueOf(alumno.getFecha_n()));
            instruccion.setBoolean(3, alumno.isActivo());
            instruccion.setInt(4, alumno.getId_alumno());
            // EJECUTANDO INSTRUCCION SQL EN VARIABLE 'instruccion' Y OBTENIENDO CANT DE CAMPOS AFECTADOS
            int celAfectadas = instruccion.executeUpdate();
            // NOTIFICANDO SI HUBO CAMBIOS EN LA TABLA
            if (celAfectadas > 0) {
                System.out.println("Alumno Modificado");
            } else {
                System.out.println("El Registro " + alumno.getId_alumno() + " no pudo ser actualizado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // CERRANDO CONEXION
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public List<Alumno> ver_alumnos() {
        c = conexion.getConnection();
        Alumno alumno;
        List<Alumno> alumnos = new ArrayList<>();

        try {
            // CREANDO INSTRUCCION
            PreparedStatement instruccion = c.prepareStatement("SELECT * FROM alumno");
            // EJECUTANDO INSTRUCCION Y GUARDANDO RESULTADO DE CONSULTA
            ResultSet consulta = instruccion.executeQuery();
            // INSTANCIANDO Y LISTANDO ALUMNOS CON DATOS DE LA CONSULTA
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
            JOptionPane.showMessageDialog(null, "Error al buscar Alumno, " + ex);
        } finally {
            try {
                // CERRANDO CONEXION
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return alumnos;
    }

}
