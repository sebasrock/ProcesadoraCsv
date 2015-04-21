package co.bassan.lectora.anotaciones;

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


    String nombre() default "";
    String separador();
    int cantidadRegistros();
    boolean saltarPrimeraLinea() default false;

    boolean multiEstructura() default false;
}
