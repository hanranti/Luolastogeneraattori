package tyokalut;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodInvoker {

    private final Method[] methods;

    private final Object object;

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
