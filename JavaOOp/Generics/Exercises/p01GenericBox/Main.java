package JavaOOp.Generics.Exercises.p01GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            Box<?> nov = new Box<>(reader.readLine());
            System.out.println(nov.toString());
        }

    }

}
