package co.bassan.validaciones.core;

import co.bassan.general.model.ErrorCampo;
import co.bassan.general.model.InfCampo;

import java.util.List;

/**
 * Created by sebas on 18/08/15.
 */
public interface Validacion {

    boolean ejecutarValidacion(List<ErrorCampo> errores,InfCampo infCampo,int fila);

}
