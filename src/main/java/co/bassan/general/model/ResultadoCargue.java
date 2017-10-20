package co.bassan.general.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian- on 15/02/2015.
 */
public class ResultadoCargue<T> {

    private List<T> elementosCargados;

    private List<ErrorCampo> erroresEcontrados;

    public ResultadoCargue() {
        this.elementosCargados = new ArrayList<>();
        this.erroresEcontrados = new ArrayList<>();
    }

    public List<T> getElementosCargados() {
        return elementosCargados;
    }

    public void setElementosCargados(List<T> elementosCargados) {
        this.elementosCargados = elementosCargados;
    }

    public List<ErrorCampo> getErroresEcontrados() {
        return erroresEcontrados;
    }

    public void setErroresEcontrados(List<ErrorCampo> erroresEcontrados) {
        this.erroresEcontrados = erroresEcontrados;
    }

    public boolean esExitoso() {
        if (erroresEcontrados == null || erroresEcontrados.isEmpty()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
