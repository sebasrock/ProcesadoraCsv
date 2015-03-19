package com.bassan.lectora.interfaces;

/**
 * Created by Sebastian Sanchez on 12/02/2015.
 */
public interface ConvertidorInterfaz<T> {

    public T stringToObjeto(String valor);

    public String objetoToString(T Objeto);
}
