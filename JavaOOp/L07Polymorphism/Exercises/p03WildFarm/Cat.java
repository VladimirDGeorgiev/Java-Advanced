package JavaOOP.L07Polymorphism.Exercises.p03WildFarm;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalType, String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalType,animalName,  animalWeight, livingRegion);
        this.breed= breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        this.setFoodEaten(this.getFoodEaten()+food.getQuantity());
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        NumberFormat format = new DecimalFormat("#.##");
        StringBuilder sb = new StringBuilder();
        sb.append(this.getAnimalType())
                .append("[")
                .append(this.getAnimalName())
                .append(", ")
                .append(this.getBreed())
                .append(", ")
                .append(format.format(this.getAnimalWeight()))
                .append(", ")
                .append(this.getLivingRegion())
                .append(", ")
                .append(this.getFoodEaten())
                .append("]");
        //{AnimalType} [{AnimalName}, {CatBreed}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}]
        return sb.toString() ;
    }
}
