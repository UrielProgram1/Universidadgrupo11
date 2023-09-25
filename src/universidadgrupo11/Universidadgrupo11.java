
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
        
        //CLASE ALUMNODATA
        
        //Alumno uriel=new Alumno(11,11735750, "Cesar", "Agustin", LocalDate.of(2002, 1, 03), true);
       AlumnoData alu=new AlumnoData();
       Alumno alumnoEncontrado=alu.buscarAlumnoPorDni(72534637);
      /* if(alumnoEncontrado!=null){
           System.out.println("Apellido: "+alumnoEncontrado.getApellido());
           System.out.println("Nombre: "+alumnoEncontrado.getNombre());
           System.out.println("Fecha De Nacimiento: "+alumnoEncontrado.getFechaNac());
          
       }
       */
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
   
   //CLASE MATERIADATA
   
   
   Materia materia=new Materia(2,"Tecnologia", 3, true);
   MateriaData mat=new MateriaData();
   //mat.guardarMateria(materia);
   //mat.modificarMateria(materia);
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
   
   
   //CLASE INSCRIPCIONDATA
   
   AlumnoData ad=new AlumnoData();
   MateriaData md=new MateriaData();
   InscripcionData id=new InscripcionData();
   
   //Guardar Alumno 
   //Alumno uri=ad.buscarAlumno(10);
   //Materia mate=md.buscarMateria(10);
   //Inscripcion insc=new Inscripcion(uri, mate, 8);
   
   //Guardar Inscripcion de Alumno
  //id.guardarInscripcion(insc);
  
   //Actualizar la nota del Alumno
  // id.actualizarNota(7, 1, 9);
   
   //Borrar Incripcion del Alumno
   //id.borrarInscripcionMateriaAlumno(7, 1);
   
   //Obtener inscripciones 
//   for(Inscripcion inscripcion:id.obtenerInscripciones()){
//       System.out.println("ID "+inscripcion.getIdInscripcion());
//       System.out.println("Apellido "+inscripcion.getAlumno().getApellido());
//       System.out.println("Materia "+inscripcion.getMateria().getNombre());
//       System.out.println("=============================");
//       System.out.println("=============================");

    /*for(Materia materia:id.obtenerAlumnosPorMateria(0)){
        System.out.println("Nombre "+materia.getNombre());
       
   }
   */
   
   
   
   
    }
    
    
    
}
