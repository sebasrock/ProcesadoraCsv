package co.bassan.lectora.model;

public class ConfiguracionValidaciones {


    /**
     *  exprecion regular que debe cumplir el campo
     * @return
     */
    String exprecion;

    /**
     * Longitud maxima permitida para este campo
     * @return
     */
    int longitudMaxima;

    /**
     * Longitud minima permitida para este campo
     * @return
     */
    int longitudMinima;

    /**
     * Indica si el campo es obligatorio
     * @return
     */
    boolean requirido;

    /**
     * verifica que tenga valores prmitidos determinados
     * @return
     */
    String[] listaLimitante;


    /**
     * valida el formato de fecha
     * @return
     */
    String formatoFecha;

    /**
     * valida la fecha minima que puede ser ingresada
     * @return
     */
    String fechaMinima;

    /**
     * valida la fecha maxima que puede ser ingresada
     * @return
     */
    String fechaMaxima;


    public String getFormatoFecha() {
        return formatoFecha;
    }

    public void setFormatoFecha(String formatoFecha) {
        this.formatoFecha = formatoFecha;
    }

    public String getExprecion() {
        return exprecion;
    }

    public void setExprecion(String exprecion) {
        this.exprecion = exprecion;
    }

    public int getLongitudMaxima() {
        return longitudMaxima;
    }

    public void setLongitudMaxima(int longitudMaxima) {
        this.longitudMaxima = longitudMaxima;
    }

    public int getLongitudMinima() {
        return longitudMinima;
    }

    public void setLongitudMinima(int longitudMinima) {
        this.longitudMinima = longitudMinima;
    }

    public boolean isRequirido() {
        return requirido;
    }

    public void setRequirido(boolean requirido) {
        this.requirido = requirido;
    }

    public String[] getListaLimitante() {
        return listaLimitante;
    }

    public void setListaLimitante(String[] listaLimitante) {
        this.listaLimitante = listaLimitante;
    }

    public String getFechaMinima() {
        return fechaMinima;
    }

    public void setFechaMinima(String fechaMinima) {
        this.fechaMinima = fechaMinima;
    }

    public String getFechaMaxima() {
        return fechaMaxima;
    }

    public void setFechaMaxima(String fechaMaxima) {
        this.fechaMaxima = fechaMaxima;
    }

    public ConfiguracionValidaciones() {
    }
}