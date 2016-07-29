/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.itmaster.empleadomanager.persitencia;

import com.mycompany.empleadomanager.modelo.Empleado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author itmasterprofessionaltraining
 */
public class DAODB implements DAO{

    @Override
    public void almacenar(Empleado empleado) {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver");
            try {
                // pide conexion
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/empleado_manager", "root", "");
                //CallableStatement prepareCall = connection.prepareCall("CALL delete(?)");
                // prepara la consulta que va insertar datos
                PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO empleados (nombre, fecha_nacimiento, sueldo, dni) VALUES (?, ?, ?, ?)");
                
                // configura los parametros
                prepareStatement.setString(1, empleado.getNombre());
                prepareStatement.setObject(2, empleado.getFechaNacimiento());
                prepareStatement.setDouble(3, empleado.getSueldo());
                prepareStatement.setString(4, empleado.getDni());
                // ejecuta la consulta
                prepareStatement.execute();
                
                prepareStatement.close();
                
                connection.close();
            }catch (SQLException ex) {
                Logger.getLogger(DAODB.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAODB.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @Override
    public Empleado buscarEmpleado(Long id) {
        return null;
    }
    
}
