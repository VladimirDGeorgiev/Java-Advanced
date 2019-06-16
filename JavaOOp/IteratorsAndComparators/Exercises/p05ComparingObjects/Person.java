package JavaOOp.IteratorsAndComparators.Exercises.p05ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int compareTo(Person person) {
        if (this.name.equals(person.getName())) {
            if (this.age == person.getAge()) {
                return this.town.compareTo(person.getTown());
            }
            return Integer.compare(this.age, person.getAge());
        }
        return this.name.compareTo(person.getName());

    }
}
