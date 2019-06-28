package JavaOOp.L03WorkingwithAbstraction.Exercises.p03CardsWithPower;

public enum Suit {
    CLUBS (0),
    DIAMONDS (13),
    HEARTS  (26),
    SPADES (39);
    private int value;

    Suit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
