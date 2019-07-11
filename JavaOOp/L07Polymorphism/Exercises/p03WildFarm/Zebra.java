package JavaOOP.L07Polymorphism.Exercises.p03WildFarm;

public class Zebra extends Mammal {
    public Zebra(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType,animalName,  animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }
    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable){
            this.setFoodEaten(this.getFoodEaten()+food.getQuantity());
        }else{
            System.out.println("Zebras are not eating that type of food!");
            //   throw new IllegalArgumentException(this.getClass().getSimpleName()+" are not eating that type of food!");
        }
    }
}
