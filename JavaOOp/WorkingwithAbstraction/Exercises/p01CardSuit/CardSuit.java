package JavaOOp.L03WorkingwithAbstraction.Exercises.p01CardSuit;

public enum CardSuit {
    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);
    private int value;

     CardSuit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
