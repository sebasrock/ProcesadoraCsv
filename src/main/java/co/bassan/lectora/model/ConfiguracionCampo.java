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
    private Class<?> tipoDatoGenerico;
    private String valor;
    private Class<? extends ConvertidorInterfaz> convercionClass;
    private String palabraReservada;
    private boolean esOneToOne;
    private boolean esOneToMany;

    private ConfiguracionValidaciones validaciones;

    public ConfiguracionCampo(String palabraReservada) {
        this.palabraReservada = palabraReservada;
    }

    public ConfiguracionCampo() {
    }

    public boolean isEsOneToOne() {
        return esOneToOne;
    }

    public void setEsOneToOne(boolean esOneToOne) {
        this.esOneToOne = esOneToOne;
    }

    public boolean isEsOneToMany() {
        return esOneToMany;
    }

    public void setEsOneToMany(boolean esOneToMany) {
        this.esOneToMany = esOneToMany;
    }

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

    public String getNombreCampoArchivo() {
        return nombreCampoArchivo;
    }

    public void setNombreCampoArchivo(String nombreCampoArchivo) {
        this.nombreCampoArchivo = nombreCampoArchivo;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Class<?> getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(Class<?> tipoDato) {
        this.tipoDato = tipoDato;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Class<? extends ConvertidorInterfaz> getConvercionClass() {
        return convercionClass;
    }

    public void setConvercionClass(Class<? extends ConvertidorInterfaz> convercionClass) {
        this.convercionClass = convercionClass;
    }

    public String getPalabraReservada() {
        return palabraReservada;
    }

    public void setPalabraReservada(String palabraReservada) {
        this.palabraReservada = palabraReservada;
    }

    public ConfiguracionValidaciones getValidaciones() {
        return validaciones;
    }

    public void setValidaciones(ConfiguracionValidaciones validaciones) {
        this.validaciones = validaciones;
    }

    public Class<?> getTipoDatoGenerico() {
        return tipoDatoGenerico;
    }

    public void setTipoDatoGenerico(Class<?> tipoDatoGenerico) {
        this.tipoDatoGenerico = tipoDatoGenerico;
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
