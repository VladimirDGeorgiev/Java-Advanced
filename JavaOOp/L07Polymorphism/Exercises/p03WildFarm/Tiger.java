package JavaOOP.L07Polymorphism.Exercises.p03WildFarm;

public class Tiger extends Felime {

    public Tiger(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType,animalName,  animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable){
            System.out.println("Tigers are not eating that type of food!");
            //   throw new IllegalArgumentException(this.getClass().getSimpleName()+" are not eating that type of food!");
        }else{

            this.setFoodEaten(this.getFoodEaten()+food.getQuantity());
        }
    }
}
