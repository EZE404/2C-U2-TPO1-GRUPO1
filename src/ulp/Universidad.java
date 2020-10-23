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
       /* 
        Conexion conexion = new Conexion();
        AlumnoData alumno_data = new AlumnoData(conexion);
        MateriaData materia_data = new MateriaData(conexion);
        InscripcionesData ins_data = new InscripcionesData(conexion);
        
        Alumno eze = new Alumno("Ezequiel", "Albornoz", "36227970", LocalDate.of(1991, 9, 16), true);
        alumno_data.guardar_alumno(eze);
        alumno_data.guardar_alumno(eze);
        alumno_data.guardar_alumno(eze);
        */
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
        
        
/*
        Materia lab1 = new Materia("EdA");
        Materia lab2 = new Materia("MAtemATICA");
        materia_data.cargar_materia(lab1);
        materia_data.cargar_materia(lab2);
        materia_data.cargar_materia(lab2);
 */       
        
        
//        Inscripcion ins = new Inscripcion(alumno_data.buscar_alumno(12), materia_data.buscar_materia(4), 7.5);
//        
//        ins_data.inscribir_alumno(ins);
//        ins_data.inscribir_alumno(ins);
//        ins_data.inscribir_alumno(ins);

		 
//------------   Bloque de Testeo de conexion     ---------------------------------
	/*	  
		 Conexion cc= new Conexion();//creo un objeto conectar
	     Connection con = cc.conexion();
	  */   
//-------------------------------------------------------------------------------- 
		 
                            //TODO ALUMNO DATA
		 
		 
//----------   Bloque de Testeo de UPDATE de ALUMNO       ------------------------		
	/*	 	//---Conexion----
		 	Conexion cc= new Conexion();
		 	
		 	//----------Alumno auxiliar para ingresar los datos---------
		 	Alumno AlumnoParametro=new Alumno();
		 	AlumnoParametro.setNombreAlumno("Nora");
		 	//------- Ingresando dato de forma String--------
		 	//AlumnoParametro.setFnAlumno("2019-98-12");
		 	//---- Ingreasando LocalDate--------
		 	AlumnoParametro.setFnAlumno(LocalDate.parse("2019-98-12") );
	
	*/

//-----------------------------------------------------------------------------------  
//--------------------Bloque de Testeo de recuperar de Lista de Alumnos---------------------
	/*	 
		 //---Conexion----
		 Conexion cc= new Conexion();
		 	
		//------Donde voy a resivir la lista de los alumnos---------
		 List <Alumno> resultado=new ArrayList<>();
		 	 
		//-------Creo un instancia para hacer el match o consulta y hago la conexion-----------
	    	AlumnoData busqueda=new AlumnoData(cc);
	    	
	    	//-----Recibo la lista--------------
	    	resultado=busqueda.listaAlumnos();
		 	
		 	    	
	    	for (Iterator<Alumno> iterator = resultado.iterator(); iterator.hasNext();) {
		Alumno alu = iterator.next();
		System.out.println("Id; "+ alu.getIdAlumno());
		System.out.println("Nombre: "+ alu.getNombreAlumno());
		System.out.println("Fecha de nacimiento: "+ alu.getFnAlumno());
			}
	*/	 
//-----------------------------------------------------------------------------------  
//--------     Bloque de Testeo de recuperar un solo almuno por nombre      -----------------------
	/*		
		Conexion cc= new Conexion();
	  	//-----------Alumno pasar por parametro a buscar
		Alumno parametro=new Alumno("avaca");
	  		
		//--------Alumno que va resivir la consulta paramostrar
		Alumno resultado=new Alumno();
	  		
		//-------Creo un instancia para hacer el match o consulta y hago la conexion
	    	AlumnoData busqueda=new AlumnoData(cc);
	    	//-------Llamo al metodo que hace la consulta y le paso el alumno a buscar
	    	resultado=busqueda.unAlumno(parametro);
	    	
	    	
	    	System.out.println("Id: "+resultado.getIdAlumno());
	    	System.out.println("Nombre: "+resultado.getNombreAlumno());
	    	System.out.println("Fecha Nacimiento: "+resultado.getFnAlumno());
	    	System.out.println("Activo: "+resultado.isActivo());
	*/    	
//-------------------------------------------------------------------------------------------------------------- 
	  

                            //    TODO MATERIA

                     //Agregar materia probado

//----------   Bloque de Testeo de UPDATE de MATERIA       ------------------------		
	/*	 	//---Conexion----
		 	Conexion cc= new Conexion();
		 	
		 	//----------Materia auxiliar para ingresar los datos---------
		 	Materia materiaParametro=new Materia();
		 	materiaParametro.setNombreMateria("Naturales");
		 	
		 	//---- Ingreasando LocalDate--------
		 	MateriaData meterMateria=new MateriaData(cc);
		 	meterMateria.guardarMateria(materiaParametro);
	
	*/

