package co.bassan.conversor;

import co.bassan.csv.EstrategiaCsv;
import co.bassan.general.constantes.TiposArchivo;
import co.bassan.general.contexto.Context;
import co.bassan.general.model.ResultadoCargue;

/**
 * Created by sebas on 13/08/15.
 */
public class ConversorArchivos<T> {

    public ResultadoCargue<T> ejecutar(Class<T> claseBase, byte[] archivo, TiposArchivo tiposArchivo) throws Exception {
        Context context = new Context(new EstrategiaCsv());

        switch (tiposArchivo) {
            case CSV:
                context.setStrategy(new EstrategiaCsv());
                break;
            case XSLT:
                break;
        }

        return context.ejecutar(claseBase, archivo);
    }

}
