package JavaOOp.L04Inheritance.Exercises.p09MordorsCrueltyPlan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));

       Gandalf gandalf = new Gandalf();

       String[] food = reader.readLine().split("\\s+");

        for (String s : food) {
            gandalf.eatFood(s);
        }

        System.out.println(gandalf.getFoodPoints());
        System.out.println(gandalf.getMood());
    }
}
