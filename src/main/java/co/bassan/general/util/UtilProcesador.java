package co.bassan.general.util;


import co.bassan.general.model.ErrorCampo;
import co.bassan.general.model.InfoArchivo;
import co.bassan.general.model.TypesEnum;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UtilProcesador {

    public UtilProcesador() {
    }

    public static String[] separacionLinea(String line, String separador) {
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

    public static Object parseStringToConvercionClass(Class<? extends ConversionPersonal> convercionClass, String valorStr) throws IllegalAccessException, InstantiationException, NoSuchMethodException {
        ConversionPersonal interfaz = convercionClass.newInstance();
        return interfaz.stringToObjeto(valorStr);
    }

    public static Object parsePrimitiveFromString(String valorStr, Class<?> tipoDato) throws Exception {
            return TypesEnum.parseObjectFromString(valorStr, tipoDato);
    }

    public static Object parseDateFromString(String valor, String formatoFecha) throws Exception {

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(formatoFecha);

            if (valor.trim().length() != dateFormat.toPattern().length())
                throw new IllegalArgumentException("No tiene un formato de fecha correcto : " + formatoFecha);

            dateFormat.setLenient(Boolean.FALSE);

            return dateFormat.parse(valor.trim());
        } catch (ParseException pe) {
            throw new IllegalArgumentException("No tiene un formato de fecha correcto o la fecha no existe: (" + formatoFecha + " ) - " + valor);
        }

    }

    public static String prepararLinea(String line, String separador) {
        String lineRetunr;
        if (separador != null && line.indexOf(separador) == 0) {
            line = " " + line;
        }
        line = line + " ";
        lineRetunr = line.replace(separador + separador, separador + " " + separador);
        return lineRetunr;
    }

    public static String limpiarEspacios(String nombreTipoDato, boolean isTrim,String valorStr) {
        if (!nombreTipoDato.equals("String") || isTrim) {
            valorStr = valorStr.trim();
        }
        return valorStr;
    }

    public static void adicionarError(List<ErrorCampo> listaErrores, int fila, Exception e, int posicion , Object valor) {
        ErrorCampo errorCampo = new ErrorCampo(fila, posicion, e.getMessage(), valor);
        listaErrores.add(errorCampo);
    }

    public static void saltarPrimerLinea(InfoArchivo infoArchivo, BufferedReader reader) throws IOException {
        if(infoArchivo.isSaltarPrimeraLinea()){
            reader.readLine();
        }
    }


    public static <T> Method obtenerMetodoSet(T objeto, String setNombreCampo, Class<?> tipoDato) throws NoSuchMethodException {
        Class[] cArg = new Class[1];
        cArg[0] = tipoDato;
        return objeto.getClass().getMethod(setNombreCampo, cArg);
    }

    public static void adicionarError(List<ErrorCampo> listaErrores, int fila, int posicion, String mensaje, Object valor) {
        ErrorCampo errorCampo = new ErrorCampo(fila, posicion, mensaje, valor);
        listaErrores.add(errorCampo);
    }
}