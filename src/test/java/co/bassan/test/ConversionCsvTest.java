package co.bassan.test;

import co.bassan.conversor.ConversorArchivos;
import co.bassan.general.constantes.TiposArchivo;
import co.bassan.general.model.ResultadoCargue;
import co.bassan.procesadoraCsv.DTOTest.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by sebas on 14/08/15.
 */
public class ConversionCsvTest {

    @Test
    public void probarCargaExitosaEstructuraBasica() {
        try {
            // Dado

            byte[] archivo = crearArchivoBasicoExitoso();

            // Cuando
            ConversorArchivos<TestDtoBasico> csv = new ConversorArchivos<TestDtoBasico>();
            ResultadoCargue<TestDtoBasico> resultadoCargue = csv.ejecutar(TestDtoBasico.class, archivo, TiposArchivo.CSV);

            // Entonces
            assertThat(resultadoCargue.getElementosCargados()).hasSize(3).isInstanceOf(ArrayList.class).extracting("codigoEPS").contains("EPS005");
            assertThat(resultadoCargue.getErroresEcontrados()).hasSize(0);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

    }

    @Test
    public void probarCargaExitosaEstructuraBasicabigData() {
        try {
            // Dado

            byte[] archivo = crearArchivoBasicoExitosoGigante();

            // Cuando
            ConversorArchivos<TestDtoBasico> csv = new ConversorArchivos<TestDtoBasico>();
            ResultadoCargue<TestDtoBasico> resultadoCargue = csv.ejecutar(TestDtoBasico.class, archivo, TiposArchivo.CSV);

            // Entonces
            assertThat(resultadoCargue.getElementosCargados()).hasSize(80000).isInstanceOf(ArrayList.class).extracting("codigoEPS").contains("EPS005");
            assertThat(resultadoCargue.getErroresEcontrados()).hasSize(0);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

    }

    @Test
    public void probarCargaExitosaEstructuraOneToOne() {
        try {
            // Dado

            byte[] archivo = crearArchivoOneToOneExitoso();

            // Cuando
            ConversorArchivos<TestDtoOneToOne> csv = new ConversorArchivos<TestDtoOneToOne>();
            ResultadoCargue<TestDtoOneToOne> resultadoCargue = csv.ejecutar(TestDtoOneToOne.class, archivo, TiposArchivo.CSV);

            // Entonces
            assertThat(resultadoCargue.getElementosCargados()).hasSize(3).isInstanceOf(ArrayList.class).extracting("testHijoOneToOne").extracting("codigoEPS").contains("EPS005");
            assertThat(resultadoCargue.getErroresEcontrados()).hasSize(0);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

    }

    @Test
    public void probarCargaExitosaEstructuraOneToOneBigData() {
        try {
            // Dado

            byte[] archivo = crearArchivoOneToOneExitosoGrande();

            // Cuando
            ConversorArchivos<TestDtoOneToOne> csv = new ConversorArchivos<TestDtoOneToOne>();
            ResultadoCargue<TestDtoOneToOne> resultadoCargue = csv.ejecutar(TestDtoOneToOne.class, archivo, TiposArchivo.CSV);

            // Entonces
            assertThat(resultadoCargue.getElementosCargados()).hasSize(80000).isInstanceOf(ArrayList.class).extracting("testHijoOneToOne").extracting("codigoEPS").contains("EPS005");
            assertThat(resultadoCargue.getErroresEcontrados()).hasSize(0);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

    }


    @Test
    public void probarCargaExitosaEstructuraOneToMany() {
        try {
            // Dado

            byte[] archivo = crearArchivoOneToManyExitoso();

            // Cuando
            ConversorArchivos<TestDtoOneToMany> csv = new ConversorArchivos<TestDtoOneToMany>();
            ResultadoCargue<TestDtoOneToMany> resultadoCargue = csv.ejecutar(TestDtoOneToMany.class, archivo, TiposArchivo.CSV);

            // Entonces
            assertThat(resultadoCargue.getElementosCargados()).hasSize(2).isInstanceOf(ArrayList.class).extracting("codigoEPS").contains("EPS005");
            assertThat(resultadoCargue.getElementosCargados().get(0)).isInstanceOf(TestDtoOneToMany.class);
            assertThat(resultadoCargue.getElementosCargados()).extracting("testHijoOneToManies").hasSize(2);
            assertThat(resultadoCargue.getErroresEcontrados()).hasSize(0);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

    }

    @Test
    public void probarCargaExitosaEstructuraOneToManyBigData() {
        try {
            // Dado

            byte[] archivo = crearArchivoOneToManyExitosoGrande();

            // Cuando
            ConversorArchivos<TestDtoOneToMany> csv = new ConversorArchivos<TestDtoOneToMany>();
            ResultadoCargue<TestDtoOneToMany> resultadoCargue = csv.ejecutar(TestDtoOneToMany.class, archivo, TiposArchivo.CSV);

            // Entonces
            assertThat(resultadoCargue.getElementosCargados()).hasSize(2).isInstanceOf(ArrayList.class).extracting("codigoEPS").contains("EPS005");
            assertThat(resultadoCargue.getElementosCargados().get(0)).isInstanceOf(TestDtoOneToMany.class);
            assertThat(resultadoCargue.getElementosCargados()).extracting("testHijoOneToManies").hasSize(2);
            assertThat(resultadoCargue.getErroresEcontrados()).hasSize(0);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

    }


    @Test
    public void probarCargaExitosaEstructuraOneToMany3Niveles() {
        try {
            // Dado

            byte[] archivo = crearArchivoOneToMany3NivelesExitoso();

            // Cuando
            ConversorArchivos<TestDtoOneToMany3Nivel> csv = new ConversorArchivos<TestDtoOneToMany3Nivel>();
            ResultadoCargue<TestDtoOneToMany3Nivel> resultadoCargue = csv.ejecutar(TestDtoOneToMany3Nivel.class, archivo, TiposArchivo.CSV);

            // Entonces
            assertThat(resultadoCargue.getElementosCargados()).hasSize(3).isInstanceOf(ArrayList.class).extracting("codigoEPS").contains("EPS005");
            assertThat(resultadoCargue.getElementosCargados().get(0)).isInstanceOf(TestDtoOneToMany3Nivel.class);
            assertThat(resultadoCargue.getElementosCargados()).extracting("testHijoOneToManies").hasSize(3);
            assertThat(resultadoCargue.getErroresEcontrados()).hasSize(0);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

    }

    @Test
    public void probarCargaExitosaEstructuraOneToMany3NivelesBigData() {
        try {
            // Dado

            byte[] archivo = crearArchivoOneToMany3NivelesExitosoGrande();

            // Cuando
            ConversorArchivos<TestDtoOneToMany3Nivel> csv = new ConversorArchivos<TestDtoOneToMany3Nivel>();
            ResultadoCargue<TestDtoOneToMany3Nivel> resultadoCargue = csv.ejecutar(TestDtoOneToMany3Nivel.class, archivo, TiposArchivo.CSV);

            // Entonces
            assertThat(resultadoCargue.getElementosCargados()).hasSize(40002).isInstanceOf(ArrayList.class).extracting("codigoEPS").contains("EPS005");
            assertThat(resultadoCargue.getElementosCargados().get(0)).isInstanceOf(TestDtoOneToMany3Nivel.class);
            assertThat(resultadoCargue.getErroresEcontrados()).hasSize(0);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

    }

    @Test
    public void probarCargaErrorCampoRequerido() {
        try {
            // Dado

            byte[] archivo = crearArchivoErrorRequerido();

            // Cuando
            ConversorArchivos<TestDtoBasicoRequerido> csv = new ConversorArchivos<TestDtoBasicoRequerido>();
            ResultadoCargue<TestDtoBasicoRequerido> resultadoCargue = csv.ejecutar(TestDtoBasicoRequerido.class, archivo, TiposArchivo.CSV);

            // Entonces
            assertThat(resultadoCargue.getElementosCargados()).hasSize(3).isInstanceOf(ArrayList.class).extracting("codigoEPS").contains("EPS005");
            assertThat(resultadoCargue.getErroresEcontrados()).hasSize(2);
            assertThat(resultadoCargue.getErroresEcontrados().get(0).getFila()).isEqualTo(2);
            assertThat(resultadoCargue.getErroresEcontrados().get(0).getCausa()).isEqualTo("El valor del campo  es requerido");
            assertThat(resultadoCargue.getErroresEcontrados().get(0).getLinea()).isEqualTo(0);
            assertThat(resultadoCargue.getErroresEcontrados().get(0).getValor()).isEqualTo(null);
            assertThat(resultadoCargue.getErroresEcontrados().get(1).getFila()).isEqualTo(3);
            assertThat(resultadoCargue.getErroresEcontrados().get(1).getCausa()).isEqualTo("El valor del campo  es requerido");
            assertThat(resultadoCargue.getErroresEcontrados().get(1).getLinea()).isEqualTo(0);
            assertThat(resultadoCargue.getErroresEcontrados().get(1).getValor()).isEqualTo(null);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

    }

    @Test
    public void probarCargaErrorCampoRequeridoMultipleEstructura() {
        try {
            // Dado

            byte[] archivo = crearArchivoOneToManyErrorRequerido();

            // Cuando
            ConversorArchivos<TestDtoOneToManyRequerido> csv = new ConversorArchivos<TestDtoOneToManyRequerido>();
            ResultadoCargue<TestDtoOneToManyRequerido> resultadoCargue = csv.ejecutar(TestDtoOneToManyRequerido.class, archivo, TiposArchivo.CSV);

            // Entonces
            assertThat(resultadoCargue.getElementosCargados()).hasSize(3).isInstanceOf(ArrayList.class).extracting("codigoEPS").contains("EPS005");
            assertThat(resultadoCargue.getErroresEcontrados()).hasSize(2);
            assertThat(resultadoCargue.getErroresEcontrados().get(0).getFila()).isEqualTo(2);
            assertThat(resultadoCargue.getErroresEcontrados().get(0).getCausa()).isEqualTo("El valor del campo  es requerido");
            assertThat(resultadoCargue.getErroresEcontrados().get(0).getLinea()).isEqualTo(0);
            assertThat(resultadoCargue.getErroresEcontrados().get(0).getValor()).isEqualTo(null);
            assertThat(resultadoCargue.getErroresEcontrados().get(1).getFila()).isEqualTo(3);
            assertThat(resultadoCargue.getErroresEcontrados().get(1).getCausa()).isEqualTo("El valor del campo  es requerido");
            assertThat(resultadoCargue.getErroresEcontrados().get(1).getLinea()).isEqualTo(0);
            assertThat(resultadoCargue.getErroresEcontrados().get(1).getValor()).isEqualTo(null);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

    }

    private byte[] crearArchivoOneToManyErrorRequerido() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1|EPS005|1890-02-27|2015-03-20|3\n");
        stringBuilder.append("2|1|1969-05-08|6\n");
        stringBuilder.append("2||1969-05-08|6\n");
        stringBuilder.append("2|45|1969-05-08|6\n");
        stringBuilder.append("1|EPS006|1890-02-27|2015-03-20|\n");
        stringBuilder.append("2|1|1969-05-08|6\n");
        stringBuilder.append("2||1969-05-08|6\n");
        return stringBuilder.toString().getBytes();
    }

    private byte[] crearArchivoErrorRequerido() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EPS005|2000-03-27|2015-03-31|1\n");
        stringBuilder.append("|2000-03-27|2015-03-31|1\n");
        stringBuilder.append("|2000-03-27|2015-03-31|1\n");
        return stringBuilder.toString().getBytes();
    }

    private byte[] crearArchivoOneToMany3NivelesExitosoGrande() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1|EPS005|1890-02-27|2015-03-20|3\n");
        stringBuilder.append("2|1|1969-05-08|6\n");
        for (int i = 0; i < 20000; i++) {
            stringBuilder.append("3|"+i+"|1969-05-08\n");
        }
        for (int i = 0; i < 10000; i++) {
            stringBuilder.append("2|"+i+"|1969-05-08|6\n");
            stringBuilder.append("3|"+i+"|1969-05-08\n");
        }
        stringBuilder.append("3|1|1969-05-08\n");
        stringBuilder.append("2|1|1969-05-08|6\n");
        stringBuilder.append("3|1|1969-05-08\n");
        stringBuilder.append("3|1|1969-05-08\n");
        stringBuilder.append("3|1|1969-05-08\n");
        stringBuilder.append("1|EPS005|1890-02-27|2015-03-20|2\n");
        stringBuilder.append("2|1|1969-05-08|6\n");
        stringBuilder.append("3|1|1969-05-08\n");
        stringBuilder.append("3|1|1969-05-08\n");
        stringBuilder.append("3|1|2015-05-08\n");
        for (int i = 0; i < 40000; i++){
            stringBuilder.append("1|EPS005|1890-02-27|2015-03-20|3\n");
            stringBuilder.append("2|1|1969-05-08|6\n");
            stringBuilder.append("3|1|2015-05-08\n");
            stringBuilder.append("2|1|1969-05-08|6\n");
            stringBuilder.append("2|1|1969-05-08|6\n");
            stringBuilder.append("3|1|2015-05-08\n");
            stringBuilder.append("3|1|2015-05-08\n");
        }

        return stringBuilder.toString().getBytes();
    }

    private byte[] crearArchivoOneToMany3NivelesExitoso() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1|EPS005|1890-02-27|2015-03-20|3\n");
        stringBuilder.append("2|1|1969-05-08|6\n");
        stringBuilder.append("3|1|1969-05-08\n");
        stringBuilder.append("2|1|1969-05-08|6\n");
        stringBuilder.append("3|1|1969-05-08\n");
        stringBuilder.append("2|1|1969-05-08|6\n");
        stringBuilder.append("3|1|1969-05-08\n");
        stringBuilder.append("3|1|1969-05-08\n");
        stringBuilder.append("3|1|1969-05-08\n");
        stringBuilder.append("1|EPS005|1890-02-27|2015-03-20|2\n");
        stringBuilder.append("2|1|1969-05-08|6\n");
        stringBuilder.append("3|1|1969-05-08\n");
        stringBuilder.append("3|1|1969-05-08\n");
        stringBuilder.append("3|1|2015-05-08\n");
        stringBuilder.append("1|EPS005|1890-02-27|2015-03-20|3\n");
        stringBuilder.append("2|1|1969-05-08|6\n");
        stringBuilder.append("2|1|1969-05-08|6\n");
        stringBuilder.append("2|1|1969-05-08|6\n");
        stringBuilder.append("3|1|2015-05-08\n");

        return stringBuilder.toString().getBytes();

    }

    private byte[] crearArchivoOneToManyExitosoGrande() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1|EPS005|1890-02-27|2015-03-20|3\n");
        for (int i = 0; i < 80000; i++) {
            stringBuilder.append("2|"+i+"|1969-05-08|6\n");
        }
        stringBuilder.append("1|EPS006|1890-02-27|2015-03-20|3\n");
        for (int i = 0; i < 10000; i++) {
            stringBuilder.append("2|"+i+"|1969-05-08|6\n");
        }
        return stringBuilder.toString().getBytes();

    }

    private byte[] crearArchivoOneToManyExitoso() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1|EPS005|1890-02-27|2015-03-20|3\n");
        stringBuilder.append("2|1|1969-05-08|6\n");
        stringBuilder.append("2|1|1969-05-08|6\n");
        stringBuilder.append("2|1|1969-05-08|6\n");
        stringBuilder.append("1|EPS006|1890-02-27|2015-03-20|3\n");
        stringBuilder.append("2|1|1969-05-08|6\n");
        stringBuilder.append("2|1|1969-05-08|6\n");
        return stringBuilder.toString().getBytes();
    }

    private byte[] crearArchivoOneToOneExitosoGrande() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 80000; i++) {
            stringBuilder.append(i + "|EPS005|2000-03-27|2015-03-31|" + i + "\n");
        }
        return stringBuilder.toString().getBytes();
    }

    private byte[] crearArchivoOneToOneExitoso() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1|EPS005|2000-03-27|2015-03-31|1\n");
        stringBuilder.append("1|EPS005|2000-03-27|2015-03-31|1\n");
        stringBuilder.append("1|EPS005|2000-03-27|2015-03-31|1\n");
        return stringBuilder.toString().getBytes();
    }

    private byte[] crearArchivoBasicoExitoso() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EPS005|2000-03-27|2015-03-31|1\n");
        stringBuilder.append("EPS005|2000-03-27|2015-03-31|1\n");
        stringBuilder.append("EPS005|2000-03-27|2015-03-31|1\n");
        return stringBuilder.toString().getBytes();
    }

    private byte[] crearArchivoBasicoExitosoGigante() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 80000; i++) {
            stringBuilder.append("EPS005|2000-03-27|2015-03-31|" + i + "\n");
        }
        return stringBuilder.toString().getBytes();
    }


}
