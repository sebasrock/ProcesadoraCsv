package co.bassan.lectora.model;

/**
 * Created by Sebastian Sanchez on 09/02/2015.
 */
public enum Types {


    INT {
        @Override
        public Object parse(String s) throws Exception {
            return Integer.parseInt(s);
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
