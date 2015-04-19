package co.bassan.lectora.conceptos;

import co.bassan.lectora.anotaciones.DatosArchivo;
import co.bassan.lectora.anotaciones.DatosCampo;
import co.bassan.lectora.anotaciones.OneToOne;
import co.bassan.lectora.anotaciones.ValidarCampo;

/**
 * Dto que se utilizará para almacenar las variables del archivo a procesar.
 * <p/>
 * Created by pbastidas on 4/19/15.
 */
@DatosArchivo(saltarPrimeraLinea = true, separador = ",")
public class ConsolidadoDto {

    @DatosCampo(posicion = 0, trim = true)
    @ValidarCampo(requirido = true)
    private String tipoRegitro;
    @DatosCampo(posicion = 1, trim = true)
    @ValidarCampo(requirido = true)
    private String consecutivo;

    @DatosCampo(posicion = 2, trim = true)
    @ValidarCampo(requirido = true)
    private String codigoHabilitacionIps;

    @OneToOne
    private PersonaDto personaDto;

    @OneToOne
    private VariablesControlDto variablesControlDto;



    public ConsolidadoDto() {
    }

    public String getTipoRegitro() {
        return tipoRegitro;
    }

    public void setTipoRegitro(String tipoRegitro) {
        this.tipoRegitro = tipoRegitro;
    }

    public String getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(String consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getCodigoHabilitacionIps() {
        return codigoHabilitacionIps;
    }

    public void setCodigoHabilitacionIps(String codigoHabilitacionIps) {
        this.codigoHabilitacionIps = codigoHabilitacionIps;
    }

    public PersonaDto getPersonaDto() {
        return personaDto;
    }

    public void setPersonaDto(PersonaDto personaDto) {
        this.personaDto = personaDto;
    }

    public VariablesControlDto getVariablesControlDto() {
        return variablesControlDto;
    }

    public void setVariablesControlDto(VariablesControlDto variablesControlDto) {
        this.variablesControlDto = variablesControlDto;
    }
}
