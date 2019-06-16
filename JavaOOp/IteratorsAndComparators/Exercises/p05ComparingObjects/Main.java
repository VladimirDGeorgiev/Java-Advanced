package JavaOOp.IteratorsAndComparators.Exercises.p05ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> list = new ArrayList<>();
        String input;
        while (!"END".equals(input= reader.readLine())){
            String[] data = input.split("\\s+");
            list.add(new Person(data[0],
                    Integer.parseInt(data[1]),
                    data[2]));

        }
        Person refer = list.get(Integer.parseInt(reader.readLine())-1);
        int equalPeople = 0;
        int notEqualPeople = 0;
        int totalNumOfPeople = list.size();
        for (Person person : list) {
            if(person.compareTo(refer)==0){
                equalPeople++;
            }else{
                notEqualPeople++;
            }
        }
        if (equalPeople>1){
            System.out.println(String.format("%s %s %s",equalPeople,notEqualPeople,totalNumOfPeople));
        }else{
            System.out.println("No matches");
        }
    }
}
