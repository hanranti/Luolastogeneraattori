package tyokalut;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hanranti
 */
public class FieldAccess {

    public static Object getField(Object object, String field) {
        try {
            Field f = object.getClass().getDeclaredField(field);
            f.setAccessible(true);
            return f.get(object);
        } catch (IllegalArgumentException ex) {
        } catch (IllegalAccessException ex) {
        } catch (NoSuchFieldException ex) {
        } catch (SecurityException ex) {
        }
        return null;
    }

    public static Object getArray(Object object, String field) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getClass().isArray() && fields[i].getName().equals(field)) {
                try {
                    fields[i].setAccessible(true);
                    return  fields[i].get(object);
                } catch (IllegalArgumentException ex) {
                    System.out.println("IllegalArgumentException");
                } catch (IllegalAccessException ex) {
                    System.out.println("IllegalAccessException");
                }
            }
        }
        return null;
    }
}
