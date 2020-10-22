package ulp;

import java.time.LocalDate;
import ulp.entidades.Alumno;
import ulp.entidades.Inscripcion;
import ulp.entidades.Materia;
import ulp.modelo.AlumnoData;
import ulp.modelo.Conexion;
import ulp.modelo.InscripcionesData;
import ulp.modelo.MateriaData;

public class Universidad {

    public static void main(String[] args) {
        // TODO code application logic here
        Conexion conexion = new Conexion();
        AlumnoData alumno_data = new AlumnoData(conexion);
        MateriaData materia_data = new MateriaData(conexion);
        InscripcionesData ins_data = new InscripcionesData(conexion);
        
        Alumno eze = new Alumno("Ezequiel", "Albornoz", "36227970", LocalDate.of(1991, 9, 16), true);
        alumno_data.guardar_alumno(eze);
        alumno_data.guardar_alumno(eze);
        alumno_data.guardar_alumno(eze);
//
//        System.out.println(alumno_data.buscar_alumno(eze.getId_alumno()).toString());
        //alumno_data.borrar_alumno(9);
        
//        Alumno franco = new Alumno(1, "Franco", "Ezequiel", "35789545", LocalDate.of(1990,7,12), false);
//        alumno_data.modificar_alumno(franco);
//        System.out.println(alumno_data.buscar_alumno(1).toString());
//        
//        for (Alumno a: alumno_data.ver_alumnos()) {
//            System.out.println(a.toString());
//        }
        
        Materia lab1 = new Materia("EdA");
        Materia lab2 = new Materia("MAtemATICA");
        materia_data.cargar_materia(lab1);
        materia_data.cargar_materia(lab2);
        materia_data.cargar_materia(lab2);
        
        
        
//        Inscripcion ins = new Inscripcion(alumno_data.buscar_alumno(12), materia_data.buscar_materia(4), 7.5);
//        
//        ins_data.inscribir_alumno(ins);
//        ins_data.inscribir_alumno(ins);
//        ins_data.inscribir_alumno(ins);


        
        }
    
        
        

}
