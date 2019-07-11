package JavaOOP.L07Polymorphism.Exercises.p03WildFarm;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType,animalName,  animalWeight);
        this.livingRegion = livingRegion;
    }

   //@Override
   //public void eat(Food food) {
   //    if (food instanceof Vegetable){
   //        this.setFoodEaten(this.getFoodEaten()+food.getQuantity());
   //    }else{
   //        System.out.println(this.getClass().getSimpleName()+" are not eating that type of food!");
   //     //   throw new IllegalArgumentException(this.getClass().getSimpleName()+" are not eating that type of food!");
   //    }
   //}

    public String getLivingRegion() {
        return livingRegion;
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
                .append(this.getLivingRegion())
                .append(", ")
                .append(this.getFoodEaten())
                .append("]");
        //{AnimalType} [{AnimalName}, {CatBreed}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}]
        return sb.toString() ;
    }
}
