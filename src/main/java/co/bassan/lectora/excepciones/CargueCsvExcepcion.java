package co.bassan.lectora.excepciones;

import co.bassan.lectora.model.ErrorCampo;

/**
 * Created by Sebastian- on 15/02/2015.
 */
public class CargueCsvExcepcion extends Exception {

    private ErrorCampo error;

    public CargueCsvExcepcion(String causa, int linea, int fila, Object valor) {
        super();
        error = new ErrorCampo(fila, linea, causa, valor);
    }

    public CargueCsvExcepcion(String causa, Object valor, int fila,int linea) {
        super();
        error = new ErrorCampo(causa, valor, fila,linea);
    }

    public ErrorCampo getError() {
        return error;
    }
}
