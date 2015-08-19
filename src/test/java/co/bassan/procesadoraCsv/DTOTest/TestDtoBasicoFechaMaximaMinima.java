package co.bassan.procesadoraCsv.DTOTest;

import co.bassan.anotaciones.DatosArchivo;
import co.bassan.anotaciones.DatosCampo;
import co.bassan.anotaciones.ValidarCampo;

import java.util.Date;

/**
 * Created by sebas on 24/04/15.
 */
@DatosArchivo(cantidadColumnas = 4, separador = "|")
public class TestDtoBasicoFechaMaximaMinima {
    @DatosCampo(posicion = 0, trim = true)
    private String codigoEPS;
    @DatosCampo(posicion = 1, trim = true)
    @ValidarCampo(formatoFecha = "yyyy-MM-dd",fechaMaxima = "2016-05-05", fechaMinima = "1900-01-01")
    private Date fechaInicialPeriodoReportado;
    @DatosCampo(posicion = 2, trim = true)
    @ValidarCampo(formatoFecha = "yyyy-MM-dd")
    private Date fechaFinalPeriodoReportado;
    @DatosCampo(posicion = 3, trim = true)
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

    @Override
    public String toString() {
        return "TestDtoBasico{" +
                "codigoEPS='" + codigoEPS + '\'' +
                ", fechaInicialPeriodoReportado=" + fechaInicialPeriodoReportado +
                ", fechaFinalPeriodoReportado=" + fechaFinalPeriodoReportado +
                ", numeroRegistroArchivo=" + numeroRegistroArchivo +
                '}';
    }
}
