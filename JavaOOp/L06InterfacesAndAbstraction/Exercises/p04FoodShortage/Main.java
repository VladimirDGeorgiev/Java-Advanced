package JavaOOP.L06InterfacesAndAbstraction.Exercises.p04FoodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Buyer> buyerList = new HashMap<>();

        int n = Integer.parseInt(reader.readLine());

        while (n-->0){
            String[] command = reader.readLine().split("\\s+");

            if (command.length==4){
                Citizen citizen = new Citizen(
                        command[0]
                        ,Integer.parseInt(command[1])
                ,command[2]
                ,command[3]);
                buyerList.putIfAbsent(command[0],citizen);
            }else if (command.length==3){
                Rebel rebel = new Rebel(command[0]
                        ,Integer.parseInt(command[1])
                        ,command[2]);
                buyerList.putIfAbsent(command[0],rebel);
            }
        }
        String command = "";
        while (!"End".equals(command= reader.readLine())){
            if (buyerList.containsKey(command)){
                buyerList.get(command).buyFood();
            }
        }
        System.out.println(buyerList.values().stream().mapToInt(Buyer::getFood).sum());

    }
}
