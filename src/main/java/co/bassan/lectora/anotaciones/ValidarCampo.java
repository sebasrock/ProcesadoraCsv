package co.bassan.lectora.anotaciones;

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
     * Pattern that the formatter will use to transform the data (optional)
     */
    String exprecion() default "";

    /**
     * Length of the data block if the record is set to a fixed length
     */
    int longitudMaxima() default 0;

    int longitudMinima() default 0;

    /**
     * Indicates if the field is mandatory
     */
    boolean requirido() default false;

    String[] listaLimitante() default {};

    String fromatoFecha() default "yyyy-MM-dd";

    /**
     * Field's default value in case no value is set
     */
    String defaultValue() default "";


}
