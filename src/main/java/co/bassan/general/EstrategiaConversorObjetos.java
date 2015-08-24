package co.bassan.general;

import co.bassan.general.model.InfoArchivo;
import co.bassan.general.util.LeerAnotacionesArchivo;

import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * Created by sebas on 13/08/15.
 */
public abstract class EstrategiaConversorObjetos<T> {


    public abstract ByteArrayOutputStream ejecutar(List<T> listaObjetosBase) throws Exception;

    public InfoArchivo getInfoArchivo(Class claseBase) {
        LeerAnotacionesArchivo anotacionesArchivo = new LeerAnotacionesArchivo(claseBase);
        return anotacionesArchivo.obtenerInfoArchivo();
    }


}
