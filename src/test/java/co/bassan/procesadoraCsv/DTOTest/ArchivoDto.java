package co.bassan.procesadoraCsv.DTOTest;

import co.bassan.lectora.anotaciones.DatosArchivo;
import co.bassan.lectora.anotaciones.OneToMany;
import co.bassan.lectora.anotaciones.OneToOne;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sebas on 24/04/15.
 */
@DatosArchivo(saltarPrimeraLinea = false, separador = "|",cantidadRegistros = 4,multiEstructura = true)
public class ArchivoDto implements Serializable {

    @OneToOne
    private RegistroControlDto registroControl;
    @OneToMany(palabraResevada = "2")
    private List<ConsolidadoDto> litaConsolidado;


    public RegistroControlDto getRegistroControl() {
        return registroControl;
    }

    public void setRegistroControl(RegistroControlDto registroControl) {
        this.registroControl = registroControl;
    }

    public List<ConsolidadoDto> getLitaConsolidado() {
        return litaConsolidado;
    }

    public void setLitaConsolidado(List<ConsolidadoDto> litaConsolidado) {
        this.litaConsolidado = litaConsolidado;
    }
}
