package co.bassan.lectora.core;

import co.bassan.lectora.excepciones.CargueCsvExcepcion;
import co.bassan.lectora.model.ConfiguracionCampo;
import co.bassan.lectora.model.ConfiguracionCarga;
import co.bassan.lectora.model.ErrorCampo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sebastian- on 15/02/2015.
 */
public class EjecutorValidaciones {

    private ConfiguracionCarga config;
    private int fila;
    private int cantidadCarga;

    private static EjecutorValidaciones intancia;


    public List<ErrorCampo> ejecutor() {
        List<ErrorCampo> errores = new ArrayList<ErrorCampo>();
        try {
            validacionesGenerales();
            int i = 0;
            for (ConfiguracionCampo configCampo : config.getConfigCampos()) {

                if (config != null) {
                    if (configCampo.isRequirido())
                        validarSiEsRequerido(configCampo.getValor(), i);
                    if (configCampo.getLongitudMinima() != 0)
                        validarLongitudMinima(configCampo.getLongitudMinima(), configCampo.getValor(), errores, i);
                    if (configCampo.getLongitudMaxima() != 0)
                        validarLongitudMaxima(configCampo.getLongitudMaxima(), configCampo.getValor(), errores, i);
                    if (configCampo.getExprecion() != null)
                        validarPatron(configCampo.getExprecion(), configCampo.getValor(), errores, i);
                    if (configCampo.getListaLimitante() != null && configCampo.getListaLimitante().length>0)
                        validarListaLimite(configCampo.getListaLimitante(), configCampo.getValor(), errores, i);
                    if (configCampo.getFormatoFecha()!= null && !"".equals(configCampo.getFormatoFecha()))
                        validarFormatoFecha(configCampo.getFormatoFecha(), configCampo.getValor(), errores, i);
                }
                i++;
            }
        } catch (CargueCsvExcepcion e) {
            agregarError(e.getError(), errores);
        }
        return errores;
    }

    private void validarFormatoFecha(String formatoFecha, String valor, List<ErrorCampo> errores, int fila) {

        SimpleDateFormat dateFormat = new SimpleDateFormat(formatoFecha);

        if (valor.trim().length() != dateFormat.toPattern().length())
            agregarError("No tiene un formato de fecha correcto : "+formatoFecha, valor, errores, fila);

        dateFormat.setLenient(false);

        try {
            dateFormat.parse(valor.trim());
        }
        catch (ParseException pe) {
            agregarError("No tiene un formato de fecha correcto : "+formatoFecha, valor, errores, fila);
        }

    }

    private void validarListaLimite(String[] listaLimitante, String valor, List<ErrorCampo> errores, int fila) {
        if (!Arrays.asList(listaLimitante).contains(valor))
            agregarError("No esta entre los valores posibles", valor, errores, fila);
    }

    private void validacionesGenerales() throws CargueCsvExcepcion {
        if (config.getCantidadCampos() != cantidadCarga) {
            throw new CargueCsvExcepcion("Numero de columanas diferentes", null, fila);
        }
    }

    private void validarPatron(String exprecion, String valor, List<ErrorCampo> errores, int fila) {
        if (valor.matches(exprecion)) {
            agregarError("No tiene el formato adecuado", valor, errores, fila);
        }
    }

    private void validarLongitudMaxima(int longitudMaxima, String valor, List<ErrorCampo> errores, int fila) {
        if (valor.length() > longitudMaxima) {
            agregarError("No tiene la longitud maxima", valor, errores, fila);
        }
    }

    private void validarLongitudMinima(int longitudMinima, String valor, List<ErrorCampo> errores, int fila) {
        if (valor.length() < longitudMinima) {
            agregarError("No tiene la longitud minima", valor, errores, fila);
        }
    }

    public void validarSiEsRequerido(String valor, int fila) throws CargueCsvExcepcion {
        if (valor == null || "".equals(valor.trim())) {
            throw new CargueCsvExcepcion("el valor es requerido: " + valor, valor, fila);
        }
    }

    private void agregarError(String causa, String valor, List<ErrorCampo> errores, int fila) {
        agregarError(new ErrorCampo(causa, valor, fila), errores);
    }

    private void agregarError(ErrorCampo error, List<ErrorCampo> errores) {
        error.setFila(fila);
        errores.add(error);
    }

    public EjecutorValidaciones(ConfiguracionCarga config, int fila, int cantidadCarga) {
        this.config = config;
        this.fila = fila;
        this.cantidadCarga = cantidadCarga;
    }

    public static EjecutorValidaciones getIntancia(ConfiguracionCarga configCampo, int fila, int cantidadCargada) {

        if (intancia == null) {
            return new EjecutorValidaciones(configCampo, fila, cantidadCargada);
        } else {
            intancia.modificarDatos(configCampo, fila, cantidadCargada);
            return intancia;
        }
    }

    private void modificarDatos(ConfiguracionCarga config, int fila, int cantidadCarga) {
        this.config = config;
        this.fila = fila;
        this.cantidadCarga = cantidadCarga;
    }
}
