package JavaOOp.IteratorsAndComparators.Exercises.p07EqualityLogic;

import java.util.Comparator;

public class Person implements Comparator<Person>,Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return this.age == person.getAge()
                && (name.equals(person.name));
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return name +" "+ age;
    }

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getName().equals(o2.getName())){
            if (o1.getAge()-o2.getAge()==0){
                return 0;
            }
            return o1.getAge()-o2.getAge();
        }
       return o1.getName().compareTo(o2.getName());
    }

    @Override
    public int compareTo(Person o) {
        if (this.name.equals(o.getName())){
            if (this.age-o.getAge()==0){
                return 0;
            }
            return this.age-o.getAge();
        }
        return this.name.compareTo(o.getName());
    }

}
