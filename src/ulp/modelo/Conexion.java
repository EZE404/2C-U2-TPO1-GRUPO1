package ulp.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ulp.vista.Errores_mensajes;
import ulp.vista.Principal;

public class Conexion {

    private final String base = "universidad";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private final String user = "root";
    private final String pass = "";
    private Connection conexion;
 
    public Connection getConnection() {
        if (conexion == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");

                conexion = DriverManager.getConnection(url, user, pass);
                JOptionPane.showMessageDialog(null, "Conexion Exitosa");
                Errores_mensajes.escribirMensaje("Conexon Exitosa");
                               
            } catch (SQLException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Error al conectarse");
                              
            }
        }
        return conexion;
    }

}
