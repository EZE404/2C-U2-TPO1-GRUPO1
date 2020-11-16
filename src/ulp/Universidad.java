package ulp;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
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

//        Alumno franco = new Alumno(1, "Franco", "Ezequiel", "35789545", LocalDate.of(1990,7,12), false);
//        alumno_data.modificar_alumno(franco);
//        System.out.println(alumno_data.buscar_alumno(1).toString());
//        
//        for (Alumno a: alumno_data.ver_alumnos()) {
//            System.out.println(a.toString());
//        }
      
//        Inscripcion ins = new Inscripcion(alumno_data.buscar_alumno(12), materia_data.buscar_materia(4), 7.5);
//        
//        ins_data.inscribir_alumno(ins);
//        ins_data.inscribir_alumno(ins);
//        ins_data.inscribir_alumno(ins);


//##############################################################################
//###################### Bloque de Testeo de conexion ##########################

/*	  
		 Conexion cc= new Conexion();//creo un objeto conectar
	     Connection con = cc.conexion();
*/

//############################################################################## 
//######################## TODO ALUMNO DATA ####################################

// GUARDAR ALUMNO - ok
// BORRAR ALUMNO POR ID ALUMNO - ok
// BORRAR ALUMNO POR DNI - ok
// BUSCAR ALUMNO POR ID ALUMNO - ok
// BUSCAR ALUMNO POR DNI - ok
// OBTENER LISTA DE ALUMNOS (TODOS, ACTIVOS, INACTIVOS) - ok


//############################################################################## 
//########################## GUARDAR ALUMNO ####################################
        
/*
        Alumno eze = new Alumno("Ezequiel", "Albornoz", "36227970", LocalDate.of(1991, 9, 16), true);
        alumno_data.guardar_alumno(eze);
        alumno_data.guardar_alumno(eze);
        alumno_data.guardar_alumno(eze);
*/


//##############################################################################
//################ Bloque de Testeo de UPDATE de ALUMNO ########################

        
//       Alumno eze = new Alumno("Ezequiel", "Albornoz", "36227970", LocalDate.of(1991, 9, 16), true);
//       eze.setNombre("Franco");
//       alumno_data.modificar_alumno(eze);


//##############################################################################
//################### Bloque de Testeo de BORRAR ALUMNO ########################

        // BORRAR POR ID
        // alumno_data.borrar_alumno(9);
        
        // BORRAR POR NOMBRE DE ALUMNO
        // alumno_data.borrar_alumno("Franco");
       
        
//##############################################################################  
//###################### Bloque de Testeo de BUSCAR ALUMNO #####################
    
    // BUSCAR alumno por ID
    //  System.out.println(alumno_data.buscar_alumno(47));
    
    
    // BUSCAR ALUMNO POR DNI
    //  System.out.println(alumno_data.buscar_alumno("30377673"));

    
//##############################################################################  
//############# Bloque de Testeo de recuperar de Lista de Alumnos ##############
 
            // VER TODOS LOS ALUMNOS
//            for (Alumno it: alumno_data.ver_alumnos()) {
//                System.out.println(it);
//            }

            // VER ALUMNOS ACTIVOS
//            for (Alumno it: alumno_data.ver_alumnos_activos()) {
//                System.out.println(it);
//            }

            // VER ALUMNOS INACTIVOS
//            for (Alumno it: alumno_data.ver_alumnos_inactivos()) {
//                System.out.println(it);
//            }
		 	

//##############################################################################
//########################## TODO MATERIA ######################################

        //Agregar materia probado - ok
        //Buscar materia por id materia - ok
        //Buscar materia por nombre_materia - ok
        //Borrar materia por id materia - ok
        //Borrar materia por nombre_materia - ok
        
//##############################################################################    
//################# Bloque de Testeo de CARGAR de MATERIA ######################		

                        
//        Materia lab1 = new Materia("WEB");
//        Materia lab2 = new Materia("Base de Datos");
//        materia_data.cargar_materia(lab1);
//        materia_data.cargar_materia(lab2);
//        materia_data.cargar_materia(lab2);

//##############################################################################	
//################# Bloque de Testeo de BUSCAR una MATERIA #####################

       // BUSCAR MATERIA POR ID_MATERIA
       // System.out.println(materia_data.buscar_materia(20));
       
       // BUSCAR MATERIA POR NOMBRE_MATERIA
       // System.out.println(materia_data.buscar_materia("Labasdasdasd 1"));

        
//##############################################################################
//######################## bloque test BORRAR MATERIA ##########################

// BORRAR MATERIA POR ID DE MATERIA

//materia_data.borrar_materia(59);


// BORRAR MATERIA POR NOMBRE_MATERIA

//materia_data.borrar_materia("Lab 1");

//##############################################################################
//################ bloque test OBTENER LISTA DE MATERIAS #######################


//for (Materia it: materia_data.obtener_materias()) {
//    System.out.println(it);
//}

