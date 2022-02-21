package lab4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        for (Method m : PrivateMethods.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(IntAnnotation.class)) {
                IntAnnotation annotation = m.getAnnotation(IntAnnotation.class);
                m.setAccessible(true);
                for (int j = 0; j < annotation.value(); j++) {
                    try {
                        if (m.getParameterCount() == 2) {
                            m.invoke(null, j + 1, j + 1);
                        } else {
                            m.invoke(null);
                        }
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
