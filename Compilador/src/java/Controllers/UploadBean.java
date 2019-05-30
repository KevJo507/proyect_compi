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
 * @author Josue & KevinH
 */
@Named(value = "uploadBean")

@ManagedBean
@ViewScoped

public class UploadBean extends Variables {
    
    String linea;
    String[] registro;
    
    ALexico ALexico = new ALexico();
    TablaSimbolo Tsimbol = new TablaSimbolo();
        
    public void upload() throws IOException {
        clean();
        Archivo();
        AnalisisLexico();
//        AnalisisSitactico();
//        AnalisisSemantico();
    }  
    
    public void Archivo() throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader(file.getInputStream()));
        archivo += ".::ARCHIVO DE TEXTO::.\n\n";
        while((linea = leer.readLine())!= null){
            registro = linea.split("\\|");
            for(int i=0; i < registro.length; i++){
                archivo += registro[i] + " | ";
            }
            archivo += "\n";
        }
    }
    
    public void AnalisisLexico() throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader(file.getInputStream()));
        int l = 0;
        lexico += ".::ANALIZADOR LEXICO::.\n\n";
        while((linea = leer.readLine())!= null){
            registro = (linea.split("\\|"));
            lexico += l+ "| ";
            
            for(int i=0; i < registro.length; i++){
                lexico += registro[i] + " | ";
            }
            lexico += "\n";         
            
            String [] t;
            
            for(int j =0; j<(registro.length); j++){
                t = registro[j].split(" ");
                for(int i =0;i < t.length; i++){

                    if(ALexico.esNumero(t[i]) != ""){
                        lexico += ALexico.esNumero(t[i]);
                    } 
                    else if(ALexico.esTexto(t[i]) == true){
                        lexico +="Token: id, Lexema:" + t[i];
                    }
                    else if(ALexico.esDecimal(t[i]) != ""){
                        lexico += ALexico.esDecimal(t[i]);
                    }
                    else if(ALexico.esSimbolo(t[i]) == true){
                        lexico +="Token: Simbolo, Lexema:" + t[i];
                    }
                    lexico += "\n";
                    
                }
            }
            l++;
            lexico += "\n";   
        }
    }
    
    public void AnalisisSitactico() throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader(file.getInputStream()));
        
        while((linea = leer.readLine())!= null){
            registro = linea.split("\\|");
            for(int i=0; i < registro.length; i++){
                sintactico += registro[i] + " | ";
            }
            sintactico += "\n";         
        }
    }
    
    public void AnalisisSemantico() throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader(file.getInputStream()));
        
        while((linea = leer.readLine())!= null){
            registro = linea.split("\\|");
            for(int i=0; i < registro.length; i++){
                semantico += registro[i] + " | ";
            }
            semantico += "\n";  
        }
    }
    
    public void clean(){
        setArchivo("");
        setLexico("");
        setSemantico("");
        setSintactico("");        
    }
} 
    
