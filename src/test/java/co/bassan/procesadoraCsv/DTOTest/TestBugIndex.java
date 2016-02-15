package co.bassan.procesadoraCsv.DTOTest;

import co.bassan.anotaciones.DatosArchivo;
import co.bassan.anotaciones.DatosCampo;
import co.bassan.anotaciones.ValidarCampo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Created by ssanchez on 13/02/16.
 */
@DatosArchivo(cantidadColumnas = 6,saltarPrimeraLinea = true)
public class TestBugIndex implements Serializable {


    @DatosCampo(posicion = 3,trim = true)
    @ValidarCampo(requirido = true)
    private String firstName;
    @DatosCampo(posicion = 2,trim = true)
    @ValidarCampo(requirido = true)
    private String lastName;
    @DatosCampo(posicion = 4)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd",fechaMinima = "1900-01-01")
    private Date birthDate;
    @DatosCampo(posicion = 0,trim = true)
    @ValidarCampo(listaLimitante = {"RC","TI","CE","CC","PA","MS","AS","CD","NV"},requirido = true)
    private String kindIdentityDoc;
    @DatosCampo(posicion = 1,trim = true)
    @ValidarCampo(requirido = true)
    private String documentNumber;
    @DatosCampo(posicion = 5,trim = true)
    //@ValidarCampo(listaLimitante = {"M","F"},requirido = true)
    @ValidarCampo(requirido = true)
    private String sex;

    public TestBugIndex() {
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getKindIdentityDoc() {
        return kindIdentityDoc;
    }

    public void setKindIdentityDoc(String kindIdentityDoc) {
        this.kindIdentityDoc = kindIdentityDoc;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestBugIndex that = (TestBugIndex) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(kindIdentityDoc, that.kindIdentityDoc) &&
                Objects.equals(documentNumber, that.documentNumber) &&
                Objects.equals(sex, that.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDate, kindIdentityDoc, documentNumber, sex);
    }

    @Override
    public String toString() {
        return " INFORMACION " +
                "  PRIMER NOMBRE    ='" + firstName + '\'' +
                ", PRIMER APELLIDO  ='" + lastName + '\'' +
                ", FECHA NACIMIENTO =" + new SimpleDateFormat("yyyy-MM-dd").format(birthDate) +
                ", TIPO DOCUMENTO  ='" + kindIdentityDoc + '\'' +
                ", NUMERO DOCUMENTO   = '" + documentNumber + '\'' +
                ", SEXO='" + sex + '\'';
    }
}
