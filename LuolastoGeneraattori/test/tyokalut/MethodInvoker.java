package tyokalut;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class MethodInvoker {

    private Method[] methods;

    private Object object;

    public MethodInvoker(Object object) {
        this.object = object;
        methods = object.getClass().getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
        }
    }

    public Object invokeMethod(String methodName, Object... objects) {
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                try {
                    return method.invoke(object, objects);
                } catch (IllegalAccessException ex) {
                } catch (IllegalArgumentException ex) {
                } catch (InvocationTargetException ex) {
                }
            }
        }
        return null;
    }
}
