
package co.bassan.lectora.core;

import co.bassan.lectora.anotaciones.*;
import co.bassan.lectora.model.ConfiguracionCampo;
import co.bassan.lectora.model.ConfiguracionCarga;
import co.bassan.lectora.model.ConfiguracionValidaciones;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
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

    public ConfiguracionCarga obtenerConfiguracion(boolean obligatoridad) {
        configuracion = leerAnotacionDatosArchivo(obligatoridad);
        configuracion.setConfigCampos(obtenerConfCampo());
        return configuracion;
    }


    private List<ConfiguracionCampo> obtenerConfCampo() {

        List<Field> fields = getPrivateFields(pojoClass);


        List<ConfiguracionCampo> listaConf = new ArrayList<ConfiguracionCampo>(fields.size());

        if (fields == null) {
            return null;
        }

        for (Field field : fields) {
            ConfiguracionCampo configuracionCampo = new ConfiguracionCampo();
            leerAnotacionDatosCampo(field, configuracionCampo);
            leerAnotacionValidarCampo(field, configuracionCampo);
            leerAnotacionOneToOne(field, configuracionCampo);
            leerAnotacionOneToMany(field, configuracionCampo);
            listaConf.add(configuracionCampo);
        }
        return listaConf;
    }

    private void leerAnotacionOneToOne(Field field, ConfiguracionCampo configuracionCampo) {
        OneToOne datos = field.getAnnotation(OneToOne.class);
        if (datos != null) {
            configuracionCampo.setEsOneToOne(Boolean.TRUE);
            configuracionCampo.setEsOneToMany(Boolean.FALSE);
            configuracionCampo.setNombreCampo(field.getName());
            configuracionCampo.setTipoDato(field.getType());
        }
    }

    private void leerAnotacionOneToMany(Field field, ConfiguracionCampo configuracionCampo) {
        OneToMany datos = field.getAnnotation(OneToMany.class);
        if (datos != null) {
            configuracionCampo.setEsOneToOne(Boolean.FALSE);
            configuracionCampo.setEsOneToMany(Boolean.TRUE);
            configuracionCampo.setPalabraReservada(datos.palabraResevada());
            configuracionCampo.setNombreCampo(field.getName());
            ParameterizedType stringListType = (ParameterizedType) field.getGenericType();
            configuracionCampo.setTipoDato(field.getType());
            configuracionCampo.setTipoDatoGenerico((Class<?>) stringListType.getActualTypeArguments()[0]);

        }
    }

    public ConfiguracionCarga leerAnotacionDatosArchivo(boolean obligatoridad) {
        ConfiguracionCarga configuracionCarga = new ConfiguracionCarga();
        DatosArchivo datosArchivo = (DatosArchivo) pojoClass.getAnnotation(DatosArchivo.class);


        if (datosArchivo == null && obligatoridad) {
            throw new IllegalArgumentException("No tiene la anotacion del DatosArchivo");
        }
        if (datosArchivo != null) {
            configuracionCarga.setNombreArchivo(datosArchivo.nombre());
            configuracionCarga.setSaltarPrimeraLinea(datosArchivo.saltarPrimeraLinea());
            configuracionCarga.setSeparador(datosArchivo.separador());
            configuracionCarga.setEsMultiEstructura(datosArchivo.multiEstructura());
            configuracionCarga.setCantidadCampos(datosArchivo.cantidadRegistros());
        }
        return configuracionCarga;
    }

    public void leerAnotacionDatosCampo(Field field, ConfiguracionCampo configuracionCampo) {
        DatosCampo datos = field.getAnnotation(DatosCampo.class);
        configuracionCampo.setNombreCampo(field.getName());
        configuracionCampo.setTipoDato(field.getType());
        if (datos != null) {
            configuracionCampo.setNombreCampoArchivo((datos.nombre() != null) ? datos.nombre() : "");
            configuracionCampo.setPosicion(datos.posicion());
            configuracionCampo.setTrim(datos.trim());
            configuracionCampo.setConvercionClass(datos.convercionClass());
        }
    }

    public void leerAnotacionValidarCampo(Field field, ConfiguracionCampo configuracionCampo) {
        ValidarCampo validarCampo = field.getAnnotation(ValidarCampo.class);

        if (validarCampo != null) {
            configuracionCampo.setValidaciones(new ConfiguracionValidaciones());
            configuracionCampo.getValidaciones().setExprecion(validarCampo.exprecion());
            configuracionCampo.getValidaciones().setLongitudMaxima(validarCampo.longitudMaxima());
            configuracionCampo.getValidaciones().setLongitudMinima(validarCampo.longitudMinima());
            configuracionCampo.getValidaciones().setRequirido(validarCampo.requirido());
            configuracionCampo.getValidaciones().setListaLimitante(validarCampo.listaLimitante());
            configuracionCampo.getValidaciones().setFormatoFecha(validarCampo.formatoFecha());
            configuracionCampo.getValidaciones().setFechaMinima(validarCampo.fechaMinima());
            configuracionCampo.getValidaciones().setFechaMaxima(validarCampo.fechaMaxima());
        }
    }

    public static List<Field> getPrivateFields(Class<?> theClass){
        List<Field> privateFields = new ArrayList<Field>();

        Field[] fields = theClass.getDeclaredFields();

        for(Field field:fields){
            if(Modifier.isPrivate(field.getModifiers())){
                privateFields.add(field);
            }
        }
        return privateFields;
    }

}
