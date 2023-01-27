package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StudentProxy implements InvocationHandler {
    private final Student student;

    public StudentProxy(Student student) {
        this.student = student;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object o = null;
        try {
            o = method.invoke(student, args);
            System.out.println("The method was invoked: " + method.getName());
            System.out.println("Produced Result: "+o);
            return o;
        } catch (Exception e) {
            throw e;
        }
    }
}
