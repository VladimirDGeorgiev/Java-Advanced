package JavaOOP.L09ReflectionAndAnnotations.Lab.p03HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Class reflection = Reflection.class;

        //Field check for Encapsulation
        Field[] field = reflection.getDeclaredFields();
        Arrays.stream(field)
                .filter(f-> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f->{
                    System.out.println(f.getName()+" must be private!");
                });


        //Getters and setters check for encapsulation
        Method[] methods = reflection.getDeclaredMethods();

        Method[] getters = Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("get") &&
                        method.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Arrays.stream(getters)
                .filter(g->!Modifier.isPublic(g.getModifiers()))
                .forEach(getter->
                System.out.println(String.format("%s have to be public!"
                ,getter.getName()))
        );

        Method[] setters = Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("set") &&
                        method.getParameterCount() == 1)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Arrays.stream(setters)
                .filter(s->!Modifier.isPrivate(s.getModifiers()))
                .forEach(setter->
                System.out.println(String.format("%s have to be private!"
                        ,setter.getName()
                        ))
        );


    }
}
