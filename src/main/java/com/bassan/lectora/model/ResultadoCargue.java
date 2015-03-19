package com.bassan.lectora.model;

import java.util.List;

/**
 * Created by Sebastian- on 15/02/2015.
 */
public class ResultadoCargue<T> {
    List<T> elementosCargados;

    List<ErrorCampo> erroresEcontrados;


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
