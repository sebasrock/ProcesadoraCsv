package co.bassan.general.model;

/**
 * Created by Sebastian Sanchez on 09/02/2015.
 */
public class ErrorCampo {

    private int linea;
    private int fila;
    private String causa;
    private Object valor;

    public ErrorCampo(int fila, int linea, String causa, Object valor) {
        this.linea = linea;
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
        this.linea = linea;
    }

    public ErrorCampo(String causa, String valor, int fila, int linea) {
        this.linea = linea;
        this.fila = fila;
        this.causa = causa;
        this.valor = valor;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
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
        return "ErrorCampo{" +
                "linea=" + linea +
                ", fila=" + fila +
                ", causa='" + causa + '\'' +
                ", valor=" + valor +
                '}';
    }
}
