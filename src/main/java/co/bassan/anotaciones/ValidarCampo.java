package co.bassan.anotaciones;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Sebastian Sanchez on 06/02/2015.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ValidarCampo {

    /**
     * exprecion regular que debe cumplir el campo
     *
     * @return
     */
    String exprecion() default "";

    /**
     * Longitud maxima permitida para este campo
     *
     * @return
     */
    int longitudMaxima() default 0;

    /**
     * Longitud minima permitida para este campo
     *
     * @return
     */
    int longitudMinima() default 0;

    /**
     * Indica si el campo es obligatorio
     *
     * @return
     */
    boolean requirido() default false;

    /**
     * verifica que tenga valores prmitidos determinados
     *
     * @return
     */
    String[] listaLimitante() default {};


    /**
     * valida el formato de fecha
     *
     * @return
     */
    String formatoFecha() default "yyyy-MM-dd";

    /**
     * valida la fecha minima que puede ser ingresada
     *
     * @return
     */
    String fechaMinima() default "";

    /**
     * valida la fecha maxima que puede ser ingresada
     *
     * @return
     */
    String fechaMaxima() default "";


    /**
     * Field's default value in case no value is set
     */
    String defaultValue() default "";


}
