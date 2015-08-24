package co.bassan.procesadoraCsv.DTOTest;

import co.bassan.anotaciones.DatosArchivo;
import co.bassan.anotaciones.DatosCampo;
import co.bassan.anotaciones.ValidarCampo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by sebas on 24/04/15.
 */
@DatosArchivo(separador = "|", cantidadColumnas = 4)
public class TestHijoOneToManyRequerido implements Serializable {

    @DatosCampo(posicion = 1)
    @ValidarCampo(requirido = true)
    private String codigo;
    @DatosCampo(posicion = 2)
    @ValidarCampo(formatoFecha = "yyyy-MM-dd")
    private Date fecha;
    @DatosCampo(posicion = 3)
    private Long numeroLong;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getNumeroLong() {
        return numeroLong;
    }

    public void setNumeroLong(Long numeroLong) {
        this.numeroLong = numeroLong;
    }

    @Override
    public String toString() {
        return "TestHijoOneToMany{" +
                "codigo='" + codigo + '\'' +
                ", fecha=" + fecha +
                ", numeroLong=" + numeroLong +
                '}';
    }
}
