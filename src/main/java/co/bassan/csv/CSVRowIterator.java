package co.bassan.csv;

import co.bassan.excepciones.CargueCsvExcepcion;
import co.bassan.general.util.UtilProcesador;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by sebas on 14/08/15.
 */
public class CSVRowIterator implements Iterator<String[]> {

    private ArrayList<String> lineBuffer;
    private String lineBufferBefore;
    BufferedReader reader;
    private int rowCount = 0;
    private int lineTotal = 0;
    private String separador;
    private boolean validaCambioEstructura;
    private boolean cambioEstructura;

    /**
     * Constructor.
     */
    public CSVRowIterator(BufferedReader reader, String separador, boolean validaCambioEstructura) {
        lineBuffer = new ArrayList<String>();
        this.reader = reader;
        this.rowCount = 0;
        this.lineTotal = 0;
        this.separador = separador;
        this.validaCambioEstructura = validaCambioEstructura;
        this.cambioEstructura = false;
        this.lineBufferBefore = "";
    }

    /**
     * Returns true when the buffer has more lines to deliver.
     * This method also tries to read a new line from the
     * underlying stream.
     *
     * @return true when more lines are available.
     */
    public boolean hasNext() {
        return internalHasNext();
    }


    public boolean hasNextEstructura() {
        if (validaCambioEstructura)
            return cambioEstructura;
        else
            return Boolean.FALSE;
    }

    private void verificaCambioEstructura(String lineNueva) {
        String indiceNuevo = "";
        String indiceViejo = "";
        if (validaCambioEstructura)
            if (!lineNueva.isEmpty() && !lineBufferBefore.isEmpty()) {
                indiceNuevo = lineNueva.substring(0, lineNueva.indexOf(separador));
                indiceViejo = lineBufferBefore.substring(0, lineBufferBefore.indexOf(separador));
//            System.out.println("lineNueva = [" + lineNueva + "] , lineVieja = [" + lineBufferBefore + "]");
//            System.out.println("indiceNuevo = [" + indiceNuevo + "] , indiceViejo = [" + indiceViejo + "]");
                if (indiceNuevo.equals(indiceViejo))
                    cambioEstructura = false;
                else
                    cambioEstructura = true;
            } else {
                cambioEstructura = false;
            }
    }



    /**
     * Internal method to control check of comments.
     *
     * @return true if a line is available
     */
    private boolean internalHasNext() {
        if (lineBuffer.size() > 0) return true;

        try {
            boolean doRead = true;
            while (doRead) {
                // This is default
                doRead = false;

                // try to read a line from file
                if (getReader().ready()) {
                    String s = getReader().readLine();

                    if (s != null) {
                        incrementLineCount();
                        verificaCambioEstructura(s);
                        lineBuffer.add(s);
                    }
                }
            }
        } catch (IOException e) {
            throw new CargueCsvExcepcion("Cannot read from stream:", e);
        }

        if (lineBuffer.size() > 0) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Delivers the next CSV row.
     * The method will read from the internal line buffer and
     * ensures that a single CSV row is complete before it will
     * be returned.
     *
     * @return next row of columns
     */
    public String[] next() {
        String o[] = null;
        StringBuilder s = new StringBuilder();
        while (o == null) {
            if (!internalHasNext()) throw new CargueCsvExcepcion("No ahi mas filas");
            String line = lineBuffer.remove(0);
            lineBufferBefore = line;
//            System.out.println("foo=[" + line + "], s is now: [" + s + "]");

            // Add the buffer to the line
            s.append(line);
            s.append('\n');

            // Try to get a row from it
            // This method will also take care of comments and strip down the buffer
            // if required
            line = UtilProcesador.prepararLinea(line, separador);
            o = UtilProcesador.separacionLinea(line, separador);
        }
//        System.out.println("returning a row: " + o.length);
        incrementRowCount();
        lineTotal = o.length;
//        debug(getRowCount(), o);
        return o;
    }

    /**
     * Not suported.
     */
    public void remove() {
        throw new CargueCsvExcepcion("Remove is not supported.");
    }

    public void devolver() {
        lineBuffer.add(lineBufferBefore);
        verificaCambioEstructura(lineBufferBefore);
        decremetaRowCount();
    }

    private int decremetaRowCount() {
        rowCount--;
        return getRowCount();
    }

    public BufferedReader getReader() {
        return reader;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getLineTotal() {
        return lineTotal;
    }

    protected int incrementLineCount() {
        lineTotal++;
        return getLineTotal();
    }

    protected int incrementRowCount() {
        rowCount++;
        return getRowCount();
    }

    protected static void debug(int idx, String o[]) {
        System.out.print(idx + ":");
        for (int i = 0; i < o.length; i++) {
            System.out.print(" [" + o[i] + "]");
        }
        System.out.println();
    }
}

