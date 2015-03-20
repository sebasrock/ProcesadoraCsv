package co.bassan.lectora.anotaciones;

import co.bassan.lectora.interfaces.ConvertidorInterfaz;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Sebastian Sanchez on 06/02/2015.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DatosCampo {

    /**
     * Indicates if the value should be trimmed
     */
    boolean trim() default false;

    /**
     * Name of the field (optional)
     */
    String nombre() default "";

    /**
     * Position of the field in the message generated (should start from 1)
     */
    int posicion() default 0;


    Class<? extends ConvertidorInterfaz> convercionClass() default ConvertidorInterfaz.class;
}
