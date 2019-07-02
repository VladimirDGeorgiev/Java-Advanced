package JavaOOp.L04Inheritance.Exercises.p06Animals;

public class Kitten extends Cat {
    private static final String DEFAULT_TOMCAT_GENDER = "Female";
    public Kitten(String name, int age) {
        super(name, age, DEFAULT_TOMCAT_GENDER);
    }
    @Override
    public String produceSound(){
        return "Meow";
    }
}
