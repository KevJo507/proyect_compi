package Controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;

/**
 *
 * @author josue
 */
@Named(value = "uploadBean")

@ManagedBean
@ViewScoped

public class UploadBean {
    
    private Part file;
    String archivo = "";
    String lexema = "";
    String sintaxis = "";

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public String getSintaxis() {
        return sintaxis;
    }

    public void setSintaxis(String sintaxis) {
        this.sintaxis = sintaxis;
    }
    
    public String getArchivo() {
        return archivo;
    }
    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public Part getFile() {
        return file;
    }
    public void setFile(Part file) {
        this.file = file;
    }
    
//    public void upload() throws IOException {
//       Scanner s = new Scanner(file.getInputStream());
//       String fileContent = s.useDelimiter("\\A").next();
//       System.out.println(fileContent);
//    }
    
    public void upload() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String linea;
        String registro[] = new String[2];
                
        while( (linea = leer.readLine()) != null){
            registro = linea.split("\\|");
            this.archivo += registro[0] +" ";
            this.archivo += registro[1] +"\n";
            
        }
        
        lexema();
    }
    
    public void lexema() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String linea;
        String registro[] = new String[2];
                
        while( (linea = leer.readLine()) != null){
            registro = linea.split("\\|");
            this.lexema +="2 "+ registro[0] +" ";
            this.lexema += registro[1] +"\n";
            
        }
    }
}
