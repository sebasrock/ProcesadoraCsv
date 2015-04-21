package co.bassan.lectora.conceptos;

import co.bassan.lectora.anotaciones.DatosArchivo;
import co.bassan.lectora.anotaciones.DatosCampo;
import co.bassan.lectora.anotaciones.ValidarCampo;

import java.math.BigDecimal;

/**
 * Created by sebas on 22/03/15.
 */
@DatosArchivo(saltarPrimeraLinea = false, separador = ",",cantidadRegistros = 10)
public class Estructura2 {

    @DatosCampo(posicion = 3, nombre = "4")
    @ValidarCampo(requirido = true)
    private String nombre;
    @DatosCampo(posicion = 4, nombre = "5")
    @ValidarCampo(requirido = true)
    private String nombre2;
    @DatosCampo(posicion = 5, nombre = "6")
    @ValidarCampo(requirido = true)
    private BigDecimal bigCodigo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public BigDecimal getBigCodigo() {
        return bigCodigo;
    }

    public void setBigCodigo(BigDecimal bigCodigo) {
        this.bigCodigo = bigCodigo;
    }


    @Override
    public String toString() {
        return "Estructura2{" +
                "nombre='" + nombre + '\'' +
                ", nombre2='" + nombre2 + '\'' +
                ", bigCodigo=" + bigCodigo +
                '}';
    }
}
