package co.bassan.lectora.model;

import co.bassan.lectora.interfaces.ConvertidorInterfaz;

/**
 * Created by Sebastian- on 08/02/2015.
 */
public class ConfiguracionCampo {
    private boolean trim;
    private String nombreCampo;
    private String nombreCampoArchivo;
    private int posicion;
    private Class<?> tipoDato;
    private String valor;
    private Class<? extends ConvertidorInterfaz> convercionClass;

    private String exprecion;
    private int longitudMaxima;
    private int longitudMinima;
    private boolean requirido;
    private String[] listaLimitante;
    private String formatoFecha;


    public boolean isTrim() {
        return trim;
    }

    public void setTrim(boolean trim) {
        this.trim = trim;
    }

    public String getNombreCampo() {
        return nombreCampo;
    }

    public void setNombreCampo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
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

    public String getNombreCampoArchivo() {
        return nombreCampoArchivo;
    }

    public void setNombreCampoArchivo(String nombreCampoArchivo) {
        this.nombreCampoArchivo = nombreCampoArchivo;
    }

    public Class<?> getTipoDato() {
        return tipoDato;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setTipoDato(Class<?> tipoDato) {
        this.tipoDato = tipoDato;
    }

    public String[] getListaLimitante() {
        return listaLimitante;
    }

    public void setListaLimitante(String[] listaLimitante) {
        this.listaLimitante = listaLimitante;
    }

    public Class<? extends ConvertidorInterfaz> getConvercionClass() {
        return convercionClass;
    }

    public void setConvercionClass(Class<? extends ConvertidorInterfaz> convercionClass) {
        this.convercionClass = convercionClass;
    }

    public String getFormatoFecha() {
        return formatoFecha;
    }

    public void setFormatoFecha(String formatoFecha) {
        this.formatoFecha = formatoFecha;
    }

    public String getSetNombreCampo() {
        String nombreMetodo = "";
        if (getNombreCampo() != null) {
            String primerLetra = getNombreCampo().toUpperCase().substring(0, 1);
            nombreMetodo = "set" + primerLetra + getNombreCampo().substring(1, getNombreCampo().length());
        }
        return nombreMetodo;
    }
    public String getGetNombreCampo() {
        String nombreMetodo = "";
        if (getNombreCampo() != null) {
            String primerLetra = getNombreCampo().toUpperCase().substring(0, 1);
            nombreMetodo = "get" + primerLetra + getNombreCampo().substring(1, getNombreCampo().length());
        }
        return nombreMetodo;
    }
}
