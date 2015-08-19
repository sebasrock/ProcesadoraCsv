package co.bassan.procesadoraCsv.DTOTest;

import co.bassan.anotaciones.DatosArchivo;
import co.bassan.anotaciones.DatosCampo;
import co.bassan.anotaciones.OneToMany;
import co.bassan.anotaciones.ValidarCampo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by sebas on 24/04/15.
 */
@DatosArchivo(separador = "|", cantidadColumnas = 5 , multiEstructura = true)
public class TestDtoOneToMany3Nivel implements Serializable {

    @DatosCampo(posicion = 1, trim = true)
    @ValidarCampo(requirido = true)
    private String codigoEPS;
    @DatosCampo(posicion = 2, trim = true)
    @ValidarCampo(requirido = true, formatoFecha = "yyyy-MM-dd", fechaMinima = "1900-01-01")
    private Date fechaInicialPeriodoReportado;
    @DatosCampo(posicion = 3, trim = true)
    @ValidarCampo(requirido = true, formatoFecha = "yyyy-MM-dd", fechaMaxima = "2015-01-01")
    private Date fechaFinalPeriodoReportado;
    @DatosCampo(posicion = 4, trim = true)
    @ValidarCampo(requirido = true)
    private int numeroRegistroArchivo;

    @OneToMany(palabraResevada = "2")
    private List<TestHijoOneToMany3Nivel> testHijoOneToManies;

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

    public List<TestHijoOneToMany3Nivel> getTestHijoOneToManies() {
        return testHijoOneToManies;
    }

    public void setTestHijoOneToManies(List<TestHijoOneToMany3Nivel> testHijoOneToManies) {
        this.testHijoOneToManies = testHijoOneToManies;
    }
}
