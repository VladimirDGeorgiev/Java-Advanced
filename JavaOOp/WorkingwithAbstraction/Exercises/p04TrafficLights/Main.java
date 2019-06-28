package JavaOOp.L03WorkingwithAbstraction.Exercises.p04TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("\\s+");
        Light[] arr = Light.values();
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i <n ; i++) {
           for(int j = 0;j<tokens.length;j++) {
                Light lights = Light.valueOf(tokens[j]);
                int number = lights.getValue();
                if (++number>2){
                    number=0;
                }
                System.out.print(arr[number]+" ");
                tokens[j]=arr[number].name();

            }
            System.out.println();
        }
    }
}
