package JavaAdvance.DefiningClasses.Exercises.p09CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Cat> catMap = new LinkedHashMap<>();

        String command = "";

        while (!"End".equals(command= reader.readLine())){
            String[] data = command.split("\\s+");
            Cat cat = new Cat(data[0],Double.parseDouble(data[2]));
            catMap.putIfAbsent(data[1],cat);
        }
        command= reader.readLine();

        System.out.println(catMap.get(command).getBreed()+" "+command+" "+String.format("%.2f",catMap.get(command).getCharacteristic()));
    }
}
