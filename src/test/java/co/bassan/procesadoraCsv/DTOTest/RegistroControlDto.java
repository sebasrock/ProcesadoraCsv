package co.bassan.procesadoraCsv.DTOTest;

import co.bassan.lectora.anotaciones.DatosCampo;
import co.bassan.lectora.anotaciones.ValidarCampo;

import java.util.Date;

/**
 * Created by sebas on 24/04/15.
 */

public class RegistroControlDto {
    @DatosCampo(posicion = 0, trim = true)
    @ValidarCampo(requirido = true)
    private String codigoEPS;
    @DatosCampo(posicion = 1, trim = true)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd",fechaMinima = "1900-01-01")
    private Date fechaInicialPeriodoReportado;
    @DatosCampo(posicion = 2, trim = true)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd",fechaMaxima = "2015-01-01")
    private Date fechaFinalPeriodoReportado;
    @DatosCampo(posicion = 3, trim = true)
    @ValidarCampo(requirido = true)
    private int numeroRegistroArchivo;


    public String getCodigoEPS() {
        return codigoEPS;
    }

    public void setCodigoEPS(String codigoEPS) {
        this.codigoEPS = codigoEPS;
    }

    public Date getFechaInicialPeriodoReportado() {
        return fechaInicialPeriodoReportado;
    }

    public void setFechaInicialPeriodoReportado(Date fechaInicialPeriodoReportado) {
        this.fechaInicialPeriodoReportado = fechaInicialPeriodoReportado;
    }

    public Date getFechaFinalPeriodoReportado() {
        return fechaFinalPeriodoReportado;
    }

    public void setFechaFinalPeriodoReportado(Date fechaFinalPeriodoReportado) {
        this.fechaFinalPeriodoReportado = fechaFinalPeriodoReportado;
    }

    public int getNumeroRegistroArchivo() {
        return numeroRegistroArchivo;
    }

    public void setNumeroRegistroArchivo(int numeroRegistroArchivo) {
        this.numeroRegistroArchivo = numeroRegistroArchivo;
    }
}
