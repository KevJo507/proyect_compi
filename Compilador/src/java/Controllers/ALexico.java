package Controllers;

import Controllers.UploadBean;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author LSOPORTEJ
 */

@Named(value = "aLexico")

@ManagedBean
@ViewScoped

public class ALexico {
    private String[] registro;
    
    public String[] getRegistro(){
        return this.registro;
    }
    
    public boolean esNumero(String numero) {
        String  digito = "[0-9]";
        String caracter = "";
        int estado = 1;
        for (int i = 0; i < numero.length(); i++) {
            caracter = numero.charAt(i) + "";
            switch (estado) {
                case 1:
                    if (caracter.matches(digito)) {
                        estado = 1;
                    } else {
                        estado = 2;
                    }
                    break;
            }
        }
        if (estado != 2) {
            System.out.print(numero + "Es numero");
            return true;
        }
        System.out.print(numero + "No es numero");
        return false;
    }

    public void Guardar() throws FileNotFoundException, IOException{
        UploadBean archivo = new UploadBean();
        BufferedReader leer = new BufferedReader(new FileReader((File) archivo.getFile()));
        String linea;
        this.registro = new String[2];  
        
        while((linea = leer.readLine()) != null){
            this.registro = linea.split("\\|");
        }
    }
}
