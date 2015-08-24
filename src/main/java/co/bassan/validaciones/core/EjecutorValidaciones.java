package co.bassan.validaciones.core;

import co.bassan.general.model.ErrorCampo;
import co.bassan.general.model.InfCampo;
import co.bassan.validaciones.*;

import java.util.List;

/**
 * Created by sebas on 18/08/15.
 */
public  class EjecutorValidaciones {


    public void ejecutarValidacionesParametrizadas(List<ErrorCampo> listaErrores,InfCampo infCampo, int lineaEjecutada)
    {

        ValidacionRequerido.obtenerInstancia().ejecutarValidacion(listaErrores,infCampo,lineaEjecutada);
        ValidacionLongitudMinima.obtenerInstancia().ejecutarValidacion(listaErrores,infCampo,lineaEjecutada);
        ValidacionLongitudMaxima.obtenerInstancia().ejecutarValidacion(listaErrores,infCampo,lineaEjecutada);
        ValidacionExprecion.obtenerInstancia().ejecutarValidacion(listaErrores,infCampo,lineaEjecutada);
        ValidacionValoresPermitidos.obtenerInstancia().ejecutarValidacion(listaErrores,infCampo,lineaEjecutada);
        ValidacionFechaMinima.obtenerInstancia().ejecutarValidacion(listaErrores,infCampo,lineaEjecutada);
        ValidacionFechaMaxima.obtenerInstancia().ejecutarValidacion(listaErrores,infCampo,lineaEjecutada);

    }
}
