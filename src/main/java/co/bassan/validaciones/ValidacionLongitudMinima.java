package co.bassan.validaciones;

import co.bassan.general.model.ErrorCampo;
import co.bassan.general.model.InfCampo;
import co.bassan.general.util.UtilProcesador;
import co.bassan.validaciones.core.Validacion;

import java.util.List;

/**
 * Created by sebas on 18/08/15.
 */
public class ValidacionLongitudMinima implements Validacion {

    private static ValidacionLongitudMinima intancia;

    public ValidacionLongitudMinima() {
    }


    public static ValidacionLongitudMinima obtenerInstancia() {
        if ((intancia!=null)) {
            return intancia;
        } else {
            return new ValidacionLongitudMinima();
        }
    }

    /**
     * Valida si un campo es requerido
     *
     * @param errores
     * @param infCampo
     * @return
     */
    @Override
    public boolean ejecutarValidacion(List<ErrorCampo> errores, InfCampo infCampo, int fila) {
        if (infCampo.getValidaciones()!=null && infCampo.getValidaciones().getLongitudMinima() != 0) {
            if (infCampo.getValor().length() < infCampo.getValidaciones().getLongitudMinima()) {
                UtilProcesador.adicionarError(errores, fila, infCampo.getPosicion(), "El campo " + infCampo.getNombreCampoArchivo() + " , No tiene la longitud minima (" +infCampo.getValidaciones().getLongitudMinima() + ")", infCampo.getValor());
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
