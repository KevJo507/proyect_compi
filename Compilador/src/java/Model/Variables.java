package Model;

import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author josue
 */
@Named(value = "variables")
public class Variables {
        
    protected Part file;
    protected String lexico = ".::ANALIZADOR LEXICO::.\n\n";
    protected String semantico = ".::ANALIZADOR SEMANTICO::.\n\n";
    protected String sintactico = ".::ANALIZADOR SINTACTICO::.\n\n";
    protected String archivo = ".::ARCHIVO DE TEXTO::.\n\n";
    
    public Part getFile() {
        return file;
    }
    public void setFile(Part file) {
        this.file = file;
    }
    
    public String getArchivo() {
        return archivo;
    }
    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getLexico() {
        return lexico;
    }
    public void setLexico(String lexico) {
        this.lexico = lexico;
    }

    public String getSemantico() {
        return semantico;
    }
    public void setSemantico(String semantico) {
        this.semantico = semantico;
    }

    public String getSintactico() {
        return sintactico;
    }
    public void setSintactico(String sintactico) {
        this.sintactico = sintactico;
    }
    

}
