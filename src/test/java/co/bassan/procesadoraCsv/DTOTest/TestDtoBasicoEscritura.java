package co.bassan.procesadoraCsv.DTOTest;

import co.bassan.anotaciones.DatosArchivo;
import co.bassan.anotaciones.DatosCampo;
import co.bassan.anotaciones.ValidarCampo;

import java.util.Date;

/**
 * Created by sebas on 24/04/15.
 */
@DatosArchivo(cantidadColumnas = 4, separador = "|",nombre = "TESTs")
public class TestDtoBasicoEscritura {
    @DatosCampo(posicion = 0, nombre = "COODIGO")
    private String codigoEPS;
    @DatosCampo(posicion = 1, nombre = "FECHA INICIAL")
    @ValidarCampo(formatoFecha = "yyyy-MM-dd")
    private Date fechaInicialPeriodoReportado;
    @DatosCampo(posicion = 2, nombre = "FECHA FINAL")
    @ValidarCampo(formatoFecha = "yyyy-MM-dd")
    private Date fechaFinalPeriodoReportado;
    @DatosCampo(posicion = 3, nombre = "NUMERO")
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
