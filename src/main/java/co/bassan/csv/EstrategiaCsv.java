package co.bassan.csv;

import co.bassan.excepciones.CargueCsvExcepcion;
import co.bassan.general.EstrategiaConversor;
import co.bassan.general.util.LeerAnotacionesArchivo;
import co.bassan.general.util.UtilProcesador;
import co.bassan.general.model.ErrorCampo;
import co.bassan.general.model.InfCampo;
import co.bassan.general.model.InfoArchivo;
import co.bassan.general.model.ResultadoCargue;
import co.bassan.validaciones.core.EjecutorValidaciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sebas on 13/08/15.
 */
public class EstrategiaCsv<T> extends EstrategiaConversor {


    private CSVRowIterator rowIterator;

    private ResultadoCargue resultado ;

    public EstrategiaCsv() {
        this.resultado = new ResultadoCargue();
    }

    @Override
    public ResultadoCargue ejecutar(Class claseBase, byte[] archivo) throws Exception {


        // Leer anotaciones de la clase
        InfoArchivo infoArchivo = getInfoArchivo(claseBase);

        //Conversion del archivo a BufferedReader
        BufferedReader reader = getBufferedReader(archivo);

        resultado.setElementosCargados(procesarArchivoCsv(infoArchivo, reader, claseBase));


        close(reader);
        return resultado;
    }

    private List<T> procesarArchivoCsv(InfoArchivo infoArchivo, BufferedReader reader, Class claseBase) throws IOException {

        List<T> listaResultado = new ArrayList<>();
        UtilProcesador.saltarPrimerLinea(infoArchivo, reader);

        rowIterator = new CSVRowIterator(reader, infoArchivo.getSeparador(), infoArchivo.isEsMultiEstructura());
        T ultimoObjetoPadre = null;
        String indicadorPadre = null;
        while (rowIterator.hasNext()) {

            String columns[] = rowIterator.next();
            if (!rowIterator.hasNextEstructura()) {
//                System.out.println("ESTRUCTURA IGUAL");
                procesamientoEstructura(infoArchivo, claseBase, listaResultado, columns);
                ultimoObjetoPadre = listaResultado.get(listaResultado.size() - 1);
                indicadorPadre = columns[0];
            } else {
//                System.out.println("CAMBIO ESTRUCTURA");
                List<String> herenciaIndices = new ArrayList<>();
                herenciaIndices.add(indicadorPadre);
                procesamientoMultiEstructura(rowIterator, infoArchivo, ultimoObjetoPadre, columns, herenciaIndices);
            }
        }
        return listaResultado;
    }

    private void procesamientoMultiEstructura(CSVRowIterator rowIterator, InfoArchivo infoArchivo, T objetoPadre, String[] columns, List<String> herenciaIndicador) {
        List<T> listaResultadoHijos = new ArrayList<>();
        InfCampo campoOneToMany = getInfoArchivoOneToMany(infoArchivo.getInfCampos(), columns[0]);
        if (campoOneToMany != null) {
            InfoArchivo infoArchivoMany = getInfoArchivo(campoOneToMany.getTipoDatoGenerico());
            if (infoArchivoMany != null) {
                llenarObjetoPadre(infoArchivoMany, objetoPadre, columns, listaResultadoHijos, campoOneToMany, infoArchivoMany);
                T ultimoObjetoPadre = listaResultadoHijos.get(listaResultadoHijos.size() - 1);
                String indicadorHijo = columns[0];
                while (rowIterator.hasNext()) {
                    String columnsHijo[] = rowIterator.next();
                    if (!herenciaIndicador.contains(columnsHijo[0])) {
                        if (!rowIterator.hasNextEstructura()) {
//                        System.out.println("ESTRUCTURA IGUAL HIJO");

                            procesamientoEstructura(infoArchivoMany, infoArchivoMany.getClaseBase(), listaResultadoHijos, columnsHijo);
                            ultimoObjetoPadre = listaResultadoHijos.get(listaResultadoHijos.size() - 1);
                            indicadorHijo = columns[0];
                        } else {
//                        System.out.println("CAMBIO ESTRUCTURA HIJO");
                            herenciaIndicador.add(indicadorHijo);
                            procesamientoMultiEstructura(rowIterator, infoArchivoMany, ultimoObjetoPadre, columnsHijo, herenciaIndicador);
                            herenciaIndicador.remove(indicadorHijo);
                        }
                    } else {
                        rowIterator.devolver();
                        break;

                    }
                }
            }
        } else {
            rowIterator.devolver();
        }
    }

    private void llenarObjetoPadre(InfoArchivo infoArchivo, T objetoPadre, String[] columns, List<T> listaResultadoHijos, InfCampo campoOneToMany, InfoArchivo infoArchivoMany) {
        try {
            procesamientoEstructura(infoArchivo, infoArchivoMany.getClaseBase(), listaResultadoHijos, columns);
            Method lMethod = UtilProcesador.obtenerMetodoSet(objetoPadre, campoOneToMany.getSetNombreCampo(), List.class);
            setearValorMetodo(lMethod, listaResultadoHijos, objetoPadre);
        } catch (Exception e) {
            throw new CargueCsvExcepcion("Error llenado Objeto :", e);
        }
    }

