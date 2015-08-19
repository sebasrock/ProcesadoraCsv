package co.bassan.general.model;

import java.util.List;

/**
 * Created by sebas on 13/08/15.
 */
public class InfoArchivo {

    private String nombreArchivo;
    private String separador;
    private boolean saltarPrimeraLinea;
    private int cantidadCampos;
    private boolean EsMultiEstructura;
    private List<InfCampo> infCampos;

    private Class claseBase;

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getSeparador() {
        return separador;
    }

    public void setSeparador(String separador) {
        this.separador = separador;
    }

    public boolean isSaltarPrimeraLinea() {
        return saltarPrimeraLinea;
    }

    public void setSaltarPrimeraLinea(boolean saltarPrimeraLinea) {
        this.saltarPrimeraLinea = saltarPrimeraLinea;
    }

    public int getCantidadCampos() {
        return cantidadCampos;
    }

    public void setCantidadCampos(int cantidadCampos) {
        this.cantidadCampos = cantidadCampos;
    }

    public boolean isEsMultiEstructura() {
        return EsMultiEstructura;
    }

    public void setEsMultiEstructura(boolean esMultiEstructura) {
        EsMultiEstructura = esMultiEstructura;
    }

    public List<InfCampo> getInfCampos() {
        return infCampos;
    }

    public void setInfCampos(List<InfCampo> infCampos) {
        this.infCampos = infCampos;
    }

    public Class getClaseBase() {
        return claseBase;
    }

    public void setClaseBase(Class claseBase) {
        this.claseBase = claseBase;
    }
}