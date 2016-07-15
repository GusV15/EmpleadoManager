package ar.com.itMaster.empleadoManager.persistencia;

import com.mycompany.empleadomanager.modelo.DBInMemory;
import com.mycompany.empleadomanager.modelo.Empleado;
import junit.framework.TestCase;


public class PersistenciaTest extends TestCase {
    
    public PersistenciaTest(String testName) {
        super(testName);
    }
    
    public void testSalvarEmpleado(){
        Empleado emp = new Empleado();
        
        emp.setNombre("Cosme");
        emp.setEdad(67);
        
        DBInMemory db = new DBInMemory();
        
        db.almacenar(emp);
        Empleado empleadoDesdeLaBase = db.buscarEmpleado(emp.getId());
        
        assertEquals(emp, empleadoDesdeLaBase);
    }
    
    
}
