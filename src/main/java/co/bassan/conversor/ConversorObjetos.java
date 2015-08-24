package co.bassan.conversor;

import co.bassan.csv.EstrategiaCsv;
import co.bassan.csv.EstrategiaCsvEscritura;
import co.bassan.general.constantes.TiposArchivo;
import co.bassan.general.contexto.Context;
import co.bassan.general.contexto.ContextEscritura;
import co.bassan.general.model.ResultadoCargue;

import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * Created by sebas on 13/08/15.
 */
public class ConversorObjetos<T> {

    public ByteArrayOutputStream ejecutar(List<T> listaObjetosBase,TiposArchivo tiposArchivo) throws Exception {
        ContextEscritura context = new ContextEscritura(new EstrategiaCsvEscritura());

        switch (tiposArchivo) {
            case CSV:
                context.setStrategy(new EstrategiaCsvEscritura());
                break;
            case XSLT:
                break;
        }

        return context.ejecutar(listaObjetosBase);
    }

}
