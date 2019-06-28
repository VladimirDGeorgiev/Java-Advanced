package JavaOOp.L03WorkingwithAbstraction.Exercises.p03CardsWithPower;

public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int value(){
        return this.rank.getValue()+this.suit.getValue();
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
//public static int CalculateValue(Rank rank,Suit suit){
//    return rank.getValue()+suit.getValue();
//
//}
}

