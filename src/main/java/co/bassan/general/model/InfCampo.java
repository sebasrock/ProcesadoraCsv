package co.bassan.general.model;

import co.bassan.general.ConversionPersonal;

/**
 * Created by sebas on 13/08/15.
 */
public class InfCampo {

    private boolean trim;
    private String nombreCampo;
    private String nombreCampoArchivo;
    private int posicion;
    private Class<?> tipoDato;
    private Class<?> tipoDatoGenerico;
    private String valor;
    private Class<? extends ConversionPersonal> conversionPersonal;
    private String palabraReservada;
    private boolean esOneToOne;
    private boolean esOneToMany;

    private InfValidaciones validaciones;

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

    public Class<?> getTipoDatoGenerico() {
        return tipoDatoGenerico;
    }

    public void setTipoDatoGenerico(Class<?> tipoDatoGenerico) {
        this.tipoDatoGenerico = tipoDatoGenerico;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Class<? extends ConversionPersonal> getConversionPersonal() {
        return conversionPersonal;
    }

    public void setConversionPersonal(Class<? extends ConversionPersonal> conversionPersonal) {
        this.conversionPersonal = conversionPersonal;
    }

    public String getPalabraReservada() {
        return palabraReservada;
    }

    public void setPalabraReservada(String palabraReservada) {
        this.palabraReservada = palabraReservada;
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

    public InfValidaciones getValidaciones() {
        return validaciones;
    }

    public void setValidaciones(InfValidaciones validaciones) {
        this.validaciones = validaciones;
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

    @Override
    public String toString() {
        return "InfCampo{" +
                "trim=" + trim +
                ", nombreCampo='" + nombreCampo + '\'' +
                ", nombreCampoArchivo='" + nombreCampoArchivo + '\'' +
                ", posicion=" + posicion +
                ", tipoDato=" + tipoDato +
                ", tipoDatoGenerico=" + tipoDatoGenerico +
                ", valor='" + valor + '\'' +
                ", conversionPersonal=" + conversionPersonal +
                ", palabraReservada='" + palabraReservada + '\'' +
                ", esOneToOne=" + esOneToOne +
                ", esOneToMany=" + esOneToMany +
                ", validaciones=" + validaciones +
                '}';
    }
}
