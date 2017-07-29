package co.bassan.general.model;

/**
 * Created by Sebastian Sanchez on 09/02/2015.
 */
public class ErrorCampo {

    private int columna;
    private int fila;
    private String causa;
    private Object valor;

    public ErrorCampo(int fila, int columna, String causa, Object valor) {
        this.columna = columna;
        this.fila = fila;
        this.causa = causa;
        this.valor = valor;
    }

    public ErrorCampo(String causa, Object valor, int fila) {
        this.causa = causa;
        this.valor = valor;
        this.fila = fila;
    }

    public ErrorCampo(String causa, Object valor, int fila, int linea) {
        this.causa = causa;
        this.valor = valor;
        this.fila = fila;
        this.columna = linea;
    }

    public ErrorCampo(String causa, String valor, int fila, int linea) {
        this.columna = linea;
        this.fila = fila;
        this.causa = causa;
        this.valor = valor;
    }

    public int getLinea() {
        return columna;
    }

    public void setLinea(int linea) {
        this.columna = linea;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Error en la estructura " +
                " Columna = " + columna +
                ", Fila = " + fila +
                ", Causa =' " + causa + '\'' +
                ", Valor campo = " + valor ;
    }
}