//##############################################################################
//############################ TODO INSCRIPCION ################################

        //probado Inscribir - ok
        //probado desinscribir por ID de Inscripcion - ok
        //probado desinscribir por id alumno e id materia - ok
        //probado desinscribir por dni y nombre_materia - ok
        //Probado registro de nota por id_alumno e id_materia - ok
        //probado registro de nota por dni y nombre_materia - ok
        //Probado mostrar alumnos de una materia con id materia - ok
        //Probado Mostrar Materias de un Alumno por id de alumn - ok
        //PRobado MOstrar Notas y MAterias de un alumno por id_alumno - ok

//##############################################################################
//################### Bloque de Testeo de INSCRIPCION ##########################                     
        
/*     
    Inscripcion ins1 = new Inscripcion(alumno_data.buscar_alumno(46), materia_data.buscar_materia(20), 7.5);
    Inscripcion ins2 = new Inscripcion(alumno_data.buscar_alumno("30377673"), materia_data.buscar_materia("Lab 1"), 8.5);
    ins_data.inscribir_alumno(ins1);
    ins_data.inscribir_alumno(ins2);

*/

//##############################################################################
//############## Bloque de Testeo de DESINCRIBIR una INSCRIPCION ###############

        
        // DESINSCRIBIR POR ID INSCRIPCION
        //ins_data.desinscribir_alumno(28);
        //ins_data.desinscribir_alumno(12);
        
        // DESINSCRIBIR POR ID ALUMNO E ID MATERIA
        //ins_data.desinscribir_alumno("30377673", "Labo 1");
        
        // DESINSCRIBIR POR DNI ALUMNO Y NOMBRE_MATERIA
        //ins_data.desinscribir_alumno("30377673", "SDFSDFDA");

//##############################################################################
//############ Bloque de Testeo de Registrar Nota de una INSCRIPCION ##########


        // REGISTRAR NOTA POR ID DE ALUMNO E ID DE MATERIA
        //ins_data.registrar_nota(46, 20, 3.0);
        
        // REGISTRAR NOTA POR DNI Y NOMBRE_MATERIA
        //ins_data.registrar_nota("30377673", "Lab 1", 10);
        
//##############################################################################
//########### Bloque de Testeo de Mostrar Alumnos de una materia ###############

                //BUSCAR POR ID MATERIA
//                List <Alumno> aux=ins_data.alumnos_en_materia(27);	 	
//                    for(Alumno alu: aux){
//                    System.out.println(alu);
//                    }
                    
                // BUSCAR POR NOMBRE_MATERIA
//                List <Alumno> aux=ins_data.alumnos_en_materia("dfgfg1");	 	
//                    for(Alumno alu: aux){
//                    System.out.println(alu);
//                    }

//##############################################################################
//############# Bloque de Testeo de Mostrar Materias de un Alumno ##############
                
//              // BUSCAR POR ID DE ALUMNO
//                List <Materia> aux=ins_data.materias_alumno(47);	 	
//                    for(Materia alu: aux){
//                        System.out.println(alu);
//                    }
                
//                // BUSCAR POR DNI DE ALUMNO
//                List <Materia> aux=ins_data.materias_alumno("31356168");	 	
//                    for (Materia alu: aux) {
//                        System.out.println(alu);
//                    }

//##############################################################################
//######## Bloque de Testeo de Mostrar Notas de MAterias de un Alumno ##########	


    // BUSCAR NOTAS DE UN ALUMNO POR ID DE ALUMNO
    //ins_data.notas_alumno(47).forEach((materia,nota) -> System.out.println("Materia: " + materia.getNombre_materia() + " Nota: "+nota));
    
    // BUSCAR NOTAS DE UN ALUMNO POR DNI            
    //ins_data.notas_alumno("31356168").forEach((materia,nota) -> System.out.println("Materia: " + materia.getNombre_materia() + " Nota: "+nota));


//##############################################################################
//############### Bloque de Testeo de Lista de inscripciones ###################

       
//        LISTA INSCRIPCIONES DE TODOS LOS ALUMNOS
//        List<Inscripcion> aux = ins_data.alumnos_en_materias();
//        //System.out.println("EN la materia 27 los alumnos son: ");	 	
//        for (Inscripcion alu : aux) {
//            //System.out.println("Inscripcion: "+alu.getId_inscripcion()+" Alumno: "+alu.getAlumno().getNombre()+"  "+"Apellido: "+ alu.getAlumno().getApellido()+ "  " + "Materia: " + alu.getMateria().getNombre_materia());
//            System.out.println(alu);
//        }

//        LISTA DE INSCRIPCIONES DE ALUMNOS ACTIVOS
//        List<Inscripcion> aux = ins_data.alumnos_en_materias();
//        //System.out.println("EN la materia 27 los alumnos son: ");	 	
//        for (Inscripcion alu : aux) {
//            //System.out.println("Inscripcion: "+alu.getId_inscripcion()+" Alumno: "+alu.getAlumno().getNombre()+"  "+"Apellido: "+ alu.getAlumno().getApellido()+ "  " + "Materia: " + alu.getMateria().getNombre_materia());
//            System.out.println(alu);
//        }

//##############################################################################
//    List<Materia> materias= materia_data.obtener_materias_alumno_nocursa(47);
//    for(Materia m:materias){
//        System.out.println(m);
//    }



    }
}
