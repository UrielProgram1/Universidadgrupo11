
package universidadgrupo11.accesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadgrupo11.entidades.Materia;

public class MateriaData {
                        
    private Connection con=null;
   
    public MateriaData(){
        con=Conexion.getConexion();
    }
    
    public void guardarMateria(Materia materia){
       String sql= "INSERT INTO materia (nombre, año, estado) "
               + "VALUES( ?, ?, ?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActivo());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia Guardada.");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia.");
        }
       
       
       
       
    }
    
    public  Materia buscarMateria(int id){
        String sql="SELECT nombre, año, estado FROM materia WHERE idMateria=1 AND estado=1";
           Materia materia=null;
     
     
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps = con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                materia=new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materia.setActivo(true);
            }else{JOptionPane.showMessageDialog(null, "Materia no existente.");}
            ps.close();
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia.");}
        return materia;
    }
    

    
    public void modificarMateria(Materia materia){
        String sql="UPDATE materia SET nombre=?, año=?"
                + "WHERE idMateria=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setInt(3, materia.getIdMateria());
            int exito=ps.executeUpdate();
            if(exito==1){JOptionPane.showMessageDialog(null, "Materia Modificada.");}
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia. "+ex.getMessage());}
    }
    
    public void eliminarMateria(int id){
        String sql="UPDATE materia SET estado=1 WHERE idMateria=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito=ps.executeUpdate();
            if(exito==1){JOptionPane.showMessageDialog(null, "Materia eliminada.");}
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia. "+ex.getMessage());}
        
    }
    
    public List<Materia> listarMaterias(){
        String sql="SELECT idMateria, nombre, año FROM materia WHERE estado=1";
        ArrayList<Materia>materias=new ArrayList<>();
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Materia materia=new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
               materias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia. "+ex.getMessage());
        }
        return materias;
    }
    
    
    
    
    
    
}


