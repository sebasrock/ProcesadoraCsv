package co.bassan.lectora.conceptos;

import co.bassan.lectora.anotaciones.DatosArchivo;
import co.bassan.lectora.anotaciones.DatosCampo;
import co.bassan.lectora.anotaciones.ValidarCampo;

import java.math.BigDecimal;

/**
 * Created by sebas on 22/03/15.
 */
@DatosArchivo(saltarPrimeraLinea = true, separador = ",", multiEstructura = true,cantidadRegistros = 10)
public class Estructura3 {

    @DatosCampo(posicion = 0, nombre = "0", trim = true)
    @ValidarCampo(requirido = true)
    private String nombre;
    @DatosCampo(posicion = 1, nombre = "1")
    @ValidarCampo(requirido = true)
    private BigDecimal bigCodigo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getBigCodigo() {
        return bigCodigo;
    }

    public void setBigCodigo(BigDecimal bigCodigo) {
        this.bigCodigo = bigCodigo;
    }

    @Override
    public String toString() {
        return "Estructura3{" +
                "nombre='" + nombre + '\'' +
                ", bigCodigo=" + bigCodigo +
                '}';
    }
}
