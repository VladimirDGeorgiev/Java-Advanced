package JavaOOP.L09ReflectionAndAnnotations.Exercises.p02BlackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, NoSuchFieldException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class blackBox = BlackBoxInt.class;

        @SuppressWarnings(value = "unchecked")
        Constructor declaredConstructor = blackBox.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Field declaredField = blackBox.getDeclaredField("innerValue");
            declaredField.setAccessible(true);
     //  Method[] method = blackBox.getDeclaredMethods();
     //  Arrays.stream(method).forEach(m->m.setAccessible(true));


        BlackBoxInt boxInt = (BlackBoxInt)declaredConstructor.newInstance();

        String command = "";


        while (!"END".equals(command= reader.readLine())){
            String[] tokens = command.split("_");
            String cmndName = tokens[0];
            int number = Integer.parseInt(tokens[1]);

            switch (cmndName){
                case "add":
                    Method add = blackBox.getDeclaredMethod("add",int.class);
                    add.setAccessible(true);
                    add.invoke(boxInt,number);
                    break;
                case "subtract":
                    Method subtract = blackBox.getDeclaredMethod("subtract",int.class);
                    subtract.setAccessible(true);
                    subtract.invoke(boxInt,number);
                    break;
                case "divide":
                    Method divide = blackBox.getDeclaredMethod("divide",int.class);
                    divide.setAccessible(true);
                    divide.invoke(boxInt,number);
                    break;
                case "multiply":
                    Method multiply = blackBox.getDeclaredMethod("multiply",int.class);
                    multiply.setAccessible(true);
                    multiply.invoke(boxInt,number);
                    break;
                case "rightShift":
                    Method rightShift = blackBox.getDeclaredMethod("rightShift",int.class);
                    rightShift.setAccessible(true);
                    rightShift.invoke(boxInt,number);
                    break;
                case "leftShift":
                    Method leftShift = blackBox.getDeclaredMethod("leftShift",int.class);
                    leftShift.setAccessible(true);
                    leftShift.invoke(boxInt,number);
                    break;
            }

            System.out.println(declaredField.getInt(boxInt));

        }



    }
}
