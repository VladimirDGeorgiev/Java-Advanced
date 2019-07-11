package JavaOOP.L07Polymorphism.Exercises.p03WildFarm;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public abstract class Animal {
    private String animalType;
    private String animalName;
    private Double animalWeight;
    private Integer foodEaten;

    protected Animal(String animalType, String animalName, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten=0;
    }

    public abstract void makeSound();

    public abstract void eat(Food food);


    public String getAnimalName() {
        return animalName;
    }

    protected void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    protected void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    protected void setAnimalWeight(Double animalWeight) {
        this.animalWeight = animalWeight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    protected void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    @Override
    public String toString() {
        NumberFormat format = new DecimalFormat("#.##");
        StringBuilder sb = new StringBuilder();
        sb.append(this.getAnimalType())
                .append("[")
                .append(this.getAnimalName())
                .append(", ")
                .append(format.format(this.getAnimalWeight()))
                .append(", ")
                .append(this.getFoodEaten())
                .append("]");
                //{AnimalType} [{AnimalName}, {CatBreed}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}]
        return sb.toString() ;
    }
}
