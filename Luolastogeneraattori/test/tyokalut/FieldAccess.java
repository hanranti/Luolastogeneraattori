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

}
