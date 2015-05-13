package co.bassan.procesadoraCsv.DTOTest;

import co.bassan.lectora.anotaciones.DatosArchivo;
import co.bassan.lectora.anotaciones.DatosCampo;
import co.bassan.lectora.anotaciones.OneToOne;
import co.bassan.lectora.anotaciones.ValidarCampo;

/**
 * Dto que se utilizará para almacenar las variables del archivo a procesar.
 * <p/>
 * Created by pbastidas on 4/19/15.
 */
@DatosArchivo(saltarPrimeraLinea = false, separador = "|",cantidadRegistros = 128,multiEstructura = true)
public class ConsolidadoDto {


    @DatosCampo(posicion = 0, trim = true)
    @ValidarCampo(requirido = true)
    private String consecutivo_1;

    @DatosCampo(posicion = 1, trim = true)
    @ValidarCampo(requirido = true)
    private String codigoHabilitacionIps_2;

    @OneToOne
    private PersonaDto personaDto;

    @OneToOne
    private VariablesControlDto variablesControlDto;



    public ConsolidadoDto() {
    }

//    public String getTipoRegitro_0() {
//        return tipoRegitro_0;
//    }
//
//    public void setTipoRegitro_0(String tipoRegitro_0) {
//        this.tipoRegitro_0 = tipoRegitro_0;
//    }

    public String getConsecutivo_1() {
        return consecutivo_1;
    }

    public void setConsecutivo_1(String consecutivo_1) {
        this.consecutivo_1 = consecutivo_1;
    }

    public String getCodigoHabilitacionIps_2() {
        return codigoHabilitacionIps_2;
    }

    public void setCodigoHabilitacionIps_2(String codigoHabilitacionIps_2) {
        this.codigoHabilitacionIps_2 = codigoHabilitacionIps_2;
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

    @Override
    public String toString() {
        return "ConsolidadoDto{" +
//            "tipoRegitro_0='" + tipoRegitro_0 + '\'' +
            ", consecutivo_1='" + consecutivo_1 + '\'' +
            ", codigoHabilitacionIps_2='" + codigoHabilitacionIps_2 + '\'' +
            ", personaDto=" + personaDto +
            ", variablesControlDto=" + variablesControlDto +
            '}';
    }
}
