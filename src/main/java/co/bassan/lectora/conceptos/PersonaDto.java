package co.bassan.lectora.conceptos;

import co.bassan.lectora.anotaciones.DatosCampo;
import co.bassan.lectora.anotaciones.ValidarCampo;

import java.io.Serializable;

/**
 * Created by sebas on 19/04/15.
 */
public class PersonaDto implements Serializable {

    @DatosCampo(posicion = 3)
    @ValidarCampo(requirido = true)
    private String tipoIdentificacion;
    @DatosCampo(posicion = 4)
    @ValidarCampo(requirido = true)
    private String numeroIdentificacion;
    @DatosCampo(posicion = 5)
    @ValidarCampo(requirido = true)
    private String primerApellido;
    @DatosCampo(posicion = 6)
    @ValidarCampo(requirido = true)
    private String segundoApellido;
    @DatosCampo(posicion = 7)
    @ValidarCampo(requirido = true)
    private String primerNombre;
    @DatosCampo(posicion = 8)
    @ValidarCampo(requirido = true)
    private String segundoNombre;
    @DatosCampo(posicion = 9)
    @ValidarCampo(requirido = true)
    private String fechaNacimiento;
    @DatosCampo(posicion = 10)
    @ValidarCampo(requirido = true)
    private String sexo;
    @DatosCampo(posicion =11)
    @ValidarCampo(requirido = true)
    private String perteneciaEtnica;
    @DatosCampo(posicion = 12)
    @ValidarCampo(requirido = true)
    private String ocupacion;
    @DatosCampo(posicion = 13)
    @ValidarCampo(requirido = true)
    private String nivelEducativo;



    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPerteneciaEtnica() {
        return perteneciaEtnica;
    }

    public void setPerteneciaEtnica(String perteneciaEtnica) {
        this.perteneciaEtnica = perteneciaEtnica;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(String nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    @Override
    public String toString() {
        return "PersonaDto{" +
                "tipoIdentificacion='" + tipoIdentificacion + '\'' +
                ", numeroIdentificacion='" + numeroIdentificacion + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", primerNombre='" + primerNombre + '\'' +
                ", segundoNombre='" + segundoNombre + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", sexo='" + sexo + '\'' +
                ", perteneciaEtnica='" + perteneciaEtnica + '\'' +
                ", ocupacion='" + ocupacion + '\'' +
                ", nivelEducativo='" + nivelEducativo + '\'' +
                '}';
    }
}
