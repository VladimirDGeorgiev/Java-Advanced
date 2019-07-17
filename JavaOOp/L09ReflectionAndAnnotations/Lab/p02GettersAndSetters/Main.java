package JavaOOP.L09ReflectionAndAnnotations.Lab.p02GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Class reflection = Reflection.class;
        Method[] methods = reflection.getDeclaredMethods();

        Method[] getters = Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("get") &&
                        method.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Arrays.stream(getters).forEach(getter->
                System.out.println(String.format("%s will return class %s"
                ,getter.getName()
                ,getter.getReturnType().getName()))
        );

        Method[] setters = Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("set") &&
                        method.getParameterCount() == 1)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Arrays.stream(setters).forEach(setter->
                System.out.println(String.format("%s and will set field of class %s"
                        ,setter.getName()
                        ,setter.getParameterTypes()[0].getName()))
        );


    }
}
