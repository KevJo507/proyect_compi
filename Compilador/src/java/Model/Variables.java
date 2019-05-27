/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    protected String lexico ="" ;
    protected String  semantico = "";
    protected String  Sintactico = "";

    
    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
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
        return Sintactico;
    }

    public void setSintactico(String Sintactico) {
        this.Sintactico = Sintactico;
    }
    

}
