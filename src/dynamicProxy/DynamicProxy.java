package dynamicProxy;

import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static void main(String[] args) {
        Student student = new Student("Joao", 19);

        StudentInterface studentProxied = (StudentInterface) Proxy.newProxyInstance(
                Student.class.getClassLoader(),
                new Class[]{StudentInterface.class},
                new StudentProxy(student));

        studentProxied.viewGrade();

    }
}
