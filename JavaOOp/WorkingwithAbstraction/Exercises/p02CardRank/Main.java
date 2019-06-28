package JavaOOp.L03WorkingwithAbstraction.Exercises.p02CardRank;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();


        CardRank[] arr = CardRank.values();

        System.out.println(input+":");
        for (CardRank cardRank : arr) {
            System.out.println(String.format(
                    "Ordinal value: %s; Name value: %s"
                    ,cardRank.ordinal()
                    ,cardRank
            ));
        }


    }
}
