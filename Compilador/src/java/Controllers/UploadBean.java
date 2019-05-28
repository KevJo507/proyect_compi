package Controllers;

import Model.Variables;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author josue
 */
@Named(value = "uploadBean")

@ManagedBean
@ViewScoped

public class UploadBean extends Variables {
    
    String linea;
    String[] registro = new String[2];
        
    public void upload() throws IOException {
        clean();
        Archivo();
        AnalisisLexico();
        AnalisisSitactico();
        AnalisisSemantico();
    }  
    
    public void Archivo() throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader(file.getInputStream()));
        
        while((linea = leer.readLine())!= null){
            registro = linea.split("\\|");
            archivo += registro[0] + " | " + registro[1] +"\n";
        }
    }
    
    public void AnalisisLexico() throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader(file.getInputStream()));
        
        while((linea = leer.readLine())!= null){
            registro = linea.split("\\|");
            lexico += registro[0] + " | " + registro[1] +"\n";
        }
    }
    
    public void AnalisisSitactico() throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader(file.getInputStream()));
        
        while((linea = leer.readLine())!= null){
            registro = linea.split("\\|");
            sintactico += registro[0] + " | " + registro[1] +"\n";
        }
    }
    
    public void AnalisisSemantico() throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader(file.getInputStream()));
        
        while((linea = leer.readLine())!= null){
            registro = linea.split("\\|");
            semantico += registro[0] + " | " + registro[1] +"\n";
        }
    }
    
    public void clean(){
        setArchivo("");
        setLexico("");
        setSemantico("");
        setSintactico("");        
    }
} 
    
