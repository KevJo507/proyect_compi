package Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author KevinH
 */

@Named(value = "Tsimbolos")

@ManagedBean
@ViewScoped
public class TablaSimbolo {

    public static TablaSimbolo INSTANCE;

    public static TablaSimbolo getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new TablaSimbolo();
        }
        return INSTANCE;
    }

    public ArrayList<Simbolo> simbolosInicial;

    public TablaSimbolo() {
        simbolosInicial = new ArrayList<Simbolo>(
                Arrays.asList(new Simbolo("NB", "Nombre Banco", true), new Simbolo("NC", "Numero Cuenta", true),
                        new Simbolo("NCH", "Numero de Cheque", true), new Simbolo("LF", "Lugar y Fecha", true),
                        new Simbolo("P", "Propietario", true), new Simbolo("MC", "Monto", true),
                        new Simbolo("ML", "Monto en letras", true), new Simbolo("F", "Firma", true)));
    }
    
    public ArrayList<Simbolo> getSimbolosInicial() {
		return simbolosInicial;
	}

	public void setSimbolosInicial(ArrayList<Simbolo> simbolosInicial) {
		this.simbolosInicial = simbolosInicial;
	}
}
