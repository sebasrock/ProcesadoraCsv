package co.bassan.general.util;

import co.bassan.general.model.ErrorCampo;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by ssanchez on 23/02/16.
 */
public  class UtilManejoErrores {


    public static byte[] generarArchivoErrores(List<ErrorCampo> erroresEcontrados) throws Exception {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintWriter pw = new PrintWriter(out);

        for (ErrorCampo erroresEcontrado : erroresEcontrados) {
            pw.println(erroresEcontrado.toString());
        }

        pw.flush();

        return out.toByteArray();

    }
}

