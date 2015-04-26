package co.bassan.lectora.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;

/**
 * Created by Sebastian Sanchez on 09/02/2015.
 */
public enum TypesEnum {


    INT {
        @Override
        public Object parse(String s) throws Exception {
            return Integer.parseInt(s);
        }
    },
    STRING {
        @Override
        public Object parse(String s) throws Exception {
            return s;
        }
    },
    INTEGER {
        @Override
        public Object parse(String s) throws Exception {
            return Integer.parseInt(s);
        }
    },
    BIGINTEGER {
        @Override
        public Object parse(String s) throws Exception {
            return BigInteger.valueOf(Long.parseLong(s));
        }
    },
    BIGDECIMAL {
        @Override
        public Object parse(String s) throws Exception {
            return BigDecimal.valueOf(Long.parseLong(s));
        }
    },
    FLOAT {
        @Override
        public Object parse(String s) throws Exception {
            return Float.parseFloat(s);
        }
    },
    SHORT {
        @Override
        public Object parse(String s) throws Exception {
            return Short.parseShort(s);
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
            return Long.parseLong(s);
        }
    },
    DATE {
        @Override
        public Object parse(String s) throws Exception {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            return formatter.parse(s);
        }
    },
    DOUBLE {
        @Override
        public Object parse(String s) throws Exception {
            return Double.parseDouble(s);
        }
    };


    public abstract Object parse(String s) throws Exception;

    public static Object parseObjectFromString(String s, Class<?> cls) throws Exception {
        return valueOf(cls.getSimpleName().toUpperCase()).parse(s);
    }
}
