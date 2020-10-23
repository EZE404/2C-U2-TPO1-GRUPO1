package ulp.modelo;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import javax.swing.JOptionPane;
import ulp.entidades.Alumno;
import ulp.entidades.Inscripcion;
import ulp.entidades.Materia;

public class InscripcionesData {

    private Conexion conexion;
    private Connection c;

    public InscripcionesData(Conexion conexion) {
        this.c = conexion.getConnection();
        this.conexion = conexion;
    }

//######################### INSCRIBIR ALUMNO ###################################    
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
                System.out.println("No se pudo realizar la inscripción");
                JOptionPane.showMessageDialog(null, "No se pudo realizar la inscripción");
            }
            // CARGANDO ID GENERADA EN TABLA AL ALUMNO EN JAVA
            if (llaves.next()) {
                inscripcion.getAlumno().setId_alumno(llaves.getInt(1));
            }
            instruccion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la inscripción");
            System.out.println(e.getMessage());

        }
    }

//######################## DESINSCRIBIR ALUMNO #################################    
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
            System.out.println("No se pudo borrar inscripción:" + ex.getMessage());
            JOptionPane.showMessageDialog(null, "No se pudo borrar inscripción");
        }
    }

    public void desinscribir_alumno(int id_alumno, int id_materia) {

        try {
            Statement statement = c.createStatement();
            int celAfectadas = statement.executeUpdate("DELETE FROM registro WHERE id_alumno=" + id_alumno + " AND id_materia=" + id_materia + ";");

            if (celAfectadas > 0) {
                System.out.println("Inscripción eliminada");
                JOptionPane.showMessageDialog(null, "Desincripcion Exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "No existe una inscripción del id de alumno:" + id_alumno + " para un id de materia:" + id_materia);
                System.out.println("No existe una inscripción del id de alumno:" + id_alumno + " para un id de materia:" + id_materia);

            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo borrar inscripción:" + ex.getMessage());
            JOptionPane.showMessageDialog(null, "No se pudo borrar inscripción. SQLException");
        }
    }

    public void desinscribir_alumno(String dni, String nombre_materia) {

        try {
            Statement statement = c.createStatement();
            int celAfectadas = statement.executeUpdate("DELETE FROM registro WHERE EXISTS (SELECT * FROM alumno, materia WHERE registro.id_alumno=alumno.id_alumno AND registro.id_materia=materia.id_materia AND alumno.dni='" + dni + "' AND materia.nombre_materia='" + nombre_materia + "');");

            if (celAfectadas > 0) {
                System.out.println("Inscripción eliminada");
                JOptionPane.showMessageDialog(null, "Desincripcion Exitosa");
            } else {
                System.out.println("No existe inscripción para el dni:" + dni + " para la materia " + nombre_materia);
                JOptionPane.showMessageDialog(null, "No existe inscripción para el dni:" + dni + " para la materia " + nombre_materia);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo borrar inscripción:" + ex.getMessage());
            JOptionPane.showMessageDialog(null, "No se pudo borrar inscripción. SQLException");
        }
    }

//#################### REGISTRAR NOTA ##########################################
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

    public void registrar_nota(String dni, String nombre_materia, double nota) {

        try {
            Statement statement = c.createStatement();
            int celAfectadas = statement.executeUpdate("UPDATE registro SET nota=" + nota + " WHERE EXISTS (SELECT * FROM alumno, materia WHERE registro.id_alumno = alumno.id_alumno AND registro.id_materia = materia.id_materia AND alumno.dni ='" + dni + "' AND materia.nombre_materia = '" + nombre_materia + "');");

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

//#################### lista alumnos en X materia ##############################
    public List<Alumno> alumnos_en_materia(int id_materia) {
        List<Alumno> alumnos = new ArrayList<>();
        Alumno alumno;
        try {
            Statement statement = c.createStatement();
            ResultSet consulta;
            consulta = statement.executeQuery("SELECT alumno.id_alumno, nombre, apellido, dni, fecha_n, activo FROM registro, alumno, materia WHERE alumno.id_alumno=registro.id_alumno AND registro.id_materia=materia.id_materia AND registro.id_materia=" + id_materia + ";");

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
                JOptionPane.showMessageDialog(null, "Se encontraron alumnos en la materia con id " + id_materia);
                System.out.println("Se encontraron alumnos en la materia con id " + id_materia);
            } else {
                JOptionPane.showMessageDialog(null, "No hay alumnos inscriptos para la materia con id " + id_materia);
                System.out.println("No hay alumnos inscriptos para la materia con id " + id_materia);
            }

            statement.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo obtener la lista de alumnos");
            System.out.println("No se pudo obtener la lista de alumnos: " + ex.getMessage());
        }

        return alumnos;
    }

    public List<Alumno> alumnos_en_materia(String nombre_materia) {
        List<Alumno> alumnos = new ArrayList<>();
        Alumno alumno;
        try {
            Statement statement = c.createStatement();
            ResultSet consulta;
            consulta = statement.executeQuery("SELECT alumno.id_alumno, nombre, apellido, dni, fecha_n, activo FROM registro, alumno, materia WHERE alumno.id_alumno=registro.id_alumno AND registro.id_materia=materia.id_materia AND materia.nombre_materia='" + nombre_materia + "';");

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
                JOptionPane.showMessageDialog(null, "Se encontraron alumnos en la materia " + nombre_materia);
                System.out.println("Se encontraron alumnos en la materia " + nombre_materia);
            } else {
                JOptionPane.showMessageDialog(null, "No hay alumnos inscriptos para la materia " + nombre_materia);
                System.out.println("No hay alumnos inscriptos para la materia " + nombre_materia);
            }

            statement.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo obtener la lista de alumnos");
            System.out.println("No se pudo obtener la lista de alumnos: " + ex.getMessage());
        }

        return alumnos;
    }

//###################### LISTA MATERIAS QUE CURSA UN ALUMNO ####################
    public List<Materia> materias_alumno(int id_alumno) {
        Materia materia;
        List<Materia> materias = new ArrayList<>();

        try {
            Statement statement = c.createStatement();
            ResultSet consulta = statement.executeQuery("SELECT materia.id_materia, nombre_materia FROM registro, materia WHERE registro.id_materia=materia.id_materia AND registro.id_alumno=" + id_alumno + ";");

            if (consulta.next()) {
                consulta.beforeFirst();
                while (consulta.next()) {
                    materia = new Materia();
                    materia.setId_materia(consulta.getInt("id_materia"));
                    materia.setNombre_materia(consulta.getString("nombre_materia"));
                    materias.add(materia);
                }
                JOptionPane.showMessageDialog(null, "Materias encontradas");
                System.out.println("Materias encontradas");

            } else {
                JOptionPane.showMessageDialog(null, "No hay inscripciones de materias para ese alumno");
                System.out.println("No se encontraron materias");
            }
            statement.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al encontrar materias");
            System.out.println(ex.getMessage());
        }

        return materias;
    }

    public List<Materia> materias_alumno(String dni) {
        Materia materia;
        List<Materia> materias = new ArrayList<>();

        try {
            Statement statement = c.createStatement();
            ResultSet consulta = statement.executeQuery("SELECT materia.id_materia, nombre_materia FROM registro, materia, alumno WHERE registro.id_materia=materia.id_materia AND registro.id_alumno=alumno.id_alumno AND alumno.dni='" + dni + "';");

            if (consulta.next()) {
                consulta.beforeFirst();
                while (consulta.next()) {
                    materia = new Materia();
                    materia.setId_materia(consulta.getInt("id_materia"));
                    materia.setNombre_materia(consulta.getString("nombre_materia"));
                    materias.add(materia);
                }
                JOptionPane.showMessageDialog(null, "Materias encontradas");
                System.out.println("Materias encontradas");

            } else {
                JOptionPane.showMessageDialog(null, "No hay inscripciones de materias para ese alumno");
                System.out.println("No se encontraron materias");
            }
            statement.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al encontrar materias");
            System.out.println(ex.getMessage());
        }

        return materias;
    }

//########################## COLECCION NOTAS DE ALUMNO #########################
    public Map<Materia, Double> notas_alumno(int id) {
        Map<Materia, Double> notas = new TreeMap<>();
        Materia materia;
        Double nota;

        try {
            Statement statement = c.createStatement();
            ResultSet consulta = statement.executeQuery("SELECT materia.id_materia, nombre_materia, nota FROM registro, materia, alumno WHERE alumno.id_alumno=registro.id_alumno AND registro.id_materia=materia.id_materia AND registro.id_alumno=" + id + ";");

            if (consulta.next()) {
                consulta.beforeFirst();
                while (consulta.next()) {
                    materia = new Materia();
                    materia.setId_materia(consulta.getInt("id_materia"));
                    materia.setNombre_materia(consulta.getString("nombre_materia"));
                    nota = (Double) consulta.getDouble("nota");
                    notas.put(materia, nota);
                }
                JOptionPane.showMessageDialog(null, "Notas encontradas");
                System.out.println("Notas encontradas");
            } else {
                JOptionPane.showMessageDialog(null, "No hay inscripciones para ese alumno");
                System.out.println("No hay inscripciones para ese alumno");
            }

            statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de algun tipo");
            System.out.println(ex.getMessage());
        }

        return notas;
    }

    public Map<Materia, Double> notas_alumno(String dni) {
        Map<Materia, Double> notas = new TreeMap<>();
        Materia materia;
        Double nota;

        try {
            Statement statement = c.createStatement();
            ResultSet consulta = statement.executeQuery("SELECT materia.id_materia, nombre_materia, nota FROM registro, materia, alumno WHERE alumno.id_alumno=registro.id_alumno AND registro.id_materia=materia.id_materia AND alumno.dni='" + dni + "';");

            if (consulta.next()) {
                consulta.beforeFirst();
                while (consulta.next()) {
                    materia = new Materia();
                    materia.setId_materia(consulta.getInt("id_materia"));
                    materia.setNombre_materia(consulta.getString("nombre_materia"));
                    nota = (Double) consulta.getDouble("nota");
                    notas.put(materia, nota);
                }
                JOptionPane.showMessageDialog(null, "Notas encontradas");
                System.out.println("Notas encontradas");
            } else {
                JOptionPane.showMessageDialog(null, "No hay inscripciones para ese alumno");
                System.out.println("No hay inscripciones para ese alumno");
            }

            statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de algun tipo");
            System.out.println(ex.getMessage());
        }

        return notas;
    }

//############################ LISTA INSCRIPCIONES #############################
    public List<Inscripcion> alumnos_en_materias() {
        List<Inscripcion> registros = new ArrayList<>();
        Inscripcion inscripcion;
        Alumno a;
        Materia m;
        try {
            Statement statement = c.createStatement();
            ResultSet consulta = statement.executeQuery("SELECT * FROM registro;");

            if (consulta.next()) {
                consulta.beforeFirst();
                while (consulta.next()) {
                    inscripcion = new Inscripcion(new Alumno(), new Materia());
                    inscripcion.setId_inscripcion(consulta.getInt("id_registro"));
                    a = this.buscarAlumno(consulta.getInt("id_alumno"));
                    m = this.buscarMateria(consulta.getInt("id_materia"));
                    inscripcion.setCalificacion(consulta.getDouble("nota"));
                    inscripcion.setAlumno(a);
                    inscripcion.setMateria(m);
                    registros.add(inscripcion);
                }
                JOptionPane.showMessageDialog(null, "Inscripciones Encontradas");

            } else {
                JOptionPane.showMessageDialog(null, "No hay inscripciones");
                System.out.println("Registro de inscripciones vacío");
            }

            statement.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudieron obtener las inscripciones");
            System.out.println(ex.getMessage());
        }

        return registros;
    }

//########################### MÉTODOS ÚTILES ###################################
    public Alumno buscarAlumno(int id) {
        AlumnoData a = new AlumnoData(conexion);
        return a.buscar_alumno(id);
    }

    public Materia buscarMateria(int id) {
        MateriaData m = new MateriaData(conexion);
        return m.buscar_materia(id);
    }

    public Alumno buscarAlumno(String dni) {
        AlumnoData a = new AlumnoData(conexion);
        return a.buscar_alumno(dni);
    }

    public Materia buscarMateria(String nombre) {
        MateriaData m = new MateriaData(conexion);
        return m.buscar_materia(nombre);
    }
}
