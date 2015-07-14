package co.bassan.procesadoraCsv;

import co.bassan.lectora.core.ProcesadorCsv;
import co.bassan.lectora.model.ErrorCampo;
import co.bassan.lectora.model.ResultadoCargue;
import co.bassan.procesadoraCsv.DTOTest.ArchivoDto;
import co.bassan.procesadoraCsv.DTOTest.VariablesControlDto;
import co.bassan.procesadoraCsv.DTOTest.VariablesControlDto2;
import org.junit.Assert;
import org.junit.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by sebas on 12/05/15.
 */
public class ProcesasarArchivoTest {

    private static final String PATH_FILE = "/home/sebas/Documentos/SGD280RPED20WW0228NI000900058443C.txt";
    private static final String PATH_FILE2 = "/home/sebas/Documentos/qaz.txt";


    @Test
    public void probarCargaRegistroControlExitosa() {
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
    public void probarCargaConsolidadoExitosa() {
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
    public void probarCargaRegistroControlErrorFecha() {
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
    public void probarCargaConsolidadoExitosaFechas() {
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


    @Test
    public void probarGeneracionArchivoCsv() {
        try {
            // Dado
            PodamFactory factory = new PodamFactoryImpl();
            ProcesadorCsv<VariablesControlDto> csv = new ProcesadorCsv<>();

            List<VariablesControlDto> lista = new ArrayList<>();

            VariablesControlDto myPojo = factory.manufacturePojo(VariablesControlDto.class);
            lista.add(myPojo);
            VariablesControlDto myPojo2 = factory.manufacturePojo(VariablesControlDto.class);
            lista.add(myPojo2);
            VariablesControlDto myPojo3 = factory.manufacturePojo(VariablesControlDto.class);
            lista.add(myPojo3);
            VariablesControlDto myPojo4 = factory.manufacturePojo(VariablesControlDto.class);
            lista.add(myPojo4);

            // Cuando
            ByteArrayOutputStream resultadoCargue = csv.transformarObjetoCsv(lista);

            OutputStream outputStream = new FileOutputStream(PATH_FILE2);
            resultadoCargue.writeTo(outputStream);
//            BufferedOutputStream resultadoCargue = csv.transformarObjetoCsv(lista, PATH_FILE2);

            // Entonces
            assertThat(resultadoCargue).isNotNull();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }


    @Test
    public void probarValidacionDeFechasMiniamasExitosa() {
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
    public void probarValidacionDeFechasMiniamasErronea() {
        try {
            // Dado
            ProcesadorCsv<ArchivoDto> csv = new ProcesadorCsv<ArchivoDto>();

            // Cuando
            ResultadoCargue<ArchivoDto> resultadoCargue = csv.transformarCsvObjeto(ArchivoDto.class, PATH_FILE);

            // Entonces
            assertThat(resultadoCargue.getErroresEcontrados()).extracting("causa").contains("fecha es mayor a la permitida , Fecha maxima :");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }


}
