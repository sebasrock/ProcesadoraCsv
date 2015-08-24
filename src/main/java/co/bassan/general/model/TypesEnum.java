package co.bassan.general.model;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Sebastian Sanchez on 09/02/2015.
 */
public enum TypesEnum {


    INT {
        @Override
        public Object parse(String s) throws Exception {
            try {
                return Integer.parseInt(s);
            } catch (Exception e) {
                throw new Exception("No se puede convertir el valor : " + s + " a valor numerico");
            }
        }
    },
    STRING {
        @Override
        public String parse(String s) throws Exception {
            return s;
        }
    },
    INTEGER {
        @Override
        public Object parse(String s) throws Exception {
            try {
                return Integer.parseInt(s);
            } catch (Exception e) {
                throw new Exception("No se puede convertir el valor : " + s + " a valor numerico");
            }
        }
    },
    BIGINTEGER {
        @Override
        public Object parse(String s) throws Exception {
            try {
                return BigInteger.valueOf(Long.parseLong(s));
            } catch (Exception e) {
                throw new Exception("No se puede convertir el valor : " + s + " a valor numerico");
            }
        }
    },
    BIGDECIMAL {
        @Override
        public Object parse(String s) throws Exception {
            try {
                return BigDecimal.valueOf(Long.parseLong(s));
            } catch (Exception e) {
                throw new Exception("No se puede convertir el valor : " + s + " a valor numerico");
            }
        }
    },
    FLOAT {
        @Override
        public Object parse(String s) throws Exception {
            try {
                return Float.parseFloat(s);
            } catch (Exception e) {
                throw new Exception("No se puede convertir el valor : " + s + " a valor numerico");
            }
        }
    },
    SHORT {
        @Override
        public Object parse(String s) throws Exception {
            try {
                return Short.parseShort(s);
            } catch (Exception e) {
                throw new Exception("No se puede convertir el valor : " + s + " a valor numerico");
            }
        }
    },
    BOOLEAN {
        @Override
        public Object parse(String s) throws Exception {
            return Boolean.parseBoolean(s);
        }
    },
    LONG {
        @Override
        public Object parse(String s) throws Exception {
            try {
                return Long.parseLong(s);
            } catch (Exception e) {
                throw new Exception("No se puede convertir el valor : " + s + " a valor numerico");
            }
        }
    },
    DOUBLE {
        @Override
        public Object parse(String s) throws Exception {
            try {
                return Double.parseDouble(s);
            } catch (Exception e) {
                throw new Exception("No se puede convertir el valor : " + s + " a valor numerico");
            }
        }
    };


    public abstract Object parse(String s) throws Exception;

    public static Object parseObjectFromString(String s, Class<?> cls) throws Exception {
        return valueOf(cls.getSimpleName().toUpperCase()).parse(s);
    }

}
