
package ar.com.itmaster.empleadomanager.persitencia;

import com.mycompany.empleadomanager.modelo.Empleado;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBInFile implements DAO {
    
    private Long lastID = 0L;
    private Map<Long, Empleado> datos = new HashMap<>();
    private File file = new File("texto.txt");
   
    public void almacenar(Empleado emp) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(emp.getNombre());
            bw.write(",");
            bw.write(emp.getFechaNacimiento() != null ? emp.getFechaNacimiento().toString() : "");        
            bw.write(",");
            bw.write(emp.getDni());
            bw.write(",");
            bw.write(emp.getId().toString());
            bw.write(",");
            bw.write(String.valueOf(emp.getSueldo()));
            bw.newLine();
        } catch (IOException ex) {
            Logger.getLogger(DBInFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(DBInFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
    }

    public Empleado buscarEmpleado(Long id) {
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while(linea != null){
                String[] datos = linea.split(",");
                if (Long.valueOf(datos[3]).equals(id)) {
                    
                }
                linea = br.readLine();
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBInFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DBInFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(DBInFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
