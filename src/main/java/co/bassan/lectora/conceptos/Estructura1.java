package co.bassan.lectora.conceptos;

import co.bassan.lectora.anotaciones.*;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by sebas on 22/03/15.
 */
@DatosArchivo(saltarPrimeraLinea = false, separador = ",", multiEstructura = true,cantidadRegistros = 10)
public class Estructura1 {

    @DatosCampo(posicion = 0, nombre = "0", trim = true)
    @ValidarCampo(requirido = true)
    private String nombre;
    @DatosCampo(posicion = 1, nombre = "1")
    @ValidarCampo(requirido = true)
    private int intCodigo;
    @DatosCampo(posicion = 2, nombre = "2")
    @ValidarCampo(requirido = true)
    private BigInteger bigCodigo;
    @OneToOne
    private Estructura2 estructura2;
    @OneToMany(palabraResevada = "ES3")
    private List<Estructura3> estructura3;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIntCodigo() {
        return intCodigo;
    }

    public void setIntCodigo(int intCodigo) {
        this.intCodigo = intCodigo;
    }

    public BigInteger getBigCodigo() {
        return bigCodigo;
    }

    public void setBigCodigo(BigInteger bigCodigo) {
        this.bigCodigo = bigCodigo;
    }

    public Estructura2 getEstructura2() {
        return estructura2;
    }

    public void setEstructura2(Estructura2 estructura2) {
        this.estructura2 = estructura2;
    }

    public List<Estructura3> getEstructura3() {
        return estructura3;
    }

    public void setEstructura3(List<Estructura3> estructura3) {
        this.estructura3 = estructura3;
    }


    @Override
    public String toString() {
        return "Estructura1{" +
                "nombre='" + nombre + '\'' +
                ", intCodigo=" + intCodigo +
                ", bigCodigo=" + bigCodigo +
                ", estructura2=" + estructura2.toString() +
                '}';
    }
}
