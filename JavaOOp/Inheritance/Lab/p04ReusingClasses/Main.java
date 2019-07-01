package JavaOOp.L04Inheritance.Lab.p04ReusingClasses;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        RandomArrayList asd = new RandomArrayList();
        asd.add("asd");
        asd.add("a1");
        asd.add("a2");
        asd.add("a3");
        asd.add(1);
        asd.add(2);
        asd.add(3);
        asd.add(4);
        asd.add(5);
        asd.add(6);
        System.out.println(asd.getRandomElement());
        System.out.println(asd.getRandomElement());
        System.out.println(asd.getRandomElement());
        System.out.println(asd.getRandomElement());

    }
}
