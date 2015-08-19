package co.bassan.anotaciones;

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
     * Nombre de archivo que se va generar
     *
     * @return
     */
    String nombre() default "";

    /**
     * Caracter de separacion  para csv
     *
     * @return
     */
    String separador() default ",";

    /**
     * Cantidad columnas permitidas
     *
     * @return
     */
    int cantidadColumnas();

    /**
     * Verifica si desea saltar la primera linea del archivo, en caso de que sea un encabezado
     *
     * @return
     */
    boolean saltarPrimeraLinea() default false;

    /**
     * Indica si el archivo tendra multiples estructuras
     *
     * @return
     */
    boolean multiEstructura() default false;
}
