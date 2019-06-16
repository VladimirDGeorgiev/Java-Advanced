package JavaOOp.IteratorsAndComparators.Exercises.p04Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Lake lake = new Lake(Arrays.stream(reader.readLine().replace(",","")
                .split("\\s+"))
                .mapToInt(Integer::parseInt).toArray());
        reader.readLine();
        StringBuilder result= new StringBuilder();
        for (Object o : lake) {
            result.append(o).append(", ");
        }
        int indexOfComma =  result.toString().lastIndexOf(",");
        System.out.println(result.deleteCharAt(indexOfComma));

        
        
    }
}
