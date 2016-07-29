/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.itmaster.empleadomanager.persitencia;

import com.mycompany.empleadomanager.modelo.Empleado;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author itmasterprofessionaltraining
 */
public class DBInMemory implements DAO{
    
    private Long lastID = 0L;
    private static Map<Long, Empleado> datos = new HashMap<>();
    
    public void almacenar(Empleado emp) {
        //Validaciones 
        if (emp == null) {
            throw new IllegalArgumentException("El empleado no puede ser null");
        }
        if (emp.getId() != null) {
            throw new IllegalArgumentException("El empleado ya existe");
        }
        //Salvar
        lastID = lastID +1L;
        emp.setId(lastID);
        datos.put(emp.getId(), emp);
        
    }

    public Empleado buscarEmpleado(Long id) {
      
        return datos.get(id);
    }
    // Tarea: Implementar remover, modificar y buscar por nombre.
}
