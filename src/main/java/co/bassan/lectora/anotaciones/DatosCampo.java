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

    boolean trim() default false;
    String nombre() default "";
    int posicion() default 0;
    Class<? extends ConvertidorInterfaz> convercionClass() default ConvertidorInterfaz.class;

}
