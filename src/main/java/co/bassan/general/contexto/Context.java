package co.bassan.general.contexto;

import co.bassan.general.EstrategiaConversor;
import co.bassan.general.model.ResultadoCargue;

/**
 * Created by sebas on 13/08/15.
 */
public class Context<T> {
    EstrategiaConversor c;

    public Context(EstrategiaConversor c) {
        this.c = c;
    }

    public void setStrategy(EstrategiaConversor c) {
        this.c = c;
    }

    public ResultadoCargue<T> ejecutar(Class claseBase, byte[] archivo) throws Exception {
        return c.ejecutar(claseBase, archivo);
    }


}