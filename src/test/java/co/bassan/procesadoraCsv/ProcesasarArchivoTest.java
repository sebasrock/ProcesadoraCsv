package co.bassan.procesadoraCsv;

import co.bassan.lectora.core.ProcesadorCsv;
import co.bassan.lectora.model.ResultadoCargue;
import co.bassan.procesadoraCsv.DTOTest.ArchivoDto;
import co.bassan.procesadoraCsv.DTOTest.ConsolidadoDto;
import co.bassan.procesadoraCsv.DTOTest.RegistroControlDto;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by sebas on 12/05/15.
 */
public class ProcesasarArchivoTest {

    private static final String PATH_FILE = "/home/sebas/Documentos/Proyectos/CIRCULAR4504/DOCUMENTOS/RECIVIDOS/requerimientos4505_128.csv";




    @Test
    public void probarCargaExitosa(){
        try {
            // Dado
            ProcesadorCsv<ArchivoDto> csv = new ProcesadorCsv<ArchivoDto>();

            // Cuando
            ResultadoCargue<ArchivoDto> resultadoCargue = csv.transformarCsvObjeto(ArchivoDto.class, PATH_FILE);

            // Entonces
            assertThat(resultadoCargue.getElementosCargados()).hasSize(1);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

    }


}
