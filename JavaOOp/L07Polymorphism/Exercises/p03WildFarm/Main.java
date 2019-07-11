package JavaOOP.L07Polymorphism.Exercises.p03WildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animalList = new ArrayList<>();

        String animalData = "";
        while (!"End".equals(animalData= reader.readLine())){
            String[] animalsToken = animalData.split("\\s+");
            Animal animal = null;

            switch (animalsToken[0]){
                case "Cat":
                     animal = new Cat(animalsToken[0]
                            ,animalsToken[1]
                            ,Double.parseDouble(animalsToken[2])
                            ,animalsToken[3]
                            ,animalsToken[4]);

                    break;
                case "Tiger":
                    animal = new Tiger(animalsToken[0]
                            ,animalsToken[1]
                            ,Double.parseDouble(animalsToken[2])
                            ,animalsToken[3]);
                    break;
                case "Zebra":
                    animal = new Zebra(animalsToken[0]
                            ,animalsToken[1]
                            ,Double.parseDouble(animalsToken[2])
                            ,animalsToken[3]);
                    break;
                case "Mouse":
                    animal = new Mouse(animalsToken[0]
                            ,animalsToken[1]
                            ,Double.parseDouble(animalsToken[2])
                            ,animalsToken[3]);
                    break;
            }

            String[] foodToken = reader.readLine().split("\\s+");
            Food food = null;
            switch (foodToken[0]){
                case "Vegetable":
                    food = new Vegetable(Integer.parseInt(foodToken[1]));
                    break;
                case "Meat":
                    food = new Meat(Integer.parseInt(foodToken[1]));
                    break;
            }
            animal.makeSound();
            animal.eat(food);
            animalList.add(animal);
        }
        animalList.forEach(e-> System.out.println(e.toString()));
    }
}
