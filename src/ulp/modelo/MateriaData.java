package ulp.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ulp.entidades.Materia;

public class MateriaData {

    Conexion conexion;
    Connection c;

    MateriaData(Conexion conexion) {
        this.conexion = conexion;
    }

    public void cargar_materia(Materia materia) {
        c = conexion.getConnection();
        String pre_instruccion = "INSERT INTO materia (nombre_materia) VALUES(?);";

        try {
            PreparedStatement instruccion = c.prepareStatement(pre_instruccion, Statement.RETURN_GENERATED_KEYS);
            instruccion.setString(1, materia.getNombre_materia());

            int celAfectadas = instruccion.executeUpdate();
            ResultSet llaves = instruccion.getGeneratedKeys();

            if (celAfectadas > 0) {
                System.out.println("Materia cargada");
            } else {
                System.out.println("No se pudo cargar materia");
            }

            if (llaves.next()) {
                materia.setId_materia(llaves.getInt(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void borrar_materia(int id) {
        c = conexion.getConnection();

        try {
            Statement statement = c.createStatement();
            int celAfectadas = statement.executeUpdate("DELETE FROM materia WHERE id_materia=" + id + ";");

            if (celAfectadas > 0) {
                System.out.println("Materia eliminada");
            } else {
                System.out.println("No se pudo borrar materia");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Materia> obtener_materias() {
        c = conexion.getConnection();
        List<Materia> materias = new ArrayList<>();
        Materia materia;
        try {
            Statement statement = c.createStatement();
            ResultSet consulta = statement.executeQuery("SELECT * FROM materia;");

            while (consulta.next()) {
                materia = new Materia();
                materia.setId_materia(consulta.getInt("id_materia"));
                materia.setNombre_materia(consulta.getString("nombre_materia"));
                materias.add(materia);
            }
        } catch (SQLException ex) {

        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return materias;
    }
}
