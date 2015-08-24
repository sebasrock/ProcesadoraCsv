package co.bassan.validaciones;

import co.bassan.general.model.ErrorCampo;
import co.bassan.general.model.InfCampo;
import co.bassan.general.util.UtilProcesador;
import co.bassan.validaciones.core.Validacion;

import java.util.List;

/**
 * Created by sebas on 18/08/15.
 */
public class ValidacionRequerido implements Validacion
{

    private static ValidacionRequerido intancia;

    public ValidacionRequerido() {
    }


    public static ValidacionRequerido obtenerInstancia(){
        if(intancia!=null){
            return intancia;
        }else {
            return new ValidacionRequerido();
        }
    }

    /**
     * Valida si un campo es requerido
     * @param errores
     * @param infCampo
     * @return
     */
    @Override
    public boolean ejecutarValidacion(List<ErrorCampo> errores, InfCampo infCampo,int fila)
    {
        if (infCampo.getValidaciones()!=null && infCampo.getValidaciones().isRequirido()) {
            if (infCampo.getValor() == null || "".equals(infCampo.getValor().trim())) {
                UtilProcesador.adicionarError(errores, fila, infCampo.getPosicion(), "El valor del campo " + infCampo.getNombreCampoArchivo() + " es requerido", null);
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
