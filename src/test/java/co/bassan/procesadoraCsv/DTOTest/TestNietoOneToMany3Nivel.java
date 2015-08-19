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
@DatosArchivo(separador = "|", cantidadColumnas = 3)
public class TestNietoOneToMany3Nivel implements Serializable {

    @DatosCampo(posicion = 1)
    private String codigo;
    @DatosCampo(posicion = 2)
    @ValidarCampo(requirido = true, formatoFecha = "yyyy-MM-dd", fechaMinima = "1900-01-01")
    private Date fecha;

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
}
