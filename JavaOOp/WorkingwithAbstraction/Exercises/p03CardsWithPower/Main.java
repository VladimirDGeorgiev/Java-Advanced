package JavaOOp.L03WorkingwithAbstraction.Exercises.p03CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rank = reader.readLine();
        String suit = reader.readLine();
        Rank rank1 = Rank.valueOf(rank);
        Suit suit1 = Suit.valueOf(suit);
        Card card = new Card(rank1,suit1);
        System.out.println(String.format(
                "Card name: %s of %s; Card power: %d"
                ,card.getRank()
                ,card.getSuit()
                ,card.value()
        ));
    }
}
