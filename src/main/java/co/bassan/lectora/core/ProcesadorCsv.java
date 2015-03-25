package co.bassan.lectora.core;

import co.bassan.lectora.model.ConfiguracionCampo;
import co.bassan.lectora.model.ConfiguracionCarga;
import co.bassan.lectora.model.ErrorCampo;
import co.bassan.lectora.model.ResultadoCargue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sebastian- on 08/02/2015.
 */
public class ProcesadorCsv<T> {


    private List<ErrorCampo> listaErrores;

    public ResultadoCargue<T> transformarCsvObjeto(Class<T> pojo, String rutaCsv) throws Exception {
        BufferedReader fileReader = null;
        ResultadoCargue<T> resultadoCargue = new ResultadoCargue<T>();
        try {
            fileReader = obtenerArchivo(rutaCsv);

            List<T> pojosRetorno = preparacionLecuraConfiguraciones(fileReader, pojo);

            resultadoCargue.setElementosCargados(pojosRetorno);
            resultadoCargue.setErroresEcontrados(listaErrores);
            return resultadoCargue;
        } finally {
            fileReader.close();
        }

    }

    private List<T> preparacionLecuraConfiguraciones(BufferedReader fileReader, Class<T> pojo) throws Exception {
        List<T> lista = new ArrayList<T>();
        ConfiguracionCarga config = obtenerConfiguracion(pojo, Boolean.TRUE);
        if (config.isSaltarPrimeraLinea())
            fileReader.readLine();
        prepararAlamacenamientoObjeto(fileReader, config, lista, pojo, null);
        return lista;
    }

    private void prepararAlamacenamientoObjeto(BufferedReader fileReader, ConfiguracionCarga config, List<T> lista, Class<T> pojo, String palabraIndiceAnterior) throws Exception {
        String line;
        String palabraIndiceNueva = null;

        if ((line = fileReader.readLine()) != null) {
            line = UtilProcesador.prepararLinea(line, config.getSeparador());
            String[] campos = UtilProcesador.separacionLinea(line, config.getSeparador());
            if (config.isEsMultiEstructura() && campos.length > 0) {
                palabraIndiceNueva = campos[0];
                campos = Arrays.copyOfRange(campos, 1, campos.length);
                if (palabraIndiceAnterior != null && !palabraIndiceAnterior.equals(palabraIndiceNueva)) {
//                        fileReader.reset();
                    return;
                }

            }
            T pojoRespuesta = almacenamientoObjeto(campos, config.getConfigCampos(), pojo, fileReader);
            lista.add(pojoRespuesta);
            prepararAlamacenamientoObjeto(fileReader, config, lista, pojo, palabraIndiceNueva);
        }
    }

    private T almacenamientoObjeto(String[] campos, List<ConfiguracionCampo> configCampos, Class<T> pojo, BufferedReader fileReader) throws Exception {
        T objeto = pojo.newInstance();
        List<ConfiguracionCampo> listFielsOneToMany = new ArrayList<ConfiguracionCampo>();

        for (ConfiguracionCampo configCampo : configCampos) {
            if (configCampo.isEsOneToMany()) {
                Method lMethod = obtenerMetodoSet(objeto, configCampo);
                setearValorMetodo(lMethod, UtilProcesador.createListOfType(configCampo.getTipoDatoGenerico()), configCampo, objeto);
                listFielsOneToMany.add(configCampo);
            } else if (configCampo.isEsOneToOne()) {
                almacenamientoObjetoOneToOne(campos, objeto, configCampo, fileReader);
            } else {
                almacenamientoObjetoBasico(campos, objeto, configCampo);
//                listaErrores.addAll(EjecutorValidaciones.getIntancia(config, i + 1, campos.length).ejecutor());
            }

        }

        procesamientoMultiEstructura(listFielsOneToMany, objeto, fileReader);
        return objeto;
    }

