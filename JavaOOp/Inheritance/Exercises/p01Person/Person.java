package JavaOOp.L04Inheritance.Exercises.p01Person;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name.length()<3){
            throw new IllegalArgumentException( "Name's length should not be less than 3 symbols!");
        }
        this.name = name;
    }

    public void setAge(int age) throws IllegalArgumentException {
        if (age<1){
            throw new IllegalArgumentException("Age must be positive!");
        }
        this.age = age;
    }

    @Override
    public String toString() {

        return String.format("Name: %s, Age: %d",
                this.getName(),
                this.getAge());
    }
}
