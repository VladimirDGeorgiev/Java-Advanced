package JavaOOP.L06InterfacesAndAbstraction.Exercises.p05Тelephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

     // String asd = "asd";
     // if (asd.matches("[^\\d]+")){
     //     System.out.println("da");
     // }
        Smartphone smartphone = new Smartphone(
                Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList())
                , Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList()));
        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}
