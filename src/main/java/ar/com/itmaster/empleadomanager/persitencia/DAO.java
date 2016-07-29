
package ar.com.itmaster.empleadomanager.persitencia;

import com.mycompany.empleadomanager.modelo.Empleado;


public interface DAO {
    public void almacenar(Empleado empleado);
    public Empleado buscarEmpleado(Long id);
}
