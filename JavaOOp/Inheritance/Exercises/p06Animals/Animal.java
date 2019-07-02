package JavaOOp.L04Inheritance.Exercises.p06Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length()<1){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age<1){
            throw new IllegalArgumentException("Invalid input!");
        }

        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (!gender.equals("Male")&&!gender.equals("Female")){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    public String produceSound(){
        return  "";
    }

    @Override
    public String toString() {

        return String.format("%s%n%s %d %s%n%s", this.getClass().getSimpleName()
                , this.getName(), this.getAge(), this.getGender(), this.produceSound());
    }
}
