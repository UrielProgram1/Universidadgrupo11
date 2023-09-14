
package universidadgrupo11;

import java.time.LocalDate;
import universidadgrupo11.accesoADatos.*;
//import universidadgrupo11.accesoADatos.AlumnoData;
//import universidadgrupo11.accesoADatos.InscripcionData;
//import universidadgrupo11.accesoADatos.MateriaData;
import universidadgrupo11.entidades.Alumno;
import universidadgrupo11.entidades.Inscripcion;
import universidadgrupo11.entidades.Materia;

/*
import java.sql.Connection;
import universidadgrupo11.accesoADatos.Conexion;
*/

public class Universidadgrupo11 {

    public static void main(String[] args) {
    
        //Connection con=Conexion.getConexion();
        
        //Alumno uriel=new Alumno(7,44732237, "Gaitán", "Alejandro Uriel", LocalDate.of(2003, 2, 21), true);
       // AlumnoData alu=new AlumnoData();
      //alu.guardarAlumno(uriel);
      //alu.modficarAlumno(uriel);
      //alu.eliminarAlumno(7);
 /* Alumno alumnoEncontrado =alu.buscarAlumno(4);  
      if(alumnoEncontrado!=null){
        System.out.println("Dni: "+alumnoEncontrado.getDni());
        System.out.println("Apellido: "+alumnoEncontrado.getApellido());

     
      } 
*/ 
   /* for(Alumno alumno:alu.listarAlumnos()){
        System.out.println(alumno.getDni());
        System.out.println(alumno.getApellido());
        System.out.println(alumno.getNombre());
        System.out.println(alumno.getFechaNac());

    }
    */
   
   
   
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   
   
   //Materia materia=new Materia(2,"Matematica", 2, true);
   //MateriaData mat=new MateriaData();
   //materia.guardarMateria(matematica);
   //materia.modificarMateria(mate);
   //mat.eliminarMateria(1);
   /*Materia materiaEncontrada= materia.buscarMateria(1);
   if(materiaEncontrada!=null){
       System.out.println("Nombre: "+materiaEncontrada.getNombre());
       System.out.println("Año: "+materiaEncontrada.getAnioMateria());
   }
   */
   /*
   for(Materia materia:mat.listarMaterias()){
       System.out.println("idMatera: "+materia.getIdMateria());
       System.out.println("Nombre: "+materia.getNombre());
       System.out.println("Año: "+materia.getAnioMateria());
       System.out.println("===========");
   }
 */
   
       //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   AlumnoData ad=new AlumnoData();
   MateriaData md=new MateriaData();
   InscripcionData id=new InscripcionData();
   
   Alumno uri=ad.buscarAlumno(7);
   Materia mate=md.buscarMateria(1);
   Inscripcion insc=new Inscripcion(uri, mate, 10);
   id.guardarInscripcion(insc);
   
    }
    
    
    
}
