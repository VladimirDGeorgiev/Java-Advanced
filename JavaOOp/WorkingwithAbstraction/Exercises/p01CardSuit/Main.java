package JavaOOp.L03WorkingwithAbstraction.Exercises.p01CardSuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();


        CardSuit[] arr = CardSuit.values();

        System.out.println(input+":");
        for (CardSuit cardSuit : arr) {
            System.out.println(String.format(
                    "Ordinal value: %s; Name value: %s"
                    ,cardSuit.ordinal()
                    ,cardSuit
            ));
        }


    }
}
