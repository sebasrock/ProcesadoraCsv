package co.bassan.general.contexto;

import co.bassan.general.EstrategiaConversor;
import co.bassan.general.EstrategiaConversorObjetos;
import co.bassan.general.model.ResultadoCargue;

import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * Created by sebas on 13/08/15.
 */
public class ContextEscritura<T> {

    EstrategiaConversorObjetos c;

    public ContextEscritura(EstrategiaConversorObjetos c) {
        this.c = c;
    }

    public void setStrategy(EstrategiaConversorObjetos c) {
        this.c = c;
    }

    public ByteArrayOutputStream ejecutar(List<T> listaObjetosBase) throws Exception {
        return c.ejecutar(listaObjetosBase);
    }


}