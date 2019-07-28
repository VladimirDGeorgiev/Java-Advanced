package JavaOOP.L10ExceptionsAndErrorHandling.p01SquareRoot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(reader.readLine());
            if (n < 0) {
                throw new NumberFormatException();
            }
            System.out.println(Math.pow(n, 0.5));
        } catch (NumberFormatException exp) {
            System.out.println("Invalid number");

        } finally {
            System.out.println("Good bay");
        }
    }
}