//-----------------------------------------------------------------------------------	
//----------      Bloque de Testeo de BUSCAR una MATERIA       ------------------------		
	/*	 	
		 	//---Conexion----
		 	Conexion cc= new Conexion();
		 	
		 	//----------Materia auxiliar para ingresar los datos---------
		 	Materia materiaParametro=new Materia();
		 	materiaParametro.setIdMateria(10);
		 	Materia aux=new Materia();
		 	
		 	//---- Ingreasando LocalDate--------
		 	MateriaData sacarMateria=new MateriaData(cc);
		 	aux=sacarMateria.getMateria(materiaParametro.getIdMateria());
		 	System.out.println("Id; "+ aux.getIdMateria());
			System.out.println("Nombre: "+ aux.getNombreMateria());
		
	
	*/

//-----------------------------------------------------------------------------------


                                //TODO INSCRIPCION
                                
                                
                       //probado Inscribir - ok
                       //probado desinscribir por ID de Inscripcion - ok
                       //Probado registro de nota - ok
                       //Probado mostrar alumnos de una materia con id materia - ok
                       //Probado Mostrar Materias de un Alumno por id de alumn - ok
                       
//----------      Bloque de Testeo de INSCRIPCION     ------------------------                       
 /*       
        Conexion conexion = new Conexion();
        AlumnoData alumno_data = new AlumnoData(conexion);
        MateriaData materia_data = new MateriaData(conexion);
        InscripcionesData ins_data = new InscripcionesData(conexion);

      //  Alumno eze = new Alumno("Ezequiel", "Albornoz", "36227970", LocalDate.of(1991, 9, 16), true);
        
        Inscripcion ins1 = new Inscripcion(alumno_data.buscar_alumno(46), materia_data.buscar_materia(20), 7.5);
        Inscripcion ins2 = new Inscripcion(alumno_data.buscar_alumno(47), materia_data.buscar_materia(27), 7.5);
        ins_data.inscribir_alumno(ins1);
        ins_data.inscribir_alumno(ins2);
*/   
        
//----------      Bloque de Testeo de DESINCRIBIR una INSCRIPCION       ------------------------                       
 /*       
        Conexion conexion = new Conexion();
        //AlumnoData alumno_data = new AlumnoData(conexion);
        alumno_data.buscaralumno
        //MateriaData materia_data = new MateriaData(conexion);
        InscripcionesData ins_data = new InscripcionesData(conexion);
        
        ins_data.desinscribir_alumno(28);
        //ins_data.desinscribir_alumno(12);
    
 */
 
 //----------      Bloque de Testeo de Registrar Nota de  una INSCRIPCION       ------------------------                       
  /*     
        Conexion conexion = new Conexion();
        //AlumnoData alumno_data = new AlumnoData(conexion);
        //MateriaData materia_data = new MateriaData(conexion);
        InscripcionesData ins_data = new InscripcionesData(conexion);
        
        //int id_alumno, int id_materia, double not
        //ins_data.registrar_nota(46, 20, 3.0);
        ins_data.registrar_nota(2, 4, 3.0);
    
 
 
 */
 
//----------      Bloque de Testeo de Mostrar Alumnos de una materia id de materia   ------------------------		
/*			 	
		 Conexion conexion = new Conexion();
                AlumnoData alumno_data = new AlumnoData(conexion);
                MateriaData materia_data = new MateriaData(conexion);
                InscripcionesData ins_data = new InscripcionesData(conexion);
        
                 List <Alumno> aux=ins_data.alumnos_en_materia(27);
                System.out.println("EN la materia 27 los alumnos son: ");	 	
		for(Alumno alu: aux){
                    System.out.println(alu);
                
                }
		
*/			
//-----------------------------------------------------------------------------------	
		 
//----------      Bloque de Testeo de Mostrar Materias de un Alumno por id de alumno   ------------------------		

/*

		 Conexion conexion = new Conexion();
                AlumnoData alumno_data = new AlumnoData(conexion);
                MateriaData materia_data = new MateriaData(conexion);
                InscripcionesData ins_data = new InscripcionesData(conexion);
        
                 List <Materia> aux=ins_data.materias_alumno(7);
                System.out.println("EN la materia 27 los alumnos son: ");	 	
		for(Materia alu: aux){
                    System.out.println(alu);
                }
		
*/

//-----------------------------------------------------------------------------------	
		 
		
//----------      Bloque de Testeo de Mostrar Notas de Alumnos  ------------------------		



		 Conexion conexion = new Conexion();
                AlumnoData alumno_data = new AlumnoData(conexion);
                MateriaData materia_data = new MateriaData(conexion);
                InscripcionesData ins_data = new InscripcionesData(conexion);
        
                
             
                //Iterator<Map.Entry<Materia, Double>> it = ins_data.notas_alumno(47).entrySet().iterator();
                System.out.println("La nota del alumno 47 son: ");
               // while (it.hasNext()) {
                //System.out.println("Materia: "+it.next().getKey().getNombre_materia()+" nota: "+it.next().getValue());
                // }
                ins_data.notas_alumno(47);

                
                

		


//-----------------------------------------------------------------------------------				

		

	   	



        
        }
    
        
        

}
