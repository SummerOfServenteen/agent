package dynamicproxy;

import org.springframework.cglib.core.DebuggingClassWriter;

public class CglibTest {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "F:\\IdeaProjects\\learn\\agent\\cglib");
        Student student = new Student("xxx");
        Student proxy = (Student)new  CglibProxyFactory(student).getProxyInstance();
        proxy.getName();
    }
}
