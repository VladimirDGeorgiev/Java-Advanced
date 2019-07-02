package JavaOOp.L04Inheritance.Exercises.p06Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animalList = new ArrayList<>();

        String command = "";

        while (!"Beast!".equals(command= reader.readLine())){
            try {
                String type = command;
                String[] data = reader.readLine().split("\\s+");
                String name = data[0];
                int age =Integer.parseInt(data[1]);
                String gender = data[2];

                Animal animal = null;
                switch (type){
                    case "Cat":
                        animal=new Cat(name,age,gender);
                        break;
                    case "Dog":
                        animal=new Dog(name,age,gender);
                        break;
                    case "Frog":
                        animal=new Frog(name,age,gender);
                        break;
                    case "Tomcat":
                        animal=new Tomcat(name,age);
                        break;
                    case "Kitten":
                        animal=new Kitten(name,age);
                        break;
                        default:
                            break;
                }
                animalList.add(animal);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }

        animalList.forEach(e-> System.out.println(e.toString()));
    }
}
