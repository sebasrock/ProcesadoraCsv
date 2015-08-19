package co.bassan.general;

import co.bassan.general.model.ErrorCampo;
import co.bassan.general.model.InfoArchivo;
import co.bassan.general.model.ResultadoCargue;
import co.bassan.excepciones.CargueCsvExcepcion;
import co.bassan.general.util.LeerAnotacionesArchivo;

import java.io.*;
import java.util.List;

/**
 * Created by sebas on 13/08/15.
 */
public abstract class EstrategiaConversor<T> {

    protected List<ErrorCampo> listaErrores;

    public abstract ResultadoCargue<T> ejecutar(Class<T> claseBase, byte[] archivo) throws Exception;

    public InfoArchivo getInfoArchivo(Class claseBase) {
        LeerAnotacionesArchivo anotacionesArchivo = new LeerAnotacionesArchivo(claseBase);
        return anotacionesArchivo.obtenerInfoArchivo();
    }

    public BufferedReader getBufferedReader(byte[] archivo) {
        InputStream is = new ByteArrayInputStream(archivo);
        return new BufferedReader(new InputStreamReader(is));
    }

    public void close(BufferedReader argReader) throws CargueCsvExcepcion {
        if (argReader != null) try {
            argReader.close();
        } catch (IOException e) {
            throw new CargueCsvExcepcion("No se puede cerrar el archivo", e);
        }
    }

}
