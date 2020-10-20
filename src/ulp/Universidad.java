package ulp;

import java.time.LocalDate;
import ulp.entidades.Alumno;
import ulp.modelo.AlumnoData;
import ulp.modelo.Conexion;

public class Universidad {

    public static void main(String[] args) {
        // TODO code application logic here
        Conexion conexion = new Conexion();
        AlumnoData alumno_data = new AlumnoData(conexion);
        
        alumno_data.guardar_alumno(new Alumno("Ezequiel", "Albornoz", "36227970", LocalDate.of(1991, 9, 16), true));
        
    }

}