    private void procesamientoMultiEstructura(List<ConfiguracionCampo> mapaFielsOneToMany, T objeto, BufferedReader fileReader) throws Exception {
        for (ConfiguracionCampo campo : mapaFielsOneToMany) {
            Method method = obtenerMetodoGet(objeto, campo);
            Object metodoList = method.invoke(objeto, null);
            List<T> lista = new ArrayList<T>();
            T objetoAdd = (T) campo.getTipoDatoGenerico();
            ConfiguracionCarga config = obtenerConfiguracion((Class<T>) objetoAdd, Boolean.TRUE);
            prepararAlamacenamientoObjeto(fileReader, config, lista, (Class<T>) objetoAdd, null);

            ((List) metodoList).add(lista);
        }
    }

    private Method obtenerMetodoGet(T objeto, ConfiguracionCampo configuracionCampo) throws NoSuchMethodException {
        return objeto.getClass().getMethod(configuracionCampo.getGetNombreCampo(), null);
    }

    private void almacenamientoObjetoBasico(String[] campos, T objeto, ConfiguracionCampo configCampo) throws Exception {
        Method lMethod = obtenerMetodoSet(objeto, configCampo);
        setearValorMetodo(lMethod, campos, configCampo, objeto);
    }

    private void almacenamientoObjetoOneToOne(String[] campos, T objeto, ConfiguracionCampo configCampo, BufferedReader fileReader) throws Exception {
        T objetoOne = (T) configCampo.getTipoDato();
        ConfiguracionCarga configuracionCargaOne = obtenerConfiguracion((Class<T>) objetoOne, Boolean.FALSE);
        objetoOne = almacenamientoObjeto(campos, configuracionCargaOne.getConfigCampos(), (Class<T>) objetoOne, fileReader);
        Method lMethod = obtenerMetodoSet(objeto, configCampo);
        setearValorMetodo(lMethod, objetoOne, configCampo, objeto);
    }

    private void setearValorMetodo(Method lMethod, Object valor, ConfiguracionCampo configCampo, T objeto) throws Exception {
        lMethod.invoke(objeto, valor);
    }

    private void setearValorMetodo(Method lMethod, String[] campos, ConfiguracionCampo configCampo, T objeto) throws Exception {
        Object valor = recuperarValor(configCampo, campos);
        configCampo.setValor(campos[configCampo.getPosicion()]);
        lMethod.invoke(objeto, valor);
    }

    private Method obtenerMetodoSet(T objeto, ConfiguracionCampo configCampo) throws NoSuchMethodException {
        Class[] cArg = new Class[1];
        cArg[0] = configCampo.getTipoDato();
        return objeto.getClass().getMethod(configCampo.getSetNombreCampo(), cArg);
    }

    private BufferedReader obtenerArchivo(String rutaCsv) throws FileNotFoundException {
        return new BufferedReader(new FileReader(rutaCsv));
    }

    private ConfiguracionCarga obtenerConfiguracion(Class<T> pojo, Boolean oblirgatoriedad) {
        LecturaPojo lecturaPojo = new LecturaPojo(pojo);
        return lecturaPojo.obtenerConfiguracion(oblirgatoriedad);
    }

    private Object recuperarValor(ConfiguracionCampo configCampo, String[] campos) throws Exception {

        String valorStr = campos[configCampo.getPosicion()];

        valorStr = limpiarEspacios(configCampo, valorStr);

        if (!configCampo.getConvercionClass().getSimpleName().equals("ConvertidorInterfaz")) {
            return UtilProcesador.parseStringToConvercionClass(configCampo.getConvercionClass(), valorStr);
        } else {
            return UtilProcesador.parsePrimitiveFromString(valorStr, configCampo.getTipoDato());
        }
    }

    private String limpiarEspacios(ConfiguracionCampo configCampo, String valorStr) {
        if (!configCampo.getTipoDato().getSimpleName().equals("String") || configCampo.isTrim()) {
            valorStr = valorStr.trim();
        }
        return valorStr;
    }

}
