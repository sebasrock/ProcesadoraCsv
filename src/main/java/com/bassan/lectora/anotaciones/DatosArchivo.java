package com.bassan.lectora.anotaciones;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Sebastian Sanchez on 06/02/2015.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DatosArchivo {

    /**
     * Name describing the record (optional)
     */
    String nombre() default "";

    /**
     * Separator used to split a record in tokens (mandatory)
     */
    String separador();

    /**
     * The skipFirstLine parameter will allow to skip or not the first line of a
     * CSV file. This line often contains columns definition
     */
    boolean saltarPrimeraLinea() default false;
}
