
package universidadgrupo11;

import java.time.LocalDate;
import universidadgrupo11.accesoADatos.AlumnoData;
import universidadgrupo11.entidades.Alumno;

/*
import java.sql.Connection;
import universidadgrupo11.accesoADatos.Conexion;
*/

public class Universidadgrupo11 {

    public static void main(String[] args) {
    
        //Connection con=Conexion.getConexion();
        
        Alumno uriel=new Alumno(7,44732237, "Gaitán", "Alejandro Uriel", LocalDate.of(2003, 2, 21), true);
        AlumnoData alu=new AlumnoData();
      //alu.guardarAlumno(uriel);
      //alu.modficarAlumno(uriel);
      //alu.eliminarAlumno(7);
 /* Alumno alumnoEncontrado =alu.buscarAlumno(4);  
      if(alumnoEncontrado!=null){
        System.out.println("Dni: "+alumnoEncontrado.getDni());
        System.out.println("Apellido: "+alumnoEncontrado.getApellido());

     
      }
*/
    for(Alumno alumno:alu.listarAlumnos()){
        System.out.println(alumno.getDni());
        System.out.println(alumno.getApellido());
        System.out.println(alumno.getNombre());
        System.out.println(alumno.getFechaNac());
    }
    
    }
    
    
    
}
