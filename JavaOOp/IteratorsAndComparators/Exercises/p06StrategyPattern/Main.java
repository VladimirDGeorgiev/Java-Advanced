package JavaOOp.IteratorsAndComparators.Exercises.p06StrategyPattern;

import JavaOOp.IteratorsAndComparators.Exercises.p06StrategyPattern.Comparators.AgeComparator;
import JavaOOp.IteratorsAndComparators.Exercises.p06StrategyPattern.Comparators.NameComparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Person> namePerson = new TreeSet<>(new NameComparator());
        TreeSet<Person> agePerson = new TreeSet<>(new AgeComparator());
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] data = reader.readLine().split("\\s+");
            namePerson.add(new Person(data[0],Integer.parseInt(data[1])));
            agePerson.add(new Person(data[0],Integer.parseInt(data[1])));
        }
        for (Person person : namePerson) {
            System.out.println(person.toString());
        }
        for (Person person : agePerson) {
            System.out.println(person.toString());
        }
    }
}

