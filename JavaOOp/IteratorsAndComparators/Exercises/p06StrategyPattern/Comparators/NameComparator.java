package JavaOOp.IteratorsAndComparators.Exercises.p06StrategyPattern.Comparators;

import JavaOOp.IteratorsAndComparators.Exercises.p06StrategyPattern.Person;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {


    @Override
    public int compare(Person o1, Person o2) {
        String nameOne = o1.getName();
        String nameTwo = o2.getName();
        if (nameOne.length()>nameTwo.length()){
            return 1;
        }else if (nameOne.length()<nameTwo.length()){
            return -1;
        } else{
           return Integer.compare(nameOne.toLowerCase().charAt(0),nameTwo.toLowerCase().charAt(0));
        }

    }
}
