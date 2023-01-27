import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionEx {
    Class<?> classInstance;

    ReflectionEx(String className) throws ClassNotFoundException {
        classInstance = Class.forName(className);
    }

    void getFields() {
        Field[] fields = classInstance.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
    }

    void getListOfMethods() {
        Method[] methods = classInstance.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }

    <T> T resolve(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<T> c = (Class<T>) Class.forName(className);
        return c.newInstance();
    }
}
