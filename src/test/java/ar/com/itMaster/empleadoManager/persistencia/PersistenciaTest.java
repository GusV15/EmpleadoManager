package ar.com.itMaster.empleadoManager.persistencia;

import ar.com.itmaster.empleadomanager.persitencia.DBInFile;
import ar.com.itmaster.empleadomanager.persitencia.DBInMemory;
import com.mycompany.empleadomanager.modelo.Empleado;
import java.time.LocalDate;
import junit.framework.TestCase;


public class PersistenciaTest extends TestCase {
    
    public PersistenciaTest(String testName) {
        super(testName);
    }
    
    public void testSalvarEmpleadoEnMemoria(){
        Empleado emp = new Empleado();
        
        emp.setNombre("Cosme");
        emp.setFechaNacimiento(LocalDate.MIN);
        
        DBInMemory db = new DBInMemory();
        
        db.almacenar(emp);
        Empleado empleadoDesdeLaBase = db.buscarEmpleado(emp.getId());
        
        assertEquals(emp, empleadoDesdeLaBase);
    }
    
    public void testSalvarEmpleadoEnArchivo(){
        Empleado emp = new Empleado();
        
        emp.setNombre("Cosme");
        emp.setFechaNacimiento(LocalDate.MIN);
        
        DBInFile db = new DBInFile();
        
        db.almacenar(emp);
        Empleado empleadoDesdeLaBase = db.buscarEmpleado(emp.getId());
        
        assertEquals(emp, empleadoDesdeLaBase);
        
    }
    
    
}
