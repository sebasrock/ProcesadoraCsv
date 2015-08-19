package co.bassan.validaciones;

import co.bassan.general.model.ErrorCampo;
import co.bassan.general.model.InfCampo;
import co.bassan.general.util.UtilProcesador;
import co.bassan.validaciones.core.Validacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by sebas on 18/08/15.
 */
public class ValidacionFechaMinima implements Validacion {

    private static ValidacionFechaMinima intancia;

    public ValidacionFechaMinima() {
    }


    public static ValidacionFechaMinima obtenerInstancia() {
        if ((intancia!=null)) {
            return intancia;
        } else {
            return new ValidacionFechaMinima();
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
        if (infCampo.getValidaciones()!=null && infCampo.getValidaciones().getFechaMinima() != null && !infCampo.getValidaciones().getFechaMaxima().isEmpty()) {
            Date fechaMin = validarFormatoFecha(infCampo.getValidaciones().getFormatoFecha(),
                    infCampo.getValidaciones().getFechaMinima(),
                    errores, fila, infCampo.getPosicion(),
                    "Fecha minima" + infCampo.getNombreCampoArchivo());
            Date fecha = validarFormatoFecha(infCampo.getValidaciones().getFormatoFecha(),
                    infCampo.getValor(), errores, fila, infCampo.getPosicion(),
                    infCampo.getNombreCampoArchivo());

            if (fechaMin != null && fecha != null && fecha.before(fechaMin)) {
                UtilProcesador.adicionarError(errores, fila, infCampo.getPosicion(), "El campo " + infCampo.getNombreCampoArchivo() + ",Tiene una fecha menor a la permitida (" + infCampo.getValidaciones().getFechaMinima() + ")", infCampo.getValor());
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * //     * valida el formato de fecha
     * //     *
     * //     * @param formatoFecha
     * //     * @param valor
     * //     * @param errores
     * //     * @param linea
     * //
     */
    private Date validarFormatoFecha(String formatoFecha, String valor, List<ErrorCampo> errores, int fila, int posicion, String campoNombre) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(formatoFecha);

            if (valor.trim().length() != dateFormat.toPattern().length())
                UtilProcesador.adicionarError(errores, fila, posicion, "El valor del campo " + campoNombre + ",No tiene un formato de fecha correcto", valor);
            dateFormat.setLenient(false);
            return dateFormat.parse(valor.trim());
        } catch (ParseException pe) {
            UtilProcesador.adicionarError(errores, fila, posicion, "El valor del campo " + campoNombre + ",No tiene un formato de fecha correcto", valor);
            return null;
        }

    }
}
