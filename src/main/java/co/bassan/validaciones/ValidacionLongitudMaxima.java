package co.bassan.validaciones;

import co.bassan.general.model.ErrorCampo;
import co.bassan.general.model.InfCampo;
import co.bassan.general.util.UtilProcesador;
import co.bassan.validaciones.core.Validacion;

import java.util.List;

/**
 * Created by sebas on 18/08/15.
 */
public class ValidacionLongitudMaxima implements Validacion {

    private static ValidacionLongitudMaxima intancia;

    public ValidacionLongitudMaxima() {
    }


    public static ValidacionLongitudMaxima obtenerInstancia() {
        if ((intancia!=null)) {
            return intancia;
        } else {
            return new ValidacionLongitudMaxima();
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
        if (infCampo.getValidaciones()!=null && infCampo.getValidaciones().getLongitudMaxima() != 0) {
            if (infCampo.getValor().length() >  infCampo.getValidaciones().getLongitudMaxima()) {
                UtilProcesador.adicionarError(errores, fila, infCampo.getPosicion(), "El campo " + infCampo.getNombreCampoArchivo() + " , Tiene la longitud maxima (" + infCampo.getValidaciones().getLongitudMaxima() + ")", infCampo.getValor());
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
