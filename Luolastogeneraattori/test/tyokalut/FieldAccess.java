package tyokalut;

import java.lang.reflect.Field;

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
            try {
                fields[i].setAccessible(true);
                if (!fields[i].get(object).getClass().isArray()) {
                    break;
                }
                return fields[i].get(object);
            } catch (IllegalArgumentException ex) {
            } catch (IllegalAccessException ex) {
            }
        }
        return null;
    }
}
