package ulp.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import ulp.entidades.Materia;

public class MateriaData {

    Connection c;

    public MateriaData(Conexion conexion) {
        this.c = conexion.getConnection();
    }
//########################## CARGAR MATERIA #############################
    public void cargar_materia(Materia materia) {

        String pre_instruccion = "INSERT INTO materia (nombre_materia) VALUES(?);";

        try {
            PreparedStatement instruccion = c.prepareStatement(pre_instruccion, Statement.RETURN_GENERATED_KEYS);
            instruccion.setString(1, materia.getNombre_materia());

            int celAfectadas = instruccion.executeUpdate();
            ResultSet llaves = instruccion.getGeneratedKeys();

            if (celAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Materia cargada");
                System.out.println("Materia cargada");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo cargar materia. La materia "+materia.getNombre_materia()+ " ya existe");
                System.out.println("No se pudo cargar materia. La materia "+materia.getNombre_materia()+ " ya existe");
            }

            if (llaves.next()) {
                materia.setId_materia(llaves.getInt(1));
            }
            instruccion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nombre materia duplicado");
            System.out.println(ex.getMessage());
        }
    }
//##################### ACTUALIZAR MATERIA #############################    
    
    public void actualizar_materia(Materia materia) {

       
        try {
            Statement instruccion = c.createStatement();
            int celdasAfectadas= instruccion.executeUpdate("UPDATE materia SET nombre_materia='"+materia.getNombre_materia()+"' WHERE id_materia="+materia.getId_materia()+ ";");
                if (celdasAfectadas>0) {
                    JOptionPane.showMessageDialog(null, "Materia Actualizada");
                    System.out.println("Materia Actualizada");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró tal materia");
                    System.out.println("La cantidad de celdas afectadas"+celdasAfectadas);
                }
            
            instruccion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar materia");
            System.out.println(ex.getMessage());
        }
       
    }
//##################### BUSCAR MATERIA #############################    
    
    public Materia buscar_materia(int id) {

        Materia materia = null;

        try {
            Statement instruccion = c.createStatement();
            try (ResultSet consulta = instruccion.executeQuery("SELECT * FROM materia WHERE id_materia=" + id + ";")) {
                if (consulta.next()) {
                    materia = new Materia();
                    materia.setId_materia(consulta.getInt("id_materia"));
                    materia.setNombre_materia(consulta.getString("nombre_materia"));
                    //JOptionPane.showMessageDialog(null, "Materia encontrada");
                    System.out.println("Materia encontrada");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró tal materia");
                }
            }
            instruccion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar materia");
            System.out.println(ex.getMessage());
        }
        return materia;
    }
    
    public Materia buscar_materia(String nombre_materia) {

        Materia materia = null;

        try {
            Statement instruccion = c.createStatement();
            try (ResultSet consulta = instruccion.executeQuery("SELECT * FROM materia WHERE nombre_materia='" + nombre_materia + "';")) {
                if (consulta.next()) {
                    materia = new Materia();
                    materia.setId_materia(consulta.getInt("id_materia"));
                    materia.setNombre_materia(consulta.getString("nombre_materia"));
                    //JOptionPane.showMessageDialog(null, "Materia encontrada");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró tal materia");
                    System.out.println("No se encontró tal materia");
                }
            }
            instruccion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar materia");
            System.out.println(ex.getMessage());
        }
        return materia;
    }
//############################ BORRAR MATERIA ################################
    public void borrar_materia(int id) {

        try {
            Statement statement = c.createStatement();
            int celAfectadas = statement.executeUpdate("DELETE FROM materia WHERE id_materia=" + id + ";");

            if (celAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Materia Eliminada");
                System.out.println("Materia eliminada");
            } else {
                JOptionPane.showMessageDialog(null, "No se borró la materia");
                System.out.println("No se pudo borrar materia");
            }
            statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo borrar materia");
            System.out.println(ex.getMessage());
        }
    }
    
    public void borrar_materia(String nombre_materia) {

        try {
            Statement statement = c.createStatement();
            int celAfectadas = statement.executeUpdate("DELETE FROM materia WHERE nombre_materia='" + nombre_materia + "';");

            if (celAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Materia Eliminada");
                System.out.println("Materia eliminada");
            } else {
                JOptionPane.showMessageDialog(null, "No se borró la materia");
                System.out.println("No se pudo borrar materia");
            }
            statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo borrar materia");
            System.out.println(ex.getMessage());
        }
    }

    public List<Materia> obtener_materias() {
        List<Materia> materias = new ArrayList<>();
        Materia materia;
        try {
            Statement statement = c.createStatement();
            ResultSet consulta = statement.executeQuery("SELECT * FROM materia;");
            
            if (consulta.next()) {
                consulta.beforeFirst();
                while (consulta.next()) {
                materia = new Materia();
                materia.setId_materia(consulta.getInt("id_materia"));
                materia.setNombre_materia(consulta.getString("nombre_materia"));
                materias.add(materia);
                }
                System.out.println("Se encontraron materias");
                //JOptionPane.showMessageDialog(null, "Se encontraron materias");
            } else {
                System.out.println("No se encontraron materias");
                JOptionPane.showMessageDialog(null, "No se encontraorn materias");
            }
            
            statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudieron obtener las materias");
            System.out.println("No se pudieron obtener las materias");
        }

        return materias;
    }

}
