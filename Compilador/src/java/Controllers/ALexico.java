package Controllers;

import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author KevinH
 */

@Named(value = "aLexico")

@ManagedBean
@ViewScoped

public class ALexico {
        
    public boolean esTexto(String texto) {
        String letra = "[A-Za-z]";
        String digitoLetra = "[0-9A-Za-z]";
        String caracter = "";
        int estado = 1;
        for (int i = 0; i < texto.length(); i++) {
            caracter = texto.charAt(i) + "";
            switch (estado) {
                case 1:
                    if (caracter.matches(letra)) {
                        estado = 2;
                    } else if(caracter.matches(" ")){
                        estado = 2;
                    } else {
                        estado = 3;
                    }
                    break;
                case 2:
                    if (caracter.matches(digitoLetra)) {
                        estado = 2;
                    } else if(caracter.matches(" ")){
                        estado = 2;
                    } else {
                        estado = 3;
                    }
                    break;
            }
        }
        if (estado != 3) {
            return true;
        }
        return false;
    }
    
    public String esNumero(String numero) {
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
            return "Token: Numero entero, Lexema:" + numero;
        }
        return "";
    }
    
    public boolean esSimbolo(String cadena){
       String[] sim = {"\\*", "\\/", "\\-", "\\+", "\\.", "\\|", "\\°", "\\!", "\\#", "\\$", 
                       "\\%", "\\&", "\\/", "\\(", "\\)", "\\=", "\\?", "\\¡", "\\]", "\\'", 
                       "\\¿", "\\}", "\\´", "\\;", "\\:", "\\,", "\\-", "\\_", "\\<", "\\>"};
       String caracter = "";
       int estado = 0;
       for(int i = 0; i < cadena.length(); i++){
           caracter = (cadena.charAt(i)) + "";
           for(int j = 0; j < sim.length; j++){
               if(caracter.matches(sim[j])){
                   estado = 1;
               }
           }
       }
       if (estado != 0) {
            return true;
        }
        return false;
    }
    
    public String esDecimal(String numero) {
        String caracter ="";
        int estado = 1;
        
        for(int i = 0; i < numero.length(); i++ ){
            caracter = numero.charAt(i) + "";
            
            switch(estado) {
                case 1:
                    if(esNumero(caracter) != ""){
                        estado = 1;
                    } else {
                        estado = 2;
                        i--;
                    }
                    break;
                case 2:
                    if(caracter.matches("\\.")){
                        estado = 1;
                    } else {
                        estado = 3;
                        i--;
                    }
                    break;
                case 3:
                    if(esSimbolo(caracter)){
                        estado = 4;
                    } 
                    break;
            }
        }
        if (estado != 4) {
            return "Token: Numero decimal, Lexema:" + numero;
        } 
            return "";
    }
   
}
