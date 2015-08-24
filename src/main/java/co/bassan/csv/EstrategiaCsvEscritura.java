package co.bassan.csv;

import co.bassan.general.EstrategiaConversorObjetos;
import co.bassan.general.model.InfCampo;
import co.bassan.general.model.InfoArchivo;
import co.bassan.general.util.UtilProcesador;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sebas on 19/08/15.
 */
public class EstrategiaCsvEscritura extends EstrategiaConversorObjetos
{

    @Override
    public ByteArrayOutputStream ejecutar(List listaObjetosBase) throws Exception {
        if (listaObjetosBase != null && listaObjetosBase.size() > 0)
        {

            try (ByteArrayOutputStream out = new ByteArrayOutputStream();
                 PrintWriter pw = new PrintWriter(out)) {
                InfoArchivo infoArchivo = getInfoArchivo((Class) listaObjetosBase.get(0).getClass());
                ordenarCampos(infoArchivo);
                if(!infoArchivo.isSaltarPrimeraLinea()) {
                    UtilProcesador.imprimirCabecera(pw, infoArchivo.getInfCampos(), infoArchivo.getSeparador());
                }

                for (Object tClass : listaObjetosBase) {
                    StringBuilder linea = new StringBuilder();
                    for (InfCampo infCampo : infoArchivo.getInfCampos()) {
                          escribirContenido(linea ,tClass, infCampo,infoArchivo.getSeparador());
                    }
                    linea.replace(linea.length() - 1, linea.length(), "");
                    pw.print(linea+"\n");
                }
                pw.flush();
                return out;
            }

        }
        return null;
    }

    private void ordenarCampos(InfoArchivo infoArchivo) {
        Collections.sort(infoArchivo.getInfCampos(), new Comparator<InfCampo>() {
            public int compare(InfCampo confCamp1, InfCampo confCamp2) {
                if (confCamp1.getPosicion() > confCamp2.getPosicion())
                    return 1;
                else if (confCamp1.getPosicion() < confCamp2.getPosicion())
                    return -1;
                else if (confCamp1.getPosicion() == confCamp2.getPosicion())
                    return 0;
                return 0;
            }
        });
    }

    private void escribirContenido(StringBuilder linea, Object tClass, InfCampo infCampo, String separador) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        try {
            if (infCampo.getGetNombreCampo() != null && !infCampo.getGetNombreCampo().isEmpty()) {
                Method method = tClass.getClass().getMethod(infCampo.getGetNombreCampo(), null);
                Object valor = method.invoke(tClass, null);
                if(infCampo.getTipoDato().getSimpleName().toUpperCase().equals("DATE")){
                    SimpleDateFormat formato = new SimpleDateFormat(infCampo.getValidaciones().getFormatoFecha());
                    linea.append(formato.format(valor) + separador);
                }else {
                    linea.append(valor + separador);
                }
            }
        } catch (NoSuchMethodException e) {
            linea.append("");
        }
    }
}
