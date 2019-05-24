package Controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
    
    private Reader file;
    String[] texto;
    
    public String[] getTexto() {
        return texto;
    }
    public void setTexto(String[] texto) {
        this.texto = texto;
    }

    public Part getFile() {
        return (Part) file;
    }
    public void setFile(Part file) {
        this.file = (Reader) file;
    }
    
//    public void upload() throws IOException {
//       Scanner s = new Scanner(file.getInputStream());
//       String fileContent = s.useDelimiter("\\A").next();
//       System.out.println(fileContent);
//    }
    
    public void upload() throws IOException {
        BufferedReader leer = new BufferedReader(this.file);
        String linea;
        String registro[] = new String[2];
        String respuesta = "Respuesta no registrada";
        
        while( (linea = leer.readLine()) != null){
            registro = linea.split("\\|");
            System.out.println(registro);
        }
    }
}
