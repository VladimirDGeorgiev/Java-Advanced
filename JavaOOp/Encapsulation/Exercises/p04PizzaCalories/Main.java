package JavaOOp.L05Encapsulation.Exercises.p04PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] pizzaInfo = reader.readLine().split("\\s+");
            String pizzaName = pizzaInfo[1];
            int numberOfToppings = Integer.parseInt(pizzaInfo[2]);

            Pizza pizza = new Pizza(pizzaName, numberOfToppings);

            String[] doughInfo = reader.readLine().split("\\s+");
            String doughType = doughInfo[1];
            String doughBakingTechnique = doughInfo[2];
            double doughWeight = Double.parseDouble(doughInfo[3]);

            Dough dough = new Dough(doughType, doughBakingTechnique, doughWeight);

            pizza.setDough(dough);

            String topping = "";

            while (!"END".equals(topping=reader.readLine())) {
                String[] toppingInfo = topping.split("\\s+");
                String toppingType = toppingInfo[1];
                double toppingWeight = Double.parseDouble(toppingInfo[2]);

                Topping topping1 = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping1);
            }

            System.out.println(pizza);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}