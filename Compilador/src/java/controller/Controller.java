/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import Model.Model;
import java.io.*;
/**
 *
 * @author scorpion
 */
@Named(value = "controller")
@RequestScoped

public class Controller {
    
   private File Archivo;

    public File getArchivo() {
        return Archivo;
    }

    public void setArchivo(File Archivo) {
        this.Archivo = Archivo;
    }
   
    public String Uplod(){
        String document = "";
        
        try {
            FileReader file = new FileReader(getArchivo());
            BufferedReader read = new BufferedReader(file);
            document = read.readLine();
        } catch (Exception e) {
        }
        
        return document;
    }
}