    private InfCampo getInfoArchivoOneToMany(List<InfCampo> infCampos, String palabraIndice) {
        InfCampo campoOneToMany = null;
        for (InfCampo infCampo : infCampos) {
            if (infCampo.isEsOneToMany()) {
                if (infCampo.getPalabraReservada().equals(palabraIndice)) {
                    campoOneToMany = infCampo;
                    break;
                }
            }
        }

        if (campoOneToMany != null) {
            return campoOneToMany;
        }

        return null;
    }

    private void procesamientoEstructura(InfoArchivo infoArchivo, Class claseBase, List<T> listaResultado, String[] columns) {
        try {
        if (rowIterator.getLineTotal() == infoArchivo.getCantidadCampos()) {

            listaResultado.add(convertirArrayObjeto(rowIterator.getRowCount(), columns, infoArchivo, claseBase));

        } else {
            listaResultado.add((T) claseBase.newInstance());
            resultado.getErroresEcontrados().add(new ErrorCampo(rowIterator.getRowCount(), 0, "El numero de columnas no es igual a lo parametrizado: Configurado (" + infoArchivo.getCantidadCampos() + "), Existen (" + rowIterator.getLineTotal() + ")", null));
        }
        } catch (InstantiationException | IllegalAccessException e) {
            throw new CargueCsvExcepcion("Error convirtiendo:", e);
        }
    }

    private T convertirArrayObjeto(int lineCount, String[] columns, InfoArchivo infoArchivo, Class claseBase) {
        try {
            T objeto = (T) claseBase.newInstance();
            for (InfCampo infCampo : infoArchivo.getInfCampos()) {
//                System.out.println(infCampo.toString());
                try {
                    if (infCampo.isEsOneToOne()) {
                        llenarObjetoOneToOne(columns, objeto, infCampo, lineCount);
                    } else if (!infCampo.isEsOneToMany()) {
                        llenarObjetoFromArray(columns, objeto, infCampo);
                        ejecutarValidacionesCampo(resultado.getErroresEcontrados(),lineCount,infCampo);
                    }
                } catch (Exception e) {
                    UtilProcesador.adicionarError(resultado.getErroresEcontrados(), lineCount, e, infCampo.getPosicion(), infCampo.getValor());
                }
//                System.out.println(objeto.toString());
            }
            return objeto;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new CargueCsvExcepcion("Error convirtiendo:", e);
        }
    }

    private void ejecutarValidacionesCampo(List listaErrores, int lineCount, InfCampo infCampo) throws Exception{
        EjecutorValidaciones.obtenerInstancia().ejecutarValidacionesParametrizadas(listaErrores,infCampo,lineCount);
    }


    private void llenarObjetoOneToOne(String[] columns, T objeto, InfCampo infCampo, int lineCount) throws Exception {
        T objetoOne = (T) infCampo.getTipoDato();
        InfoArchivo infoArchivoOne = getInfoArchivoSinAnotacionDatosArchivo((Class<T>) objetoOne);
        objetoOne = convertirArrayObjeto(lineCount, columns, infoArchivoOne, (Class<T>) objetoOne);
        Method lMethod = UtilProcesador.obtenerMetodoSet(objeto, infCampo.getSetNombreCampo(), infCampo.getTipoDato());
        setearValorMetodo(lMethod, objetoOne, objeto);
    }

    private void setearValorMetodo(Method lMethod, Object valor, T objeto) throws Exception {
        lMethod.invoke(objeto, valor);
    }


    private InfoArchivo getInfoArchivoSinAnotacionDatosArchivo(Class<T> objetoOne) {
        LeerAnotacionesArchivo anotacionesArchivo = new LeerAnotacionesArchivo(objetoOne);
        return anotacionesArchivo.obtenerInfoArchivoSinAnotacionDatosArchivo(objetoOne);
    }

    private void llenarObjetoFromArray(String[] campos, T objeto, InfCampo infCampo) throws Exception {
        Method lMethod = UtilProcesador.obtenerMetodoSet(objeto, infCampo.getSetNombreCampo(), infCampo.getTipoDato());
//        System.out.println("Metodo: " + infCampo.getSetNombreCampo());
        setearValorMetodo(lMethod, campos, infCampo, objeto);
    }

    private void setearValorMetodo(Method lMethod, String[] campos, InfCampo infCampo, T objeto) throws Exception {
        infCampo.setValor(campos[infCampo.getPosicion()]);
        Object valor = recuperarValor(infCampo, campos);
//        System.out.println("Valor : " + infCampo.getValor());

        lMethod.invoke(objeto, valor);
    }

    private Object recuperarValor(InfCampo infCampo, String[] campos) throws Exception {

        String valorStr = campos[infCampo.getPosicion()];

        valorStr = UtilProcesador.limpiarEspacios(infCampo.getTipoDato().getSimpleName(), infCampo.isTrim(), valorStr);

        if (!infCampo.getConversionPersonal().getSimpleName().equals("ConversionPersonal")) {
            return UtilProcesador.parseStringToConvercionClass(infCampo.getConversionPersonal(), valorStr);

        } else if (infCampo.getTipoDato().getSimpleName().toUpperCase().equals("DATE")) {
            return UtilProcesador.parseDateFromString(valorStr, infCampo.getValidaciones().getFormatoFecha());
        } else {
            return UtilProcesador.parsePrimitiveFromString(valorStr, infCampo.getTipoDato());
        }
    }


}
