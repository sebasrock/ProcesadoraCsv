package co.bassan.lectora.core;

import co.bassan.lectora.interfaces.ConvertidorInterfaz;
import co.bassan.lectora.model.ConfiguracionCampo;
import co.bassan.lectora.model.ErrorCampo;
import co.bassan.lectora.model.TypesEnum;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UtilProcesador {
    public UtilProcesador() {
    }

    public void imprimirCabecera(BufferedOutputStream bufferedOutput, List<ConfiguracionCampo> configuracionCarga) throws IOException {
        StringBuilder cabecera = new StringBuilder();

        for (ConfiguracionCampo configuracionCampo : configuracionCarga) {
            cabecera.append(configuracionCampo.getNombreCampo());
            cabecera.append(",");
        }

        cabecera.replace(cabecera.length() - 1, cabecera.length(), "\n");
        bufferedOutput.write(cabecera.toString().getBytes());
    }

    static String[] separacionLinea(String line, String separador) {
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

    static Object parseStringToConvercionClass(Class<? extends ConvertidorInterfaz> convercionClass, String valorStr) throws IllegalAccessException, InstantiationException, NoSuchMethodException {
        ConvertidorInterfaz interfaz = convercionClass.newInstance();
        return interfaz.stringToObjeto(valorStr);
    }

    static Object parsePrimitiveFromString(String valorStr, Class<?> tipoDato) throws Exception {
        return TypesEnum.parseObjectFromString(valorStr, tipoDato);
    }

    public static <T> T parseObjectFromString(String s, Class<T> clazz) throws Exception {
        if (s != null && clazz != null && !clazz.isPrimitive()) {
            return (T) clazz.getConstructor(new Class[]{String.class}).newInstance(s);
        } else {
            return null;
        }
    }

    static String prepararLinea(String line, String separador) {
        String lineRetunr;
        if (separador != null && line.indexOf(separador) == 0) {
            line = " " + line;
        }
        lineRetunr = line.replace(separador + separador, separador + " " + separador);
        return lineRetunr;
    }

    void agregarError(String causa, String valor, List<ErrorCampo> errores, int fila, int linea) {
        agregarError(new ErrorCampo(causa, valor, fila, linea), errores);
    }

    void agregarError(ErrorCampo errorCampo, List<ErrorCampo> errores) {
        errores.add(errorCampo);
    }


    public static <T> List<T> createListOfType(Class<T> type) {
        return new ArrayList<T>();
    }
}