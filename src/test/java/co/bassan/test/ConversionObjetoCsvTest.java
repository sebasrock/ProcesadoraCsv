package co.bassan.test;

import co.bassan.conversor.ConversorArchivos;
import co.bassan.conversor.ConversorObjetos;
import co.bassan.general.constantes.TiposArchivo;
import co.bassan.general.model.ResultadoCargue;
import co.bassan.procesadoraCsv.DTOTest.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by sebas on 14/08/15.
 */
public class ConversionObjetoCsvTest {

    @Test
    public void probarCargaExitosaEstructuraBasica() {
        try {
            // Dado

            List<TestDtoBasicoEscritura> archivo = crearArchivoBasicoExitoso();

            // Cuando
            ConversorObjetos<TestDtoBasicoEscritura> csv = new ConversorObjetos<TestDtoBasicoEscritura>();
            ByteArrayOutputStream resultadoCargue = csv.ejecutar(archivo, TiposArchivo.CSV);

            // Entonces
            assertThat(resultadoCargue).isNotNull();
            assertThat(resultadoCargue.toString()).containsSequence("codigoEPS|fechaInicialPeriodoReportado|fechaFinalPeriodoReportado|numeroRegistroArchivo");
            assertThat(resultadoCargue.toString()).containsSequence("QAZ!|2015-08-19|2015-08-19|10000");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

    }

    private List<TestDtoBasicoEscritura> crearArchivoBasicoExitoso() {
        List<TestDtoBasicoEscritura> lista = new ArrayList<>(80000);
        for (int i = 0; i < 100; i++) {
            TestDtoBasicoEscritura test = new TestDtoBasicoEscritura();
            test.setCodigoEPS("QAZ!");
            test.setFechaFinalPeriodoReportado(new Date());
            test.setFechaInicialPeriodoReportado(new Date());
            test.setNumeroRegistroArchivo(10000);
            lista.add(test);
        }
        return lista;
    }


}
