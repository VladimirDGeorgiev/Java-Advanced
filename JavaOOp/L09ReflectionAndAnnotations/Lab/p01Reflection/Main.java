package JavaOOP.L09ReflectionAndAnnotations.Lab.p01Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //    • This class type
        //    • Super class type
        //    • All interfaces that are implemented by this class
        //    • Instantiate object using reflection and print it too

        Class reflaction = Reflection.class;

        System.out.println(reflaction);
        System.out.println(reflaction.getSuperclass());
        Class[] interfaces = reflaction.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }
        Object reflactionObject = reflaction.getDeclaredConstructor().newInstance();
        System.out.println(reflactionObject);
    }
}
