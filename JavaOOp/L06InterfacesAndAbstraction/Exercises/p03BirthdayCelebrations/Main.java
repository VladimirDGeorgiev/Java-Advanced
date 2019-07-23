package JavaOOP.L06InterfacesAndAbstraction.Exercises.p03BirthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Birthable> birthableList = new ArrayList<>();
        List<Identifiable> identifiableList = new ArrayList<>();
         String commands = "";

        while (!"End".equals(commands= reader.readLine())){
            String[] tokens = commands.split("\\s+");
            String type = tokens[0];
            if (type.equals("Citizen")){
                Citizen citizen = new Citizen(
                        tokens[1]
                        ,Integer.parseInt(tokens[2])
                ,tokens[3]
                ,tokens[4]);
                birthableList.add(citizen);
                identifiableList.add(citizen);
            }else if (type.equals("Robot")){
                Robot robot = new Robot(tokens[1],tokens[2]);
                identifiableList.add(robot);
            }else if (type.equals("Pet")){
                Pet pet = new Pet(tokens[1],tokens[2]);
                birthableList.add(pet);
            }

        }
        String year = reader.readLine();

        birthableList.stream().filter(e->e.getBirthDate().endsWith(year)).forEach(e-> System.out.println(e.getBirthDate()));
    }
}
