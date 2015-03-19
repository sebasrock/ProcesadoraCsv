package com.bassan.lectora.core;

import com.bassan.lectora.interfaces.ConvertidorInterfaz;
import com.bassan.lectora.model.*;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Sebastian- on 08/02/2015.
 */
public class ProcesadorCsv<T> {

    private List<ErrorCampo> listaErrores;

    public ResultadoCargue<T> transformarCsvObjeto(Class<T> pojo, String rutaCsv) throws Exception {
        BufferedReader fileReader = null;
        listaErrores = new ArrayList<ErrorCampo>();
        ResultadoCargue<T> resultadoCargue = new ResultadoCargue<T>();
        try {
            fileReader = obtenerArchivo(rutaCsv);
            ConfiguracionCarga configuracionCarga = obtenerConfiguracion(pojo);
            List<T> pojosRetorno = llenarObjeto(fileReader, pojo, configuracionCarga);

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
            ConfiguracionCarga configuracionCarga = obtenerConfiguracion((Class<T>) tList.get(0).getClass());
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
            imprimirCabecera(bufferedOutput, configuracionCarga.getConfigCampos());
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

    private void imprimirCabecera(BufferedOutputStream bufferedOutput, List<ConfiguracionCampo> configuracionCarga) throws IOException {
        StringBuilder cabecera = new StringBuilder();

        for (ConfiguracionCampo configuracionCampo :configuracionCarga) {
            cabecera.append(configuracionCampo.getNombreCampo());
            cabecera.append(",");
        }

        cabecera.replace(cabecera.length() - 1, cabecera.length(), "\n");
        bufferedOutput.write(cabecera.toString().getBytes());
    }

    private List<T> llenarObjeto(BufferedReader fileReader, Class<T> pojo, ConfiguracionCarga config) throws Exception {
        List<T> lista = new ArrayList<T>();
        String line = "";
        int i = 0;
        while ((line = fileReader.readLine()) != null) {
            line = prepararLinea(line, config.getSeparador());
            String[] campos = separacionLinea(line, config.getSeparador());
            T pojoRespuesta = llenarObjeto(pojo, campos, config.getConfigCampos(), i + 1);
            listaErrores.addAll(EjecutorValidaciones.getIntancia(config, i + 1, campos.length).ejecutor());
            i++;
            lista.add(pojoRespuesta);
        }
        return lista;

    }

    private String[] separacionLinea(String line, String separador) {
        if (separador != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(line, separador);
            String[] campos = new String[stringTokenizer.countTokens()];
            int i = 0;
            while (stringTokenizer.hasMoreElements()) {
                campos[i] = stringTokenizer.nextElement().toString();
                i++;
            }
            return campos;
        }
        return new String[0];

    }

    private T llenarObjeto(Class<T> pojo, String[] campos, List<ConfiguracionCampo> configCampos, int fila) throws Exception {
        T objeto = pojo.newInstance();
        int i = 0;
        for (ConfiguracionCampo configCampo : configCampos) {
            try {
                Class[] cArg = new Class[1];
                cArg[0] = configCampo.getTipoDato();
                Method lMethod = objeto.getClass().getMethod(configCampo.getSetNombreCampo(), cArg);
                Object valor = recuperarValor(configCampo, campos);
                configCampo.setValor(campos[configCampo.getPosicion()]);
                lMethod.invoke(objeto, valor);
            } catch (IndexOutOfBoundsException e) {
                agregarError("La posicion no existe " + configCampo.getPosicion() + ", del campos :" + configCampo.getNombreCampo(), "" + configCampo.getPosicion(), listaErrores, fila, i);
            } catch (Exception e) {
                agregarError("El valor " + campos[configCampo.getPosicion()] + " imposible de convertir a :" + configCampo.getTipoDato().getName(), campos[configCampo.getPosicion()], listaErrores, fila, i);
            } finally {
                i++;
            }
        }
        return objeto;
    }

    private Object recuperarValor(ConfiguracionCampo configCampo, String[] campos) throws Exception {
        String valorStr = "";

        valorStr = campos[configCampo.getPosicion()];
        if (!configCampo.getTipoDato().getSimpleName().equals("String") || configCampo.isTrim()) {
            valorStr = valorStr.trim();
        }
        if (!configCampo.getConvercionClass().getSimpleName().equals("ConvertidorInterfaz")) {
            parseStringToConvercionClass(configCampo.getConvercionClass(), valorStr);
        } else {
            Object retorno = null;
            if (!configCampo.getTipoDato().isPrimitive()) {
                retorno = parseObjectFromString(valorStr, configCampo.getTipoDato());
            } else {
                return parsePrimitiveFromString(valorStr, configCampo.getTipoDato());
            }

            return retorno;
        }


        return null;
    }

    private Object parseStringToConvercionClass(Class<? extends ConvertidorInterfaz> convercionClass, String valorStr) throws IllegalAccessException, InstantiationException, NoSuchMethodException {
        ConvertidorInterfaz interfaz = convercionClass.newInstance();
        return interfaz.stringToObjeto(valorStr);
    }

    private Object parsePrimitiveFromString(String valorStr, Class<?> tipoDato) throws Exception {
        return Types.parseObjectFromString(valorStr, tipoDato);
    }

    public static <T> T parseObjectFromString(String s, Class<T> clazz) throws Exception {
        if (s != null && clazz != null && !clazz.isPrimitive()) {
            return (T) clazz.getConstructor(new Class[]{String.class}).newInstance(s);
        } else {
            return null;
        }
    }


    private String prepararLinea(String line, String separador) {
        String lineRetunr;
        if (separador != null && line.indexOf(separador) == 0) {
            line = " " + line;
        }
        lineRetunr = line.replace(separador + separador, separador + " " + separador);
        return lineRetunr;
    }

    private ConfiguracionCarga obtenerConfiguracion(Class<T> pojo) {

        LecturaPojo lecturaPojo = new LecturaPojo(pojo);
        return lecturaPojo.obtenerConfiguracion();
    }

    private BufferedReader obtenerArchivo(String rutaCsv) throws FileNotFoundException {
        BufferedReader fileReader = null;
        fileReader = new BufferedReader(new FileReader(rutaCsv));
        return fileReader;

    }

    private void agregarError(String causa, String valor, List<ErrorCampo> errores, int fila, int linea) {
        agregarError(new ErrorCampo(causa, valor, fila, linea), errores);
    }

    private void agregarError(ErrorCampo errorCampo, List<ErrorCampo> errores) {
        errores.add(errorCampo);
    }

}
