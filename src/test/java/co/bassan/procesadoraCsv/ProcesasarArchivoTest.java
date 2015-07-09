package co.bassan.procesadoraCsv;

import co.bassan.lectora.core.ProcesadorCsv;
import co.bassan.lectora.model.ResultadoCargue;
import co.bassan.procesadoraCsv.DTOTest.ArchivoDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by sebas on 12/05/15.
 */
public class ProcesasarArchivoTest {

    private static final String PATH_FILE = "/home/sebas/Documentos/SGD280RPED20WW0228NI000900058443C.txt";




    @Test
    public void probarCargaRegistroControlExitosa(){
        try {
            // Dado
            ProcesadorCsv<ArchivoDto> csv = new ProcesadorCsv<ArchivoDto>();

            // Cuando
            ResultadoCargue<ArchivoDto> resultadoCargue = csv.transformarCsvObjeto(ArchivoDto.class, PATH_FILE);

            // Entonces
            assertThat(resultadoCargue.getElementosCargados()).hasSize(1).isInstanceOf(ArrayList.class).extracting("registroControl").extracting("codigoEPS").contains("EPS005");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

    }

    @Test
    public void probarCargaConsolidadoExitosa(){
        try {
            // Dado
            ProcesadorCsv<ArchivoDto> csv = new ProcesadorCsv<ArchivoDto>();

            // Cuando
            ResultadoCargue<ArchivoDto> resultadoCargue = csv.transformarCsvObjeto(ArchivoDto.class, PATH_FILE);

            // Entonces
            assertThat(resultadoCargue.getElementosCargados()).hasSize(1).isInstanceOf(ArrayList.class).extracting("litaConsolidado").hasSize(1);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

    }

    @Test
    public void probarCargaRegistroControlErrorFecha(){
        try {
            // Dado
            ProcesadorCsv<ArchivoDto> csv = new ProcesadorCsv<ArchivoDto>();

            // Cuando
            ResultadoCargue<ArchivoDto> resultadoCargue = csv.transformarCsvObjeto(ArchivoDto.class, PATH_FILE);

            // Entonces
            assertThat(resultadoCargue.getElementosCargados().get(0).getRegistroControl().getFechaInicialPeriodoReportado()).isEqualTo(new Date("2015/02/27"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void probarCargaConsolidadoExitosaFechas(){
        try {
            // Dado
            ProcesadorCsv<ArchivoDto> csv = new ProcesadorCsv<ArchivoDto>();

            // Cuando
            ResultadoCargue<ArchivoDto> resultadoCargue = csv.transformarCsvObjeto(ArchivoDto.class, PATH_FILE);

            // Entonces
            assertThat(resultadoCargue.getElementosCargados().get(0).getRegistroControl().getFechaFinalPeriodoReportado()).isNull();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }


    }


}
