package co.bassan.general.util;

/**
 * Created by Sebastian Sanchez on 12/02/2015.
 */
public interface ConversionPersonal<T> {

    T stringToObjeto(String valor);

    String objetoToString(T Objeto);
}
