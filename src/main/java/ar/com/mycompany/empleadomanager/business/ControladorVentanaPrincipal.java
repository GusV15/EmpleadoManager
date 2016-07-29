package ar.com.mycompany.empleadomanager.business;

import ar.com.itmaster.empleadomanager.persitencia.DAO;
import ar.com.itmaster.empleadomanager.persitencia.DAODB;
import ar.com.itmaster.empleadomanager.persitencia.DBInMemory;
import com.mycompany.empleadomanager.modelo.Empleado;


public class ControladorVentanaPrincipal {
    
    public static void grabarEmpleado(Empleado empleado){
        // Aqui deben agregar las validadiciones del negocio
        
        // Luego de validar todo, procedemos a salvar el empleado
        DAO dao = new DAODB();
        dao.almacenar(empleado);
    }

   
    
}

