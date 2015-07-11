package co.bassan.lectora.core;

import co.bassan.lectora.model.ConfiguracionCampo;
import co.bassan.lectora.model.ConfiguracionCarga;
import co.bassan.lectora.model.ErrorCampo;
import co.bassan.lectora.model.ResultadoCargue;

import java.io.*;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.*;

/**
 * Created by Sebastian- on 08/02/2015.
 */
public class ProcesadorCsv<T> {


    private List<ErrorCampo> listaErrores;
    private String lineContinuacion;

    public ResultadoCargue<T> transformarCsvObjeto(Class<T> pojo, String rutaCsv) throws Exception {
        BufferedReader fileReader = null;
        listaErrores = new ArrayList<>();
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

    public ResultadoCargue<T> transformarCsvObjeto(Class<T> pojo, byte[] archivoBinario) throws Exception {
        BufferedReader fileReader = null;
        listaErrores = new ArrayList<>();
        ResultadoCargue<T> resultadoCargue = new ResultadoCargue<T>();
        try {
            InputStream is = new ByteArrayInputStream(archivoBinario);
            fileReader = new BufferedReader(new InputStreamReader(is));

            List<T> pojosRetorno = preparacionLecuraConfiguraciones(fileReader, pojo);

            resultadoCargue.setElementosCargados(pojosRetorno);
            resultadoCargue.setErroresEcontrados(listaErrores);
            return resultadoCargue;
        } finally {
            fileReader.close();
        }

    }

    public BufferedOutputStream transformarObjetoCsv(List<T> tList, String rutaCsv) throws Exception {
        if (tList != null && tList.size() > 0) {
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(new FileOutputStream(rutaCsv));
            ConfiguracionCarga configuracionCarga = obtenerConfiguracion((Class<T>) tList.get(0).getClass(),Boolean.FALSE);
            Collections.sort(configuracionCarga.getConfigCampos(), new Comparator<ConfiguracionCampo>() {
                public int compare(ConfiguracionCampo confCamp1, ConfiguracionCampo confCamp2) {
                    if (confCamp1.getPosicion() > confCamp2.getPosicion())
                        return 1;
                    else if (confCamp1.getPosicion() < confCamp2.getPosicion())
                        return -1;
                    else if (confCamp1.getPosicion() == confCamp2.getPosicion())
                        return 0;
                    return 0;
                }
            });
            UtilProcesador.imprimirCabecera(bufferedOutput, configuracionCarga.getConfigCampos());
            for (T tClass : tList) {
                for (ConfiguracionCampo configuracionCampo : configuracionCarga.getConfigCampos()) {

                    Method method =tClass.getClass().getMethod(configuracionCampo.getGetNombreCampo(),null);
                    bufferedOutput.write((method.invoke(tClass, null) + ",").getBytes());
                }
                bufferedOutput.write("\n".getBytes());
            }
            bufferedOutput.close();
            return bufferedOutput;
        }
        return null;
    }

    private List<T> preparacionLecuraConfiguraciones(BufferedReader fileReader, Class<T> pojo) throws Exception {
        List<T> lista = new ArrayList<T>();
        ConfiguracionCarga config = obtenerConfiguracion(pojo, Boolean.TRUE);
        if (config.isSaltarPrimeraLinea()) {
            fileReader.readLine();

        }
        prepararAlamacenamientoObjeto(fileReader, config, lista, pojo, null, null, 0);
        return lista;
    }

    private String prepararAlamacenamientoObjeto(BufferedReader fileReader, ConfiguracionCarga config, List<T> lista, Class<T> pojo, String palabraIndiceAnterior, String lineAnterior, int fila) throws Exception {
        String line = lineAnterior;
        String palabraIndiceNueva = null;
        String[] campos = new String[0];

        if (line == null && (line = fileReader.readLine()) != null) {
            line = UtilProcesador.prepararLinea(line, config.getSeparador());
            campos = UtilProcesador.separacionLinea(line, config.getSeparador());
            if (config.isEsMultiEstructura() && campos.length > 0) {
                palabraIndiceNueva = campos[0];
                campos = Arrays.copyOfRange(campos, 1, campos.length);
                if (palabraIndiceAnterior != null && !palabraIndiceAnterior.equals(palabraIndiceNueva)) {
                    return line;
                }
            }
        } else {
            if (line != null) {
                line = UtilProcesador.prepararLinea(line, config.getSeparador());
                campos = UtilProcesador.separacionLinea(line, config.getSeparador());
                if (config.isEsMultiEstructura() && campos.length > 0) {
                    palabraIndiceNueva = campos[0];
                    campos = Arrays.copyOfRange(campos, 1, campos.length);
                }

                if(lineAnterior!=null){
                    lineContinuacion=null;
                }
            }
        }
        if (campos != null && campos.length > 0) {

            if (config.getCantidadCampos() != campos.length) {
                listaErrores.add(new ErrorCampo(fila, 0, "El numero de columnas no es igual a lo parametrizado", null));
            } else {
                T pojoRespuesta = almacenamientoObjeto(campos, config.getConfigCampos(), config.getCantidadCampos(), pojo, fileReader, fila);
                lista.add(pojoRespuesta);
            }
            fila++;
            line = prepararAlamacenamientoObjeto(fileReader, config, lista, pojo, palabraIndiceNueva, lineContinuacion, fila);
        }

        return line;
    }


    private T almacenamientoObjeto(String[] campos, List<ConfiguracionCampo> configCampos, int cantidadCampos, Class<T> pojo, BufferedReader fileReader, int fila) throws Exception {
        T objeto = pojo.newInstance();
        List<ConfiguracionCampo> listFielsOneToMany = new ArrayList<ConfiguracionCampo>();

        for (ConfiguracionCampo configCampo : configCampos) {
            if (configCampo.isEsOneToMany()) {
                Method lMethod = obtenerMetodoSet(objeto, configCampo);
                setearValorMetodo(lMethod, UtilProcesador.createListOfType(configCampo.getTipoDatoGenerico()), objeto);
                listFielsOneToMany.add(configCampo);
            } else if (configCampo.isEsOneToOne()) {
                almacenamientoObjetoOneToOne(campos, objeto, configCampo, cantidadCampos, fileReader, fila);
            } else {
                try {
                    almacenamientoObjetoBasico(campos, objeto, configCampo);
                    listaErrores.addAll(EjecutorValidaciones.getIntancia(configCampo, cantidadCampos, fila, campos.length).ejecutor());
                }catch (Exception e){
                    UtilProcesador.adicionarError(listaErrores,fila,e,configCampo);
                }
            }

        }

        String line = procesamientoMultiEstructura(listFielsOneToMany, objeto, fileReader, fila);
        lineContinuacion = line;
        return objeto;
    }

    private String procesamientoMultiEstructura(List<ConfiguracionCampo> mapaFielsOneToMany, T objeto, BufferedReader fileReader, int fila) throws Exception {
        String line = null;
        for (ConfiguracionCampo campo : mapaFielsOneToMany) {
            Method method = obtenerMetodoGet(objeto, campo);
            Object metodoList = method.invoke(objeto, null);
            List<T> lista = new ArrayList<T>();
            T objetoAdd = (T) campo.getTipoDatoGenerico();
            ConfiguracionCarga config = obtenerConfiguracion((Class<T>) objetoAdd, Boolean.TRUE);
            fila++;
            line = prepararAlamacenamientoObjeto(fileReader, config, lista, (Class<T>) objetoAdd, null, line, fila);

            ((List) metodoList).addAll(lista);
        }
        if (line != null) {
            return line;
        } else
            return null;
    }

    private Method obtenerMetodoGet(T objeto, ConfiguracionCampo configuracionCampo) throws NoSuchMethodException {
        return objeto.getClass().getMethod(configuracionCampo.getGetNombreCampo(), null);
    }

    private void almacenamientoObjetoBasico(String[] campos, T objeto, ConfiguracionCampo configCampo) throws Exception {
        Method lMethod = obtenerMetodoSet(objeto, configCampo);
        setearValorMetodo(lMethod, campos, configCampo, objeto);
    }

    private void almacenamientoObjetoOneToOne(String[] campos, T objeto, ConfiguracionCampo configCampo, int cantidadCampos, BufferedReader fileReader, int fila) throws Exception {
        T objetoOne = (T) configCampo.getTipoDato();
        ConfiguracionCarga configuracionCargaOne = obtenerConfiguracion((Class<T>) objetoOne, Boolean.FALSE);
        objetoOne = almacenamientoObjeto(campos, configuracionCargaOne.getConfigCampos(), cantidadCampos, (Class<T>) objetoOne, fileReader, fila);
        Method lMethod = obtenerMetodoSet(objeto, configCampo);
        setearValorMetodo(lMethod, objetoOne, objeto);
    }

    private void setearValorMetodo(Method lMethod, Object valor, T objeto) throws Exception {
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

        valorStr = UtilProcesador.limpiarEspacios(configCampo, valorStr);

        if (!configCampo.getConvercionClass().getSimpleName().equals("ConvertidorInterfaz")) {
            return UtilProcesador.parseStringToConvercionClass(configCampo.getConvercionClass(), valorStr);

        }else if (configCampo.getTipoDato().getSimpleName().toUpperCase().equals("DATE")) {
            return UtilProcesador.parseDateFromString(valorStr, configCampo.getValidaciones().getFormatoFecha() );
        }else
         {
            return UtilProcesador.parsePrimitiveFromString(valorStr, configCampo.getTipoDato());
        }
    }

}
