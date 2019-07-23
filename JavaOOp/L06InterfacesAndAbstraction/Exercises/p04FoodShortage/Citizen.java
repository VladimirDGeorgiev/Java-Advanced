package JavaOOP.L06InterfacesAndAbstraction.Exercises.p04FoodShortage;

public class Citizen implements Identifiable,Buyer,Person{
    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;


    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
        this.food=0;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String getId() {
        return this.id;
    }


    @Override
    public void buyFood() {
        this.food+=10;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public String getName() {
        return this.getName();
    }

    @Override
    public int getAge() {
        return this.getAge();
    }
}
