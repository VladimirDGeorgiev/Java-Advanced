package JavaOOP.L06InterfacesAndAbstraction.Lab.p07BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Identifiable> idList = new ArrayList<>();

        String command = "";

        while (!"End".equals(command = reader.readLine())){

         String[] tokens = command.split("\\s+");
         if (tokens.length==3){
            Citizen citizen = new Citizen(tokens[0],Integer.parseInt(tokens[1]),tokens[2]);
            idList.add(citizen);
         }else if (tokens.length==2){
             Robot robot = new Robot(tokens[0],tokens[1]);
             idList.add(robot);
         }

        }

        String lastDigitsOfId = reader.readLine();
        idList.stream().filter(e->e.getId().endsWith(lastDigitsOfId)).forEach(e-> System.out.println(e.getId()));


    }
}
