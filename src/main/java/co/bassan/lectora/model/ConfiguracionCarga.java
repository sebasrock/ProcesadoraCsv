package co.bassan.lectora.model;


import java.io.Serializable;
import java.util.List;

/**
 * Created by Sebastian- on 08/02/2015.
 */
public class ConfiguracionCarga implements Serializable {

    private String nombreArchivo;
    private String separador;
    private boolean saltarPrimeraLinea;
    private int cantidadCampos;
    private boolean EsMultiEstructura;
    private List<ConfiguracionCampo> configCampos;


    public boolean isEsMultiEstructura() {
        return EsMultiEstructura;
    }

    public void setEsMultiEstructura(boolean esMultiEstructura) {
        EsMultiEstructura = esMultiEstructura;
    }

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

    public List<ConfiguracionCampo> getConfigCampos() {
        return configCampos;
    }

    public void setConfigCampos(List<ConfiguracionCampo> configCampos) {
        this.configCampos = configCampos;
    }

    public int getCantidadCampos() {
        if (configCampos != null) {
            cantidadCampos = configCampos.size();
        } else {
            cantidadCampos = 0;
        }
        return cantidadCampos;
    }

    public void setCantidadCampos(int cantidadCampos) {
        this.cantidadCampos = cantidadCampos;
    }


}
