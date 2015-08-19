package co.bassan.validaciones;

import co.bassan.general.model.ErrorCampo;
import co.bassan.general.model.InfCampo;
import co.bassan.general.util.UtilProcesador;
import co.bassan.validaciones.core.Validacion;

import java.util.List;

/**
 * Created by sebas on 18/08/15.
 */
public class ValidacionExprecion implements Validacion {

    private static ValidacionExprecion intancia;

    public ValidacionExprecion() {
    }


    public static ValidacionExprecion obtenerInstancia() {
        if ((intancia!=null)) {
            return intancia;
        } else {
            return new ValidacionExprecion();
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
        if (infCampo.getValidaciones()!=null && infCampo.getValidaciones().getExprecion() != null) {
            if (infCampo.getValor().matches(infCampo.getValidaciones().getExprecion())) {
                UtilProcesador.adicionarError(errores, fila, infCampo.getPosicion(), "El campo " + infCampo.getNombreCampoArchivo() + " , No tiene el formato adecuado (" +infCampo.getValidaciones().getExprecion() + ")", infCampo.getValor());
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
