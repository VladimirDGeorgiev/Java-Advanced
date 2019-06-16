package JavaOOp.Generics.Exercises.p10Tuple;

public class Tuple<E1,E2> {
    private E1 item1;
    private E2 item2;

    public Tuple(E1 item1, E2 item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public E1 getItem1() {
        return item1;
    }

    public void setItem1(E1 item1) {
        this.item1 = item1;
    }

    public E2 getItem2() {
        return item2;
    }

    public void setItem2(E2 item2) {
        this.item2 = item2;
    }
}
