package JavaOOp.IteratorsAndComparators.Exercises.p07EqualityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        TreeSet<Person> treeSet = new TreeSet<>();
        HashSet<Person> hashSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] data = reader.readLine().split("\\s+");
            Person person = new Person(data[0],Integer.parseInt(data[1]));
            treeSet.add(person);
            hashSet.add(person);
        }
        System.out.println(treeSet.size());
        System.out.println(hashSet.size());

    }
}
