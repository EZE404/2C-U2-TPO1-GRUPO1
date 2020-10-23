package ulp.modelo;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import javax.swing.JOptionPane;
import ulp.entidades.Alumno;
import ulp.entidades.Inscripcion;
import ulp.entidades.Materia;

public class InscripcionesData {


    private Connection c;

    public InscripcionesData(Conexion conexion) {
        this.c = conexion.getConnection();

    }

    public void inscribir_alumno(Inscripcion inscripcion) {

        String pre_instruccion = "INSERT INTO registro (id_alumno, id_materia, nota) VALUES (?, ?, ?);";

        try {

            // CREANDO PREPARED STATEMENT
            PreparedStatement instruccion = c.prepareStatement(pre_instruccion, Statement.RETURN_GENERATED_KEYS);
            // LLENANDO SIGNOS '?'
            instruccion.setInt(1, inscripcion.getAlumno().getId_alumno());
            instruccion.setInt(2, inscripcion.getMateria().getId_materia());
            instruccion.setDouble(3, inscripcion.getCalificacion());
            //instruccion.setDate(4, Date.valueOf(inscripcion.getFecha_i()));
            // EJECUTANDO Y GUARDANDO LLAVES GENERADAS
            int celAfectadas = instruccion.executeUpdate();
            ResultSet llaves = instruccion.getGeneratedKeys();
            // NOTIFICANDO OPERACION
            if (celAfectadas > 0) {
                System.out.println("Inscripción realizada");
                JOptionPane.showMessageDialog(null, "Inscripcion Exitosa");
            } else {
                System.out.println("No se pudo realizar inscripción");
            }
            // CARGANDO ID GENERADA EN TABLA AL ALUMNO EN JAVA
            if (llaves.next()) {
                inscripcion.getAlumno().setId_alumno(llaves.getInt(1));
            }
            instruccion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    public void desinscribir_alumno(int id) {

        try {
            Statement statement = c.createStatement();
            int celAfectadas = statement.executeUpdate("DELETE FROM registro WHERE id_registro=" + id + ";");

            if (celAfectadas > 0) {
                System.out.println("Inscripción eliminada");
                JOptionPane.showMessageDialog(null, "Desincripcion Exitosa");
            } else {
                System.out.println("No se pudo borrar inscripción");
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo borrar inscripción");
            JOptionPane.showMessageDialog(null, "No se pudo borrar inscripción");
            System.out.println(ex.getMessage());
        }
    }

    public void registrar_nota(int id_alumno, int id_materia, double nota) {

        try {
            Statement statement = c.createStatement();
            int celAfectadas = statement.executeUpdate("UPDATE registro SET nota=" + nota + " WHERE id_alumno=" + id_alumno + " AND id_materia=" + id_materia + ";");

            if (celAfectadas > 0) {
                System.out.println("Se registró nota");
                JOptionPane.showMessageDialog(null, "Se registró nota");
            } else {
                JOptionPane.showMessageDialog(null, "No se registró nota");
                System.out.println("No se registró nota");
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<Alumno> alumnos_en_materia(int id_materia) {
        List<Alumno> alumnos = new ArrayList<>();
        Alumno alumno;
        try {
            Statement statement = c.createStatement();
            ResultSet consulta;
            consulta = statement.executeQuery("SELECT alumno.id_alumno, nombre, apellido, dni, fecha_n, activo FROM registro, alumno, materia WHERE alumno.id_alumno=registro.id_alumno AND registro.id_materia=materia.id_materia AND registro.id_materia=" + id_materia + ";");

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
            statement.close();
            JOptionPane.showMessageDialog(null, "Se encontraron las materias");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de algun tipo");
            System.out.println(ex.getMessage());
        }

        return alumnos;
    }

    public List<Materia> materias_alumno(int id_alumno) {
        Materia materia;
        List<Materia> materias = new ArrayList<>();

        try {
            Statement statement = c.createStatement();
            ResultSet consulta = statement.executeQuery("SELECT materia.id_materia, nombre_materia FROM registro, materia WHERE registro.id_materia=materia.id_materia AND registro.id_alumno=" + id_alumno + ";");
             
            while (consulta.next()) {
                materia = new Materia();
                materia.setId_materia(consulta.getInt("id_materia"));
                materia.setNombre_materia(consulta.getString("nombre_materia"));
                materias.add(materia);
            }
            if(consulta.next()){
                JOptionPane.showMessageDialog(null, "Materias encontradas");
                System.out.println("No se encontraron materias");
            }
            else {
                JOptionPane.showMessageDialog(null, "No se encontraron materias");
                System.out.println("No se encontraron materias");
            }
            statement.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al encontrar materias");
            System.out.println(ex.getMessage());
        }

        return materias;
    }

    // 
    public Map<Materia, Double> notas_alumno(int id) {
        Map notas = new TreeMap<>();
        Materia materia;
        Double nota;

        try {
            Statement statement = c.createStatement();
            ResultSet consulta = statement.executeQuery("SELECT materia.id_materia, nombre_materia, nota FROM registro, materia, alumno WHERE alumno.id_alumno=registro.id_alumno AND registro.id_materia=materia.id_materia AND registro.id_alumno=" + id +";");

            while (consulta.next()) {
                materia = new Materia();
                materia.setId_materia(consulta.getInt("id_materia"));
                materia.setNombre_materia(consulta.getString("nombre_materia"));
                nota = (Double)consulta.getDouble("nota");
                System.out.println(materia.getNombre_materia()+" "+nota);
               notas.put(materia, nota);
            }
            JOptionPane.showMessageDialog(null, "Notas encontradas");
            statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de algun tipo");
            System.out.println(ex.getMessage());
        }

        return notas;
    }

    public List<Inscripcion> alumnos_en_materias() {
        List<Inscripcion> registros = new ArrayList<>();
        Inscripcion inscripcion;
        
        try {
            Statement statement = c.createStatement();
            ResultSet consulta = statement.executeQuery("SELECT * FROM registro;");

            while (consulta.next()) {
                inscripcion = new Inscripcion(new Alumno(), new Materia());
                inscripcion.getAlumno().setId_alumno(consulta.getInt("id_alumno"));
                inscripcion.getMateria().setId_materia(consulta.getInt("id_materia"));
                inscripcion.setCalificacion(consulta.getDouble("nota"));
                registros.add(inscripcion);

            }

            statement.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudieron obtener las inscripciones");
            System.out.println(ex.getMessage());
        }

        return registros;
    }

}
