package co.bassan.lectora.core;

/**
 * Created by Sebastian- on 15/02/2015.
 */
public class EjecutorValidaciones {

//    private ConfiguracionCampo config;
//    private int fila;
//    private int cantidadCarga;
//    private int cantidadConfigurada;
//
//    private static EjecutorValidaciones intancia;
//
//
//    /**
//     * Metodo encargado de ejecutar las validaciones basicas de un archivo
//     *
//     * @return
//     */
//    public List<ErrorCampo> ejecutor() {
//        List<ErrorCampo> errores = new ArrayList<ErrorCampo>();
//        if (config.getValidaciones() != null) {
//            try {
//                if (config.getValidaciones().isRequirido())
//                    validarSiEsRequerido(config.getValor(), config.getPosicion());
//                if (config.getValidaciones().getLongitudMinima() != 0)
//                    validarLongitudMinima(config.getValidaciones().getLongitudMinima(), config.getValor(), errores, config.getPosicion());
//                if (config.getValidaciones().getLongitudMaxima() != 0)
//                    validarLongitudMaxima(config.getValidaciones().getLongitudMaxima(), config.getValor(), errores, config.getPosicion());
//                if (config.getValidaciones().getExprecion() != null)
//                    validarPatron(config.getValidaciones().getExprecion(), config.getValor(), errores, config.getPosicion());
//                if (config.getValidaciones().getListaLimitante() != null && config.getValidaciones().getListaLimitante().length > 0)
//                    validarListaLimite(config.getValidaciones().getListaLimitante(), config.getValor(), errores, config.getPosicion());
//                if (config.getValidaciones().getFechaMinima() != null && !config.getValidaciones().getFechaMinima().isEmpty())
//                    validarFechaMinima(config.getValidaciones().getFechaMinima(),config.getValidaciones().getFormatoFecha(), config.getValor(), errores, config.getPosicion());
//                if (config.getValidaciones().getFechaMaxima() != null && !config.getValidaciones().getFechaMaxima().isEmpty())
//                    validarFechaMaxima(config.getValidaciones().getFechaMaxima(), config.getValidaciones().getFormatoFecha(), config.getValor(), errores, config.getPosicion());
//            } catch (CargueCsvExcepcion e) {
//                agregarError(e.getError(), errores);
//            }
//        }
//        return errores;
//    }
//
//    /**
//     * Valida que la fecha ingresada sea mayor a la fecha parametrizada en la fecha minima
//     *
//     * @param fechaMinima
//     * @param formatoFecha
//     * @param valor
//     * @param errores
//     * @param posicion
//     */
//    private void validarFechaMinima(String fechaMinima, String formatoFecha, String valor, List<ErrorCampo> errores, int posicion) {
//        Date fechaMin = validarFormatoFecha(formatoFecha,fechaMinima,errores,posicion);
//        Date fecha = validarFormatoFecha(formatoFecha,valor,errores,posicion);
//        if(fechaMin!=null && fecha !=null && fecha.before(fechaMin)){
//            agregarError("fecha es menor a la permitida , Fecha minima :" + fechaMinima , valor, errores, posicion);
//        }
//
//    }
//
//
//    /**
//     * Valida que la fecha ingresada sea menor a la fecha parametrizada en la fecha maxima
//     *
//     * @param fechaMaxima
//     * @param formatoFecha
//     * @param valor
//     * @param errores
//     * @param posicion
//     */
//    private void validarFechaMaxima(String fechaMaxima, String formatoFecha, String valor, List<ErrorCampo> errores, int posicion) {
//        Date fechaMax = validarFormatoFecha(formatoFecha,fechaMaxima,errores,posicion);
//        Date fecha = validarFormatoFecha(formatoFecha,valor,errores,posicion);
//        if(fechaMax!=null && fecha !=null && fechaMax.before(fecha)){
//            agregarError("fecha es mayor a la permitida , Fecha maxima :" + fechaMaxima , valor, errores, posicion);
//        }
//
//    }
//
//    /**
//     * valida el formato de fecha
//     *
//     * @param formatoFecha
//     * @param valor
//     * @param errores
//     * @param linea
//     */
//    private Date validarFormatoFecha(String formatoFecha, String valor, List<ErrorCampo> errores, int linea) {
//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat(formatoFecha);
//
//            if (valor.trim().length() != dateFormat.toPattern().length())
//                agregarError("No tiene un formato de fecha correcto : " + formatoFecha, valor, errores, linea);
//
//            dateFormat.setLenient(false);
//
//
//            return dateFormat.parse(valor.trim());
//        } catch (ParseException pe) {
//            agregarError("No tiene un formato de fecha correcto : " + formatoFecha, valor, errores, linea);
//            return null;
//        }
//
//    }
//
//    /**
//     * valida que este en los valores opcionales
//     *
//     * @param listaLimitante
//     * @param valor
//     * @param errores
//     * @param linea
//     */
//    private void validarListaLimite(String[] listaLimitante, String valor, List<ErrorCampo> errores, int linea) {
//        if (!Arrays.asList(listaLimitante).contains(valor))
//            agregarError("No esta entre los valores posibles", valor, errores, linea);
//    }
//
//    /**
//     * validaciones generales del docuneto
//     * <p/>
//     * Validar cantidad de campos obligatorios
//     *
//     * @throws CargueCsvExcepcion
//     */
//    private void validacionesGenerales() throws CargueCsvExcepcion {
//        if (cantidadConfigurada != (cantidadCarga - 1)) {
//            throw new CargueCsvExcepcion("Numero de columanas diferentes", null, fila, 0);
//        }
//    }
//
//    /**
//     * validacion de patrones
//     *
//     * @param exprecion
//     * @param valor
//     * @param errores
//     * @param linea
//     */
//    private void validarPatron(String exprecion, String valor, List<ErrorCampo> errores, int linea) {
//        if (valor.matches(exprecion)) {
//            agregarError("No tiene el formato adecuado", valor, errores, linea);
//        }
//    }
//
//    /**
//     * validacion de longitud maxima
//     *
//     * @param longitudMaxima
//     * @param valor
//     * @param errores
//     * @param linea
//     */
//    private void validarLongitudMaxima(int longitudMaxima, String valor, List<ErrorCampo> errores, int linea) {
//        if (valor.length() > longitudMaxima) {
//            agregarError("No tiene la longitud maxima", valor, errores, linea);
//        }
//    }
//
//    /**
//     * validacion de longitud minima
//     *
//     * @param longitudMinima
//     * @param valor
//     * @param errores
//     * @param linea
//     */
//    private void validarLongitudMinima(int longitudMinima, String valor, List<ErrorCampo> errores, int linea) {
//        if (valor.length() < longitudMinima) {
//            agregarError("No tiene la longitud minima", valor, errores, linea);
//        }
//    }
//
//    /**
//     * Validar si el campo es requerido
//     *
//     * @param valor
//     * @param linea
//     * @throws CargueCsvExcepcion
//     */
//    public void validarSiEsRequerido(String valor, int linea) throws CargueCsvExcepcion {
//        if (valor == null || "".equals(valor.trim())) {
//            throw new CargueCsvExcepcion("el valor es requerido: " + valor, valor, fila, linea);
//        }
//    }
//
//    /**
//     * Agrega errores al acumulado de errores del archivo
//     *
//     * @param causa
//     * @param valor
//     * @param errores
//     * @param linea
//     */
//    private void agregarError(String causa, String valor, List<ErrorCampo> errores, int linea) {
//        agregarError(new ErrorCampo(causa, valor, fila, linea), errores);
//    }
//
//    /**
//     * Agrega errores al acumulado de errores del archivo
//     *
//     * @param error
//     * @param errores
//     */
//    private void agregarError(ErrorCampo error, List<ErrorCampo> errores) {
//        error.setFila(fila);
//        errores.add(error);
//    }
//
//    /**
//     * Constructor
//     *
//     * @param config
//     * @param fila
//     * @param cantidadCarga
//     */
//    public EjecutorValidaciones(ConfiguracionCampo config, int fila, int cantidadCarga, int cantidad) {
//        this.config = config;
//        this.fila = fila;
//        this.cantidadCarga = cantidadCarga;
//        this.cantidadConfigurada = cantidad;
//    }
//
//    /**
//     * Singleton
//     *
//     * @param config
//     * @param cantidadCampos
//     * @param fila
//     * @param cantidadCargada @return
//     */
//    public static EjecutorValidaciones getIntancia(ConfiguracionCampo config, int cantidadCampos, int fila, int cantidadCargada) {
//
//        if (intancia == null) {
//            return new EjecutorValidaciones(config, fila, cantidadCargada, cantidadCampos);
//        } else {
//            intancia.modificarDatos(config, fila, cantidadCargada, cantidadCampos);
//            return intancia;
//        }
//    }
//
//
//    /**
//     * Modificacion de datos de la instancia
//     *
//     * @param config
//     * @param fila
//     * @param cantidadCarga
//     * @param cantidadCampos
//     */
//    private void modificarDatos(ConfiguracionCampo config, int fila, int cantidadCarga, int cantidadCampos) {
//        this.config = config;
//        this.fila = fila;
//        this.cantidadCarga = cantidadCarga;
//        this.cantidadConfigurada = cantidadCampos;
//    }
}
