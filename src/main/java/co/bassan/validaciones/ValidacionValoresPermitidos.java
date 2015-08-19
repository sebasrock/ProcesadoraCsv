package co.bassan.validaciones;

import co.bassan.general.model.ErrorCampo;
import co.bassan.general.model.InfCampo;
import co.bassan.general.util.UtilProcesador;
import co.bassan.validaciones.core.Validacion;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sebas on 18/08/15.
 */
public class ValidacionValoresPermitidos implements Validacion {

    private static ValidacionValoresPermitidos intancia;

    public ValidacionValoresPermitidos() {
    }


    public static ValidacionValoresPermitidos obtenerInstancia() {
        if(intancia!=null){
            return intancia;
        } else {
            return new ValidacionValoresPermitidos();
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
        if (infCampo.getValidaciones()!=null && infCampo.getValidaciones().getListaLimitante() != null && infCampo.getValidaciones().getListaLimitante().length > 0) {
            if (!Arrays.asList(infCampo.getValidaciones().getListaLimitante()).contains(infCampo.getValor())) {
                UtilProcesador.adicionarError(errores, fila, infCampo.getPosicion(), "El campo " + infCampo.getNombreCampoArchivo() + " , No tiene un valor permitido (" + Arrays.toString(infCampo.getValidaciones().getListaLimitante()) + ")", infCampo.getValor());
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
