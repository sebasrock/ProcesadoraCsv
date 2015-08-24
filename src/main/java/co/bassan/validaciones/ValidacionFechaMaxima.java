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
public class ValidacionFechaMaxima implements Validacion {

    private static ValidacionFechaMaxima intancia;

    public ValidacionFechaMaxima() {
    }


    public static ValidacionFechaMaxima obtenerInstancia() {
        if ((intancia!=null)) {
            return intancia;
        } else {
            return new ValidacionFechaMaxima();
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
        if (infCampo.getValidaciones()!=null && infCampo.getValidaciones().getFechaMaxima() != null && !infCampo.getValidaciones().getFechaMaxima().isEmpty()) {
            Date fechaMax = validarFormatoFecha(infCampo.getValidaciones().getFormatoFecha(),
                    infCampo.getValidaciones().getFechaMaxima(),
                    errores, fila, infCampo.getPosicion(),
                    "Fecha maxima " + infCampo.getNombreCampoArchivo());
            Date fecha = validarFormatoFecha(infCampo.getValidaciones().getFormatoFecha(),
                    infCampo.getValor(), errores, fila, infCampo.getPosicion(),
                    infCampo.getNombreCampoArchivo());

            if (fechaMax != null && fecha != null && fechaMax.before(fecha)) {
                UtilProcesador.adicionarError(errores, fila, infCampo.getPosicion(), "El campo " + infCampo.getNombreCampoArchivo() + ",Tiene una fecha mayor a la permitida (" + infCampo.getValidaciones().getFechaMaxima() + ")", infCampo.getValor());
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
