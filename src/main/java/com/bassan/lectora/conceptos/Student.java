package com.bassan.lectora.conceptos;

import com.bassan.lectora.anotaciones.DatosArchivo;
import com.bassan.lectora.anotaciones.DatosCampo;
import com.bassan.lectora.anotaciones.ValidarCampo;

import java.util.Date;

/**
 * sebas
 */
@DatosArchivo(separador = "|")
public class Student {

    @DatosCampo(posicion = 0, nombre = "0", trim = true)
    @ValidarCampo(requirido = true)
    private String codigo;
    @DatosCampo(posicion = 3, nombre = "1", trim = true)
    @ValidarCampo(requirido = true)
    private String name;
    @DatosCampo(posicion = 2, nombre = "2", trim = true)
    @ValidarCampo(requirido = true ,listaLimitante = {"UNO","DOS"})
    private String semester;
    @DatosCampo(posicion = 3, nombre = "3", trim = true)
    @ValidarCampo(requirido = true,fromatoFecha = "dd-MM-YYYY")
    private Date javaMarks;
    @DatosCampo(posicion = 4, nombre = "4", trim = true)
    @ValidarCampo(requirido = true)
    private long cMarks;
    @DatosCampo(posicion = 5, nombre = "5", trim = true)
    @ValidarCampo(requirido = true)
    private Short dbmsMarks;
    @DatosCampo(posicion = 6, nombre = "6", trim = true)
    @ValidarCampo(requirido = true)
    private short mathematicsMarks;
    @DatosCampo(posicion = 7, nombre = "7", trim = true)
    @ValidarCampo(requirido = true)
    private int dataStructureMarks;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Date getJavaMarks() {
        return javaMarks;
    }

    public void setJavaMarks(Date javaMarks) {
        this.javaMarks = javaMarks;
    }

    public long getCMarks() {
        return cMarks;
    }

    public void setCMarks(long cMarks) {
        this.cMarks = cMarks;
    }

    public Short getDbmsMarks() {
        return dbmsMarks;
    }

    public void setDbmsMarks(Short dbmsMarks) {
        this.dbmsMarks = dbmsMarks;
    }

    public short getMathematicsMarks() {
        return mathematicsMarks;
    }

    public void setMathematicsMarks(short mathematicsMarks) {
        this.mathematicsMarks = mathematicsMarks;
    }

    public int getDataStructureMarks() {
        return dataStructureMarks;
    }

    public void setDataStructureMarks(int dataStructureMarks) {
        this.dataStructureMarks = dataStructureMarks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "codigo='" + codigo + '\'' +
                ", name='" + name + '\'' +
                ", semester='" + semester + '\'' +
                ", javaMarks=" + javaMarks +
                ", cMarks=" + cMarks +
                ", dbmsMarks=" + dbmsMarks +
                ", mathematicsMarks=" + mathematicsMarks +
                ", dataStructureMarks=" + dataStructureMarks +
                '}';
    }
}