
package universidadgrupo11.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadgrupo11.entidades.Alumno;
import universidadgrupo11.entidades.Inscripcion;
import universidadgrupo11.entidades.Materia;

public class InscripcionData {
    
    private Connection con=null;
    private MateriaData matData=new MateriaData();
    private AlumnoData aluData=new AlumnoData();
    
    
    public InscripcionData(){this.con=Conexion.getConexion();}
    
    public void guardarInscripcion(Inscripcion insc){
        String sql="INSERT INTO inscripcion(nota, idAlumno, idMateria)"
                + "VALUES(?, ?, ?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIdAlumno());
            ps.setInt(3, insc.getMateria().getIdMateria());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripcion guardada.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion. "+ex.getMessage());
        }
        
        
    }
    
    public void actualizarNota(int idAlumno, int idMateria, double nota){
        String sql="UPDATE inscripcion SET nota=? WHERE idAlumno=? AND idMateria=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int resultado=ps.executeUpdate();
            if(resultado==1){JOptionPane.showMessageDialog(null, "Nota actualizada.");}
            
            
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion. "+ex.getMessage());
        }
        
    }
    
    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria){
        
        String sql="DELETE FROM inscripcion WHERE idAlumno=? AND idMateria=?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int filas=ps.executeUpdate();
            if(filas==1){JOptionPane.showMessageDialog(null, "Inscripción borrada.");}
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
            
  public List<Inscripcion> obtenerInscripciones(){
      
      ArrayList<Inscripcion> cursadas=new ArrayList<>();
      String sql="SELECT * FROM inscripcion";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
              Inscripcion insc=new Inscripcion();
              insc.setIdInscripcion(rs.getInt("idInscripto"));
              Alumno alu=aluData.buscarAlumno(rs.getInt("idAlumno"));
              Materia mat=matData.buscarMateria(rs.getInt("idMateria"));
              insc.setAlumno(alu);
              insc.setMateria(mat);
              insc.setNota(rs.getDouble("nota"));
              cursadas.add(insc);
              
            }
            ps.close();
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion. "+ex.getMessage());
        }
      
      return cursadas;
      
      
  }
    
   public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno){
      
      ArrayList<Inscripcion> cursadas=new ArrayList<>();
      String sql="SELECT * FROM inscripcion WHERE idAlumno=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
              Inscripcion insc=new Inscripcion();
              insc.setIdInscripcion(rs.getInt("idInscripto"));
              Alumno alu=aluData.buscarAlumno(rs.getInt("idAlumno"));
              Materia mat=matData.buscarMateria(rs.getInt("idMateria"));
              insc.setAlumno(alu);
              insc.setMateria(mat);
              insc.setNota(rs.getDouble("nota"));
              cursadas.add(insc);
              
            }
            ps.close();
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion. "+ex.getMessage());
        }
      
      return cursadas;
    
   }
   
   public List<Materia> obtenerMateriasCursadas(int idAlumno){
       ArrayList<Materia>materias=new ArrayList<>();
       String sql="SELECT inscripcion.idMateria, nombre, año "
               + "FROM inscripcion, materia "
               + "WHERE inscripcion.idMateria=materia.idMateria "
               + "AND inscripcion.idAlumno= ?;";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Materia materia=new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion.");
        }
       return materias;
   }
   
   public List<Materia> obtenerMateriasNoCursadas(int idAlumno){
       ArrayList<Materia> materias=new ArrayList<>();
       String sql="SELECT * FROM materia"
               + "WHERE estado=1 AND idMateria NOT IN"
               + "(SELECT idMateria FROM inscripcion WHERE idAlumno=?)";
               
                try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Materia materia=new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion.");
        }
       return materias;
   }
   
   public List<Alumno> obtenerAlumnosPorMateria(int idMateria){
       ArrayList <Alumno> alumnos=new ArrayList<>();
       String sql="SELECT a.idAlumno, dni, nombre, apellido, fechaNacimiento, estado"
               + "FROM inscripcion i, alumno a WHERE i.idAlumno=a.idAlumno AND idMateria=? AND a.estado=1";
       
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Alumno alumno=new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                alumnos.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion.");
        }
       
       return alumnos;
   }
   
   
}
