package co.bassan.validaciones;

import co.bassan.general.model.ErrorCampo;
import co.bassan.general.model.InfCampo;
import co.bassan.general.util.UtilProcesador;
import co.bassan.validaciones.core.Validacion;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if (infCampo.getValidaciones()!=null && infCampo.getValidaciones().getExprecion() != null &&  !infCampo.getValidaciones().getExprecion().isEmpty()) {
            Pattern pattern = Pattern.compile(infCampo.getValidaciones().getExprecion());
            Matcher matcher = pattern.matcher(infCampo.getValor());
            if (!matcher.matches()) {
                UtilProcesador.adicionarError(errores, fila, infCampo.getPosicion(), "El campo " + infCampo.getNombreCampoArchivo() + " , No tiene el formato adecuado (" +infCampo.getValidaciones().getExprecion() + ")", infCampo.getValor());
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
