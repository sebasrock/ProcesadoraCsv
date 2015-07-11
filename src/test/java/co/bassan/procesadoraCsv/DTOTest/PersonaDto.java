package co.bassan.procesadoraCsv.DTOTest;

import co.bassan.lectora.anotaciones.DatosCampo;
import co.bassan.lectora.anotaciones.ValidarCampo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by sebas on 19/04/15.
 */
public class PersonaDto implements Serializable {

    @DatosCampo(posicion = 2)
    @ValidarCampo(requirido = true)
    private String tipoIdentificacion_3;
    @DatosCampo(posicion = 3)
    @ValidarCampo(requirido = true)
    private String numeroIdentificacion_4;
    @DatosCampo(posicion = 4)
    @ValidarCampo(requirido = true)
    private String primerApellido_5;
    @DatosCampo(posicion = 5)
    @ValidarCampo(requirido = true)
    private String segundoApellido_6;
    @DatosCampo(posicion = 6)
    @ValidarCampo(requirido = true)
    private String primerNombre_7;
    @DatosCampo(posicion = 7)
    @ValidarCampo(requirido = true)
    private String segundoNombre_8;
    @DatosCampo(posicion = 8)
    @ValidarCampo(requirido = true,formatoFecha ="yyyy-MM-dd" )
    private Date fechaNacimiento_9;
    @DatosCampo(posicion = 9)
    @ValidarCampo(requirido = true)
    private String sexo_10;
    @DatosCampo(posicion =10)
    @ValidarCampo(requirido = true)
    private String perteneciaEtnica_11;
    @DatosCampo(posicion = 11)
    @ValidarCampo(requirido = true)
    private String ocupacion_12;
    @DatosCampo(posicion = 12)
    @ValidarCampo(requirido = true)
    private String nivelEducativo_13;

    public String getTipoIdentificacion_3() {
        return tipoIdentificacion_3;
    }

    public void setTipoIdentificacion_3(String tipoIdentificacion_3) {
        this.tipoIdentificacion_3 = tipoIdentificacion_3;
    }

    public String getNumeroIdentificacion_4() {
        return numeroIdentificacion_4;
    }

    public void setNumeroIdentificacion_4(String numeroIdentificacion_4) {
        this.numeroIdentificacion_4 = numeroIdentificacion_4;
    }

    public String getPrimerApellido_5() {
        return primerApellido_5;
    }

    public void setPrimerApellido_5(String primerApellido_5) {
        this.primerApellido_5 = primerApellido_5;
    }

    public String getSegundoApellido_6() {
        return segundoApellido_6;
    }

    public void setSegundoApellido_6(String segundoApellido_6) {
        this.segundoApellido_6 = segundoApellido_6;
    }

    public String getPrimerNombre_7() {
        return primerNombre_7;
    }

    public void setPrimerNombre_7(String primerNombre_7) {
        this.primerNombre_7 = primerNombre_7;
    }

    public String getSegundoNombre_8() {
        return segundoNombre_8;
    }

    public void setSegundoNombre_8(String segundoNombre_8) {
        this.segundoNombre_8 = segundoNombre_8;
    }

    public Date getFechaNacimiento_9() {
        return fechaNacimiento_9;
    }

    public void setFechaNacimiento_9(Date fechaNacimiento_9) {
        this.fechaNacimiento_9 = fechaNacimiento_9;
    }

    public String getSexo_10() {
        return sexo_10;
    }

    public void setSexo_10(String sexo_10) {
        this.sexo_10 = sexo_10;
    }

    public String getPerteneciaEtnica_11() {
        return perteneciaEtnica_11;
    }

    public void setPerteneciaEtnica_11(String perteneciaEtnica_11) {
        this.perteneciaEtnica_11 = perteneciaEtnica_11;
    }

    public String getOcupacion_12() {
        return ocupacion_12;
    }

    public void setOcupacion_12(String ocupacion_12) {
        this.ocupacion_12 = ocupacion_12;
    }

    public String getNivelEducativo_13() {
        return nivelEducativo_13;
    }

    public void setNivelEducativo_13(String nivelEducativo_13) {
        this.nivelEducativo_13 = nivelEducativo_13;
    }

    @Override
    public String toString() {
        return "PersonaDto{" +
            "tipoIdentificacion_3='" + tipoIdentificacion_3 + '\'' +
            ", numeroIdentificacion_4='" + numeroIdentificacion_4 + '\'' +
            ", primerApellido_5='" + primerApellido_5 + '\'' +
            ", segundoApellido_6='" + segundoApellido_6 + '\'' +
            ", primerNombre_7='" + primerNombre_7 + '\'' +
            ", segundoNombre_8='" + segundoNombre_8 + '\'' +
            ", fechaNacimiento_9='" + fechaNacimiento_9 + '\'' +
            ", sexo_10='" + sexo_10 + '\'' +
            ", perteneciaEtnica_11='" + perteneciaEtnica_11 + '\'' +
            ", ocupacion_12='" + ocupacion_12 + '\'' +
            ", nivelEducativo_13='" + nivelEducativo_13 + '\'' +
            '}';
    }
}
