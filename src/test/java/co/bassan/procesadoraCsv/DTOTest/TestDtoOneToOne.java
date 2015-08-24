package co.bassan.procesadoraCsv.DTOTest;

import co.bassan.anotaciones.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sebas on 24/04/15.
 */
@DatosArchivo(separador = "|", cantidadColumnas = 5)
public class TestDtoOneToOne implements Serializable {

    @DatosCampo(posicion = 0)
    private int consecutivo;

    @OneToOne
    private TestHijoOneToOne testHijoOneToOne;

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public TestHijoOneToOne getTestHijoOneToOne() {
        return testHijoOneToOne;
    }

    public void setTestHijoOneToOne(TestHijoOneToOne testHijoOneToOne) {
        this.testHijoOneToOne = testHijoOneToOne;
    }

    @Override
    public String toString() {
        return "TestDtoOneToOne{" +
                "consecutivo=" + consecutivo +
                ", testHijoOneToOne=" + ((testHijoOneToOne!=null)?testHijoOneToOne.toString():" null" )+
                '}';
    }
}
