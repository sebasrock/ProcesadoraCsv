package co.bassan.general.util;

import co.bassan.anotaciones.*;
import co.bassan.general.model.InfCampo;
import co.bassan.general.model.InfValidaciones;
import co.bassan.general.model.InfoArchivo;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sebas on 13/08/15.
 */
public class LeerAnotacionesArchivo {


    private Class claseBase;

    private InfoArchivo configuracion;

    public LeerAnotacionesArchivo(Class claseBase) {
        this.claseBase = claseBase;
    }

    public InfoArchivo obtenerInfoArchivo() {
        configuracion = leerAnotacionDatosArchivo();
        configuracion.setInfCampos(obtenerConfCampo());
        return configuracion;
    }

    public <T> InfoArchivo obtenerInfoArchivoSinAnotacionDatosArchivo(Class<T> objetoOne) {
        this.claseBase = objetoOne;
        configuracion = new InfoArchivo();
        configuracion.setInfCampos(obtenerConfCampo());
        return configuracion;
    }


    private List<InfCampo> obtenerConfCampo() {

        List<Field> fields = getPrivateFields(claseBase);


        List<InfCampo> listaConf = new ArrayList<InfCampo>(fields.size());

        if (fields == null) {
            return null;
        }

        for (Field field : fields) {
            InfCampo InfCampo = new InfCampo();
            leerAnotacionDatosCampo(field, InfCampo);
            leerAnotacionValidarCampo(field, InfCampo);
            leerAnotacionOneToOne(field, InfCampo);
            leerAnotacionOneToMany(field, InfCampo);
            listaConf.add(InfCampo);
        }
        return listaConf;
    }

    private void leerAnotacionOneToOne(Field field, InfCampo infCampo) {
        OneToOne datos = field.getAnnotation(OneToOne.class);
        if (datos != null) {
            infCampo.setEsOneToOne(Boolean.TRUE);
            infCampo.setEsOneToMany(Boolean.FALSE);
            infCampo.setNombreCampo(field.getName());
            infCampo.setTipoDato(field.getType());
        }
    }

    private void leerAnotacionOneToMany(Field field, InfCampo infCampo) {
        OneToMany datos = field.getAnnotation(OneToMany.class);
        if (datos != null) {
            infCampo.setEsOneToOne(Boolean.FALSE);
            infCampo.setEsOneToMany(Boolean.TRUE);
            infCampo.setPalabraReservada(datos.palabraResevada());
            infCampo.setNombreCampo(field.getName());
            ParameterizedType stringListType = (ParameterizedType) field.getGenericType();
            infCampo.setTipoDato(field.getType());
            infCampo.setTipoDatoGenerico((Class<?>) stringListType.getActualTypeArguments()[0]);

        }
    }

    public InfoArchivo leerAnotacionDatosArchivo() {
        InfoArchivo infoArchivo = new InfoArchivo();
        DatosArchivo datosArchivo = (DatosArchivo) claseBase.getAnnotation(DatosArchivo.class);


        if (datosArchivo == null) {
            throw new IllegalArgumentException("No tiene la anotacion del DatosArchivo");
        }
        if (datosArchivo != null) {
            infoArchivo.setNombreArchivo(datosArchivo.nombre());
            infoArchivo.setSaltarPrimeraLinea(datosArchivo.saltarPrimeraLinea());
            infoArchivo.setSeparador(datosArchivo.separador());
            infoArchivo.setEsMultiEstructura(datosArchivo.multiEstructura());
            infoArchivo.setCantidadCampos(datosArchivo.cantidadColumnas());
            infoArchivo.setClaseBase(claseBase);
        }
        return infoArchivo;
    }

    public void leerAnotacionDatosCampo(Field field, InfCampo infCampo) {
        DatosCampo datos = field.getAnnotation(DatosCampo.class);
        infCampo.setNombreCampo(field.getName());
        infCampo.setTipoDato(field.getType());
        if (datos != null) {
            infCampo.setNombreCampoArchivo((datos.nombre() != null) ? datos.nombre() : "");
            infCampo.setPosicion(datos.posicion());
            infCampo.setTrim(datos.trim());
            infCampo.setConversionPersonal(datos.convercionClass());
        }
    }

    public void leerAnotacionValidarCampo(Field field, InfCampo infCampo) {
        ValidarCampo validarCampo = field.getAnnotation(ValidarCampo.class);

        if (validarCampo != null) {
            infCampo.setValidaciones(new InfValidaciones());
            infCampo.getValidaciones().setExprecion(validarCampo.exprecion());
            infCampo.getValidaciones().setLongitudMaxima(validarCampo.longitudMaxima());
            infCampo.getValidaciones().setLongitudMinima(validarCampo.longitudMinima());
            infCampo.getValidaciones().setRequirido(validarCampo.requirido());
            infCampo.getValidaciones().setListaLimitante(validarCampo.listaLimitante());
            infCampo.getValidaciones().setFormatoFecha(validarCampo.formatoFecha());
            infCampo.getValidaciones().setFechaMinima(validarCampo.fechaMinima());
            infCampo.getValidaciones().setFechaMaxima(validarCampo.fechaMaxima());
        }
    }

    public static List<Field> getPrivateFields(Class<?> theClass) {
        List<Field> privateFields = new ArrayList<Field>();

        Field[] fields = theClass.getDeclaredFields();

        for (Field field : fields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                privateFields.add(field);
            }
        }
        return privateFields;
    }


}
