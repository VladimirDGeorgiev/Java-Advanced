package JavaOOp.L05Encapsulation.Exercises.p04PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name,int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
        this.toppings = new ArrayList<>();
    }

    private void setToppings(int numberOfToppings) {
        if (numberOfToppings<0||numberOfToppings>10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;
    }

    private void setName(String name) {
        if (name.trim().length()<1||name.trim().length()>15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }


    public String getName() {
        return name;
    }

    public void addTopping (Topping topping){
        if (this.toppings.size() > this.numberOfToppings) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings.add(topping);
    }

    public double getOverallCalories (){
        double sum = this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();
        sum+=this.dough.calculateCalories();
        return sum;
    }
    @Override
    public String toString() {
        return String.format("%s - %.2f", this.getName(), this.getOverallCalories());
    }

}