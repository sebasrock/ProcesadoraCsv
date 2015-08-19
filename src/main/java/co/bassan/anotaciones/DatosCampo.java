package co.bassan.anotaciones;

import co.bassan.general.util.ConversionPersonal;

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
     * Indica si se eliminaran espacions al final y al inicio del texto
     *
     * @return
     */
    boolean trim() default false;

    /**
     * Nombre con el que se escribirar el encabezado del archivo
     *
     * @return
     */
    String nombre() default "";

    /**
     * Posicion de columna de archivo la cual representara este elemento
     *
     * @return
     */
    int posicion() default 0;

    /**
     * Si es necesario hacer una conversion especial para este campo se debe
     * implemtar la interfas ConversionPersonal, y colocar el .class de la implemetacion
     *
     * @return
     */
    Class<? extends ConversionPersonal> convercionClass() default ConversionPersonal.class;

}
