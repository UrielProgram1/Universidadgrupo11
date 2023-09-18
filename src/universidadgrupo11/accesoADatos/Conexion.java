
package universidadgrupo11.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    
    private static final String URL="jdbc:mariadb://localhost:3306/";
    private static final String DB="universidadgrupo11";
    private static final String USUARIO="root";
    private static final String PASSWORD="";
    private static Connection connection;
    
    private Conexion(){}
    
    public static Connection getConexion(){
        
        if(connection==null){
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL+DB, USUARIO, PASSWORD);
                //JOptionPane.showMessageDialog(null, "Conexion con éxito.");
                
                
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar el Driver"+ex.getMessage());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de Conexion"+ex.getMessage());
            }
        }
        return connection;
    }
    
}
