package co.bassan.lectora.core;

import co.bassan.lectora.interfaces.ConvertidorInterfaz;
import co.bassan.lectora.model.ConfiguracionCampo;
import co.bassan.lectora.model.ErrorCampo;
import co.bassan.lectora.model.TypesEnum;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    static Object parsePrimitiveFromString(String valorStr, Class<?> tipoDato, String formatoFecha) throws Exception {
        if(tipoDato.getSimpleName().toUpperCase().equals("DATE")){
            return UtilProcesador.parseDateFromString(valorStr, formatoFecha );
        }
        return TypesEnum.parseObjectFromString(valorStr, tipoDato);
    }

    private static Object parseDateFromString(String s, String formatoFecha) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat(formatoFecha);
        formatter.applyPattern(formatoFecha);
        formatter.setLenient(Boolean.FALSE);
        Date fecha = formatter.parse(s);
        if(fecha==null && (s!=null & !s.isEmpty()))
            throw new Exception("La fecha no es valida, no existe");
        return fecha;
    }

    static String prepararLinea(String line, String separador) {
        String lineRetunr;
        if (separador != null && line.indexOf(separador) == 0) {
            line = " " + line;
        }
        line=line+" ";
        lineRetunr = line.replace(separador + separador, separador + " " + separador);
        return lineRetunr;
    }

    public static String limpiarEspacios(ConfiguracionCampo configCampo, String valorStr) {
        if (!configCampo.getTipoDato().getSimpleName().equals("String") || configCampo.isTrim()) {
            valorStr = valorStr.trim();
        }
        return valorStr;
    }


    public static <T> List<T> createListOfType(Class<T> type) {
        return new ArrayList<T>();
    }

    public static void adicionarError(List<ErrorCampo> listaErrores, int fila, Exception e, ConfiguracionCampo configCampo) {
        ErrorCampo errorCampo = new ErrorCampo(fila,configCampo.getPosicion(),e.getMessage(),configCampo.getValor());
        listaErrores.add(errorCampo);
    }
}