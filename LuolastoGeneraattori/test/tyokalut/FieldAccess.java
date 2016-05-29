package tyokalut;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hanranti
 */
public class FieldAccess {

    private Object object;

    public FieldAccess(Object object) {
        this.object = object;
    }

    public Object getField(String field) {
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
