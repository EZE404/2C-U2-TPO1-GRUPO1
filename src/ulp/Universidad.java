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
        Alumno eze = new Alumno("Ezequiel", "Albornoz", "36227970", LocalDate.of(1991, 9, 16), true);
        alumno_data.guardar_alumno(eze);
        alumno_data.guardar_alumno(eze);
        System.out.println(alumno_data.buscar_alumno(eze.getId_alumno()).toString());
        alumno_data.borrar_alumno(100);
        
        Alumno franco = new Alumno(1, "Franco", "Ezequiel", "35789545", LocalDate.of(1990,7,12), false);
        alumno_data.modificar_alumno(franco);
        System.out.println(alumno_data.buscar_alumno(1).toString());
        
        for (Alumno a: alumno_data.ver_alumnos()) {
            System.out.println(a.toString());
        }
            
        }

}
