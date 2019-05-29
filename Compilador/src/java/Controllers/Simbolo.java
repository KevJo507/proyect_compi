package Controllers;

/**
 *
 * @author outkmqg
 */
public class Simbolo {
    private String token;
    private String lexema;
    private boolean palabraReservada;
    
    public Simbolo(String token, String lexema, boolean palabraReservada){
        this.token = token;
        this.lexema = lexema;
        this.palabraReservada = palabraReservada;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public boolean isPalabraReservada() {
        return palabraReservada;
    }

    public void setPalabraReservada(boolean palabraReservada) {
        this.palabraReservada = palabraReservada;
    } 
}
