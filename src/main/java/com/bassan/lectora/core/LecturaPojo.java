
package com.bassan.lectora.core;

import com.bassan.lectora.anotaciones.DatosArchivo;
import com.bassan.lectora.anotaciones.DatosCampo;
import com.bassan.lectora.anotaciones.ValidarCampo;
import com.bassan.lectora.model.ConfiguracionCampo;
import com.bassan.lectora.model.ConfiguracionCarga;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian Sanchez on 06/02/2015.
 */
public class LecturaPojo {

    private Class pojoClass;

    private ConfiguracionCarga configuracion;

    public LecturaPojo(Class pojoClass) {
        this.pojoClass = pojoClass;
    }

    public ConfiguracionCarga obtenerConfiguracion() {
        configuracion = leerAnotacionDatosArchivo();
        configuracion.setConfigCampos(obtenerConfCampo());
        return configuracion;
    }

    private List<ConfiguracionCampo> obtenerConfCampo() {
        List<ConfiguracionCampo> listaConf = new ArrayList<ConfiguracionCampo>();

        Field[] fields = pojoClass.getDeclaredFields();

        if (fields == null) {
            return null;
        }

        for (Field field : fields) {
            ConfiguracionCampo configuracionCampo = new ConfiguracionCampo();
            leerAnotacionDatosCampo(field, configuracionCampo);
            leerAnotacionValidarCampo(field, configuracionCampo);
            listaConf.add(configuracionCampo);
        }
        return listaConf;
    }

    public ConfiguracionCarga leerAnotacionDatosArchivo() {
        ConfiguracionCarga configuracionCarga = new ConfiguracionCarga();
        DatosArchivo datosArchivo = (DatosArchivo) pojoClass.getAnnotation(DatosArchivo.class);

        if (datosArchivo != null) {
            configuracionCarga.setNombreArchivo(datosArchivo.nombre());
            configuracionCarga.setSaltarPrimeraLinea(datosArchivo.saltarPrimeraLinea());
            configuracionCarga.setSeparador(datosArchivo.separador());

        }
        return configuracionCarga;
    }

    public void leerAnotacionDatosCampo(Field field, ConfiguracionCampo configuracionCampo) {
        DatosCampo datos = (DatosCampo) field.getAnnotation(DatosCampo.class);
        if (datos != null) {
            configuracionCampo.setNombreCampo(field.getName());
            configuracionCampo.setTipoDato(field.getType());
            configuracionCampo.setNombreCampoArchivo(datos.nombre());
            configuracionCampo.setPosicion(datos.posicion());
            configuracionCampo.setTrim(datos.trim());
            configuracionCampo.setConvercionClass(datos.convercionClass());
        }
    }

    public void leerAnotacionValidarCampo(Field field, ConfiguracionCampo configuracionCampo) {
        ValidarCampo validarCampo = (ValidarCampo) field.getAnnotation(ValidarCampo.class);

        if (validarCampo != null) {
            configuracionCampo.setExprecion(validarCampo.exprecion());
            configuracionCampo.setLongitudMaxima(validarCampo.longitudMaxima());
            configuracionCampo.setLongitudMinima(validarCampo.longitudMinima());
            configuracionCampo.setRequirido(validarCampo.requirido());
            configuracionCampo.setListaLimitante(validarCampo.listaLimitante());
            configuracionCampo.setFormatoFecha(validarCampo.fromatoFecha());
        }
    }

}
