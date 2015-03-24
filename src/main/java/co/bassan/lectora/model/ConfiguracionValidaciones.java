package co.bassan.lectora.model;

public class ConfiguracionValidaciones {


    private String exprecion;

    private int longitudMaxima;

    private int longitudMinima;

    private boolean requirido;

    private String[] listaLimitante;


    private String formatoFecha;

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

    public ConfiguracionValidaciones() {
    }
}