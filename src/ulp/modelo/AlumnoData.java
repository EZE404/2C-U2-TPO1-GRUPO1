package ulp.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import ulp.entidades.Alumno;

public class AlumnoData {

    private Connection c;

    public AlumnoData(Conexion conexion) {
        this.c = conexion.getConnection();
    }

    public void guardar_alumno(Alumno alumno) {

        String pre_instruccion;
        pre_instruccion = "INSERT INTO alumno (nombre, apellido, dni, fecha_n, activo) VALUES(?, ?, ?, ?, ?);";

        try {
            PreparedStatement instruccion;
            instruccion = c.prepareStatement(pre_instruccion, Statement.RETURN_GENERATED_KEYS);

            instruccion.setString(1, alumno.getNombre());
            instruccion.setString(2, alumno.getApellido());
            instruccion.setString(3, alumno.getDni());
            instruccion.setDate(4, Date.valueOf(alumno.getFecha_n()));
            instruccion.setBoolean(5, alumno.isActivo());

            instruccion.executeUpdate();

            try (ResultSet resultado = instruccion.getGeneratedKeys()) {
                if (resultado.next()) {
                    alumno.setId_alumno(resultado.getInt(1));
                    System.out.println("Alumno cargado");
                    JOptionPane.showMessageDialog(null, "Alumno cargado");
                } else {
                    JOptionPane.showMessageDialog(null, "No pudo obtener id");
                    System.out.println("No pudo obtener id");
                }
            }

            instruccion.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error al guardar Alumno");
            System.out.println(ex.getMessage());
        }
    }

    public Alumno buscar_alumno(int id) {

        Alumno alumno = null;

        try {
            Statement instruccion = c.createStatement();
            try (ResultSet consulta = instruccion.executeQuery("SELECT * FROM alumno WHERE id_alumno=" + id + ";")) {
                if (consulta.next()) {
                    alumno = new Alumno();
                    alumno.setId_alumno(consulta.getInt("id_alumno"));
                    alumno.setNombre(consulta.getString("nombre"));
                    alumno.setApellido(consulta.getString("apellido"));
                    alumno.setDni(consulta.getString("dni"));
                    alumno.setFecha_n(consulta.getDate("fecha_n").toLocalDate());
                    alumno.setActivo(consulta.getBoolean("activo"));
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró alumno");
                    System.out.println("No se encontró alumno");
                }
            }
            instruccion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar Alumno");
            System.out.println(ex.getMessage());
        }
        return alumno;
    }

    public Alumno buscar_alumno(String dni) {

        Alumno alumno = null;

        try {
            Statement instruccion = c.createStatement();
            try (ResultSet consulta = instruccion.executeQuery("SELECT * FROM alumno WHERE dni=" + dni + ";")) {
                if (consulta.next()) {
                    alumno = new Alumno();
                    alumno.setId_alumno(consulta.getInt("id_alumno"));
                    alumno.setNombre(consulta.getString("nombre"));
                    alumno.setApellido(consulta.getString("apellido"));
                    alumno.setDni(consulta.getString("dni"));
                    alumno.setFecha_n(consulta.getDate("fecha_n").toLocalDate());
                    alumno.setActivo(consulta.getBoolean("activo"));
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró alumno");
                    System.out.println("No se encontró alumno");
                }
            }
            instruccion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar Alumno");
            System.out.println(ex.getMessage());
        }
        return alumno;
    }

    public void borrar_alumno(int id) {

        try {
            Statement statement = c.createStatement();
            int celAfectadas = statement.executeUpdate("DELETE FROM alumno WHERE id_alumno=" + id + ";");

            if (celAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Alumno Borrado");
                System.out.println("Alumno Borrado");
            } else {
                JOptionPane.showMessageDialog(null, "El Registro con id " + id + " que pretende borrar no existe!!");
                System.out.println("El Registro con id " + id + " que pretende borrar no existe!!");
            }
            statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al borrar alumno");
            System.out.println("Error al borrar alumno");
        }

    }

    public void borrar_alumno(String dni) {

        try {
            Statement statement = c.createStatement();
            int celAfectadas = statement.executeUpdate("DELETE FROM alumno WHERE dni='" + dni + "';");

            if (celAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "ALumno Borrado");
                System.out.println("Alumno Borrado");
            } else {
                JOptionPane.showMessageDialog(null, "El Registro con dni " + dni + " que pretende borrar no existe!!");
                System.out.println("El Registro con dni " + dni + " que pretende borrar no existe!!");
            }
            statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al borrar alumno");
            System.out.println("Error al borrar alumno");
        }

    }

    public void modificar_alumno(Alumno alumno) {

        try {
            String pre_instruccion = "UPDATE alumno SET nombre=?, apellido=?, dni=?, fecha_n=?, activo=? WHERE id_alumno=?";
            PreparedStatement instruccion = c.prepareStatement(pre_instruccion);
            instruccion.setString(1, alumno.getNombre());
            instruccion.setString(2, alumno.getApellido());
            instruccion.setString(3, alumno.getDni());
            instruccion.setDate(4, Date.valueOf(alumno.getFecha_n()));
            instruccion.setBoolean(5, alumno.isActivo());
            instruccion.setInt(6, alumno.getId_alumno());

            int celAfectadas = instruccion.executeUpdate();
            if (celAfectadas > 0) {
                System.out.println("Alumno Modificado");
                JOptionPane.showMessageDialog(null, "Alumno Modificado");
            } else {
                System.out.println("El Registro " + alumno.getId_alumno() + " no pudo ser actualizado");
                JOptionPane.showMessageDialog(null, "El alumno no se pudo actualizar");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar alumno");
        }

    }

    public List<Alumno> ver_alumnos() {

        Alumno alumno;
        List<Alumno> alumnos = new ArrayList<>();

        try {
            PreparedStatement instruccion = c.prepareStatement("SELECT * FROM alumno");
            ResultSet consulta = instruccion.executeQuery();
            
            if (consulta.next()) {
                consulta.beforeFirst();
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
                //JOptionPane.showMessageDialog(null, "Se encontraron alumnos");
                System.out.println("Se encontraron alumnos");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron alumnos");
                System.out.println("No se encontraron alumnos");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener Alumnos");
            System.out.println(ex.getMessage());
        }

        return alumnos;
    }

    public List<Alumno> ver_alumnos_activos() {

        Alumno alumno;
        List<Alumno> alumnos = new ArrayList<>();

        try {
            PreparedStatement instruccion = c.prepareStatement("SELECT * FROM alumno WHERE activo=1");
            ResultSet consulta = instruccion.executeQuery();
            if (consulta.next()) {
                consulta.beforeFirst();
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
                JOptionPane.showMessageDialog(null, "Se encontraron alumnos");
                System.out.println("Se encontraron alumnos");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron alumnos");
                System.out.println("No se encontraron alumnos");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener Alumnos");
            System.out.println(ex.getMessage());
        }

        return alumnos;
    }

    public List<Alumno> ver_alumnos_inactivos() {

        Alumno alumno;
        List<Alumno> alumnos = new ArrayList<>();

        try {
            PreparedStatement instruccion = c.prepareStatement("SELECT * FROM alumno WHERE activo=0");
            ResultSet consulta = instruccion.executeQuery();
            if (consulta.next()) {
                consulta.beforeFirst();
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
                JOptionPane.showMessageDialog(null, "Se encontraron alumnos");
                System.out.println("Se encontraron alumnos");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron alumnos");
                System.out.println("No se encontraron alumnos");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener Alumnos");
            System.out.println(ex.getMessage());
        }

        return alumnos;
    }

}
