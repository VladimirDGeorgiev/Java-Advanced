package JavaOOp.L05Encapsulation.Exercises.p04PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
            try {
                ToppingsModifiers toppingsModifiers = ToppingsModifiers.valueOf(toppingType);
            }catch (IllegalArgumentException e){
                throw new IllegalArgumentException("Cannot place "+toppingType+" on top of your pizza.");
            }

        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight<1||weight>50){
            throw new IllegalArgumentException(this.toppingType+" weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories (){
        ToppingsModifiers toppingsModifiers = ToppingsModifiers.valueOf(this.toppingType);
      return   (2*this.weight)*toppingsModifiers.getValue();
    }


}
