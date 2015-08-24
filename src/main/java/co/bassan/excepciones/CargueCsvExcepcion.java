package co.bassan.excepciones;

import co.bassan.general.model.ErrorCampo;

import java.io.IOException;

/**
 * Created by Sebastian- on 15/02/2015.
 */
public class CargueCsvExcepcion extends RuntimeException {

    private ErrorCampo error;

    public CargueCsvExcepcion(String causa, int linea, int fila, Object valor) {
        super();
        error = new ErrorCampo(fila, linea, causa, valor);
    }

    public CargueCsvExcepcion(String causa, Object valor, int fila, int linea) {
        super();
        error = new ErrorCampo(causa, valor, fila, linea);
    }

    public CargueCsvExcepcion(String mensaje, Exception e) {
        super(mensaje, e);
    }

    public CargueCsvExcepcion(String mensaje) {
        super(mensaje);
    }

    public ErrorCampo getError() {
        return error;
    }
}
