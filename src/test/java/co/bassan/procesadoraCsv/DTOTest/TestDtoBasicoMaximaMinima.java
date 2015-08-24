package co.bassan.procesadoraCsv.DTOTest;

import co.bassan.anotaciones.DatosArchivo;
import co.bassan.anotaciones.DatosCampo;
import co.bassan.anotaciones.ValidarCampo;

import java.util.Date;

/**
 * Created by sebas on 24/04/15.
 */
@DatosArchivo(cantidadColumnas = 4, separador = "|")
public class TestDtoBasicoMaximaMinima {
    @DatosCampo(posicion = 0, trim = true)
    @ValidarCampo(longitudMaxima = 10,longitudMinima = 2)
    private String codigoEPS;
    @DatosCampo(posicion = 1, trim = true)
    @ValidarCampo(formatoFecha = "yyyy-MM-dd")
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
